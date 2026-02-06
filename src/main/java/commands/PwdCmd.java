package commands;

public class PwdCmd {
    private static final String workPathDir = System.getProperty("user.dir");

    public void run(){
        System.out.println(workPathDir);
    }
}
