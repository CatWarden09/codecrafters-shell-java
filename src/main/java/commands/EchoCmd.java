package commands;

import java.util.List;

public class EchoCmd {
    public void run(List<String> args){
        if(args.isEmpty()){
            System.out.println("Error: args for echo command not found");
        } else {System.out.println(String.join(" ", args));
        }
    }
}
