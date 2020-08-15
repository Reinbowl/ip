import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String line = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        Scanner Input = new Scanner(System.in);
        String userInput;

        System.out.println(line);
        System.out.println("                Hewwo! I'm UwU Bot                 \n"
                          +"               （✿ ͡◕ ᴗ◕)つ━━✫・*。                  ");
        System.out.println(line);

        System.out.println("What can I dwo fwor ywu?");
        System.out.println(line);

        while(!(userInput = Input.nextLine()).equals("bye")) {
            System.out.println(line);
            System.out.println(userInput);
            System.out.println(line);
        }

        System.out.println("Bai Bai! See ywo swoon again!");
        System.out.println(line);

    }
}
