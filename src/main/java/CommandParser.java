import commands.ParsedCommand;

import java.util.Arrays;
import java.util.List;


public class CommandParser {
    public ParsedCommand parseCommand(String string){
        String[] cmd_list = string.trim().split("\\s+");
        String cmd = cmd_list[0];
        List<String> args = List.of(cmd_list).subList(1, cmd_list.length);

        return new ParsedCommand(cmd, args);
    }

}
