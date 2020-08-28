import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String line = CommandControl.line;
        Scanner input = new Scanner(System.in);

        //UwU Bot introduction
        System.out.println(line);
        System.out.println("                Hewwo! I'm UwU Bot                 \n"
                          +"               （✿ ͡◕ ᴗ◕)つ━━✫・*。                  ");
        System.out.println(line);
        System.out.println("What can I dwo fwor ywu?");
        System.out.println(line);

        //keep requesting user input until method returns false when user enters "bye"
        while(CommandControl.userCommand(input.nextLine().trim())) {
        }

        System.out.println("Bai Bai! See ywo swoon!");
        System.out.println(line);
    }
}
