package commands;

import java.nio.file.Path;

public class ShellConfig {
    private Path workDir;

    public ShellConfig(){
        this.workDir = Path.of(System.getProperty("user.dir"));
    }

    public Path getWorkDir() {
        return workDir;
    }

    public void setWorkDir(Path workDir) {
        this.workDir = workDir;
    }
}
