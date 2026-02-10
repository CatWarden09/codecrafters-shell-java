package commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class CdCmd {

    private final ShellConfig config;

    public CdCmd(ShellConfig config){
        this.config = config;
    }

    public void run(ParsedCommand cmd){
        Path path = null;

        if(cmd.args().isEmpty()){
            System.out.println("Error: args for cd command not found");
            return;
        }

        if(cmd.args().getFirst().contains("./") && !cmd.args().getFirst().contains("..")){
            path = parseCurrentDir(cmd.args().getFirst());
        } else if (cmd.args().getFirst().contains("../")) {
            Path parentPath = config.getWorkDir();
            int levelCount = parseParentDir(cmd.args().getFirst());
            for(int i = 1; i<=levelCount; i++){
                if(!(parentPath == null)){
                    parentPath = parentPath.getParent();
                }

            }
            if(!(parentPath == null)){
                path = parentPath;
            } else{
                System.out.println("Cannot go above root directory");
                return;
            }

        } else if (cmd.args().getFirst().contains("~") && cmd.args().size() == 1) {
            path = config.getHomeDir();
        } else {
            path = Path.of(cmd.args().getFirst());
        }


        if(Files.exists(path)){
            config.setWorkDir(path);
        } else {
            System.out.println("cd: " + path + ": No such file or directory");


        }

    }
    public Path parseCurrentDir(String cmdArg){
        String cmdPath = cmdArg.substring(1);
        return Path.of(config.getWorkDir().toString(),cmdPath);
    }

    public int parseParentDir(String cmdArg){
        String[] parsedDots = cmdArg.split("/");

        int levelsCount = 0;

        for(String dot:parsedDots){
            if(dot.equals("..")){
                levelsCount++;
            }
        }
        return levelsCount;
    }

}
