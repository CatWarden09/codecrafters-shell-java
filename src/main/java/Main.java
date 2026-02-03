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


            switch (cmd){
                case "exit": System.exit(0);
                default: System.out.println(cmd + ": " + "command not found");
            }
            }
        }


    }

