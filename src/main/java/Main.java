import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String cmd = sc.nextLine();


            if(cmd.contains("exit")){
                System.exit(0);
            } else if (cmd.startsWith("echo ")) {
                String echo_cmd = cmd.substring(4);
                System.out.println(echo_cmd);
            } else{System.out.println(cmd + ": " + "command not found");
            }

        }
    }
}




