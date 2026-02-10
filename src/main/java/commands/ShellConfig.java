package commands;

import java.nio.file.Path;

public class ShellConfig {
    private Path workDir;
    private final String homeDir = System.getenv("HOME"); // using the env because system property returns /root


    public ShellConfig(){
        this.workDir = Path.of(System.getProperty("user.dir"));
    }

    public Path getWorkDir() {
        return workDir;
    }

    public void setWorkDir(Path workDir) {
        this.workDir = workDir;
    }

    public Path getHomeDir() {
        return Path.of(homeDir);
    }
}

