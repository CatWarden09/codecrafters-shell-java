import commands.*;

import java.io.IOException;


public class CommandExecutor {
    private final ExitCmd exitCmd = new ExitCmd();
    private final EchoCmd echoCmd = new EchoCmd();
    private final TypeCmd typeCmd = new TypeCmd();
    private final PwdCmd pwdCmd = new PwdCmd();
    private final ExternalCmd externalCmd = new ExternalCmd();

    public void execute(ParsedCommand cmd) throws IOException {
        switch (cmd.name()){
            case "exit":
                exitCmd.run();
                break;
            case "echo":
                echoCmd.run(cmd.args());
                break;
            case "type":
                typeCmd.run(cmd);
                break;
            case "pwd":
                pwdCmd.run();
                break;
            default:
                externalCmd.run(cmd);
        }

    }
}
