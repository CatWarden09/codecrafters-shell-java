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

            String[] builtins = {"exit", "echo", "type"};

            if (cmd.startsWith("exit") && cmd.length() == 4) {
                System.exit(0);
            } else if (cmd.startsWith("echo ")) {
                String echo_cmd = cmd.substring(5);
                System.out.println(echo_cmd);
            } else if (cmd.startsWith("type ")) {
                String type_cmd = cmd.substring(5);
                if (Arrays.asList(builtins).contains(type_cmd)) {
                    System.out.println(type_cmd + " is a shell builtin");
                } else {
                    System.out.println(cmd + ": command not found");
                }

            } else {
                System.out.println(cmd + ": command not found");
            }
        }
    }
}