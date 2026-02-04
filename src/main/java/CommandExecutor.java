import commands.EchoCmd;
import commands.ExitCmd;
import commands.ParsedCommand;
import commands.TypeCmd;

import java.lang.reflect.Type;


public class CommandExecutor {
    private final ExitCmd exitCmd = new ExitCmd();
    private final EchoCmd echoCmd = new EchoCmd();
    private final TypeCmd typeCmd = new TypeCmd();

    public void execute(ParsedCommand cmd){
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
            default:
                System.out.println(cmd.name() + ": command not found");
        }

    }
}
