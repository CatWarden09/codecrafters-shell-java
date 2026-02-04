package commands;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExternalCmd {
    private static final String pathEnv = System.getenv("PATH");

    public void run(ParsedCommand cmd) throws IOException {
        String[] paths;
        paths = pathEnv.split(File.pathSeparator);
        boolean executableFound = false;

        for(String dir:paths){
            File folder = new File(dir);
            String[] files = folder.list();
            if(files != null){
                for(String file:files){
                    Path f_path = Path.of(dir, file);
                    if(Files.isExecutable(f_path) && file.equals(cmd.name())){
                        executableFound = true;
                    }
                }

            }
            if(executableFound){
                try{
                    List<String> full_cmd = new ArrayList<>();
                    full_cmd.add(cmd.name());
                    full_cmd.addAll(cmd.args());

                    Process process = new ProcessBuilder(full_cmd).start();

                    InputStream is = process.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line;

                    while((line = reader.readLine()) != null){
                        System.out.println(line);
                    }

                    int exitCode = process.waitFor();

                    break;
                }
                catch (IOException | InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
        if(!executableFound){
            System.out.println(cmd.name() + ": command not found");
        }
    }
}
