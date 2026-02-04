import commands.ParsedCommand;

import java.util.Arrays;
import java.util.Scanner;

public class CommandLoop {
    public void run(){
        CommandExecutor cmdExecutor = new CommandExecutor();
        CommandParser cmdParser = new CommandParser();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String cmd = sc.nextLine();

            ParsedCommand parsed_cmd = cmdParser.parseCommand(cmd);

            if(parsed_cmd.name().isEmpty()){
                continue;
            }

            cmdExecutor.execute(parsed_cmd);
        }
    }

}
