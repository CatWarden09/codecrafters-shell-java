package commands;

import java.nio.file.Files;
import java.nio.file.Path;


public class CdCmd {

    private final ShellConfig config;

    public CdCmd(ShellConfig config){
        this.config = config;
    }

    public void run(ParsedCommand cmd){
        if(cmd.args().isEmpty()){
            System.out.println("Error: args for cd command not found");
            return;
        }

        Path path = Path.of(cmd.args().getFirst());

        if(Files.exists(path)){
        config.setWorkDir(path);
        } else {
            System.out.println("cd: " + path + ": No such file or directory");


        }

    }
}
