package commands;

import java.nio.file.Path;

public class PwdCmd {
    private Path workPathDir = Path.of(System.getProperty("user.dir"));
    private final ShellConfig config;

    public PwdCmd(ShellConfig config){
        this.config = config;
    }

    public void run(){
        System.out.println(workPathDir);
    }

    public void updateWorkDir(){
        this.workPathDir = config.getWorkDir();
    }
}
