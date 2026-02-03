import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("$ ");
        Scanner sc = new Scanner(System.in);

        List<String> valid_cmds = new ArrayList<String>();

        String cmd = sc.nextLine();

        if(!valid_cmds.contains(cmd)){
            System.out.println(cmd + ": " + "command not found");
        }

    }
}
