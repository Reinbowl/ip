import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String line = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        Scanner Input = new Scanner(System.in);
        String userInput;
        String[] Tasks = new String[100];
        int numOfTasks = 0;

        System.out.println(line);
        System.out.println("                Hewwo! I'm UwU Bot                 \n"
                          +"               （✿ ͡◕ ᴗ◕)つ━━✫・*。                  ");
        System.out.println(line);

        System.out.println("What can I dwo fwor ywu?");
        System.out.println(line);

        while(!(userInput = Input.nextLine()).equals("bye")) {
            System.out.println(line);
            switch (userInput) {
                case "list": //list tasks
                    for(int i = 1; i <= numOfTasks; i++) {
                        System.out.println(i + ". " + Tasks[i-1]);
                    }
                    break;
                default:
                    //System.out.println(userInput); //echo
                    Tasks[numOfTasks] = userInput;
                    numOfTasks++;
                    System.out.println("added: " + userInput);
            }
            System.out.println(line);
        }

        System.out.println(line);
        System.out.println("Bai Bai! See ywo swoon again!");
        System.out.println(line);
    }
}
