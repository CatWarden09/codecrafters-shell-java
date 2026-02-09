package commands;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class TypeCmd {
    private static final String[] builtins = {"exit", "echo", "type", "pwd", "cd"};
    private static final String pathEnv = System.getenv("PATH");

    public void run(ParsedCommand cmd) {
        if(cmd.args().isEmpty()){
            System.out.println("Error: args for type command not found");
        } else if (Arrays.asList(builtins).contains(cmd.args().getFirst()) && cmd.args().size() == 1) {
            System.out.println(cmd.args().getFirst() + " is a shell builtin");
        } else if(!Arrays.asList(builtins).contains(cmd.args().getFirst()) && cmd.args().size() == 1) {
            String[] paths;
            paths = pathEnv.split(File.pathSeparator);
            boolean executableFound = false;

            for(String dir:paths){
                File folder = new File(dir);
                String[] files = folder.list();
                if(files != null){
                    for(String file:files){
                        Path f_path = Path.of(dir, file);
                        if(Files.isExecutable(f_path) && file.equals(cmd.args().getFirst())){
                            executableFound = true;
                            System.out.println(cmd.args().getFirst() + " is " + f_path);
                        }
                    }

                }
                if(executableFound){
                    break;
                }
            }
            if(!executableFound){
                System.out.println(cmd.args().getFirst() + ": not found");
            }

        } else{System.out.println(cmd.args().getFirst() + ": not found");
        }
    }
}
