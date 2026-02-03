import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<String> valid_cmds = new ArrayList<>();

        do {
            System.out.println("$ ");
            String cmd = sc.nextLine();
            if (!valid_cmds.contains(cmd)) {
                System.out.println(cmd + ": " + "command not found");
            }
        } while (true);


    }
}
