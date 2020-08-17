import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String line = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        Scanner Input = new Scanner(System.in);
        String userInput;
        Task[] tasks = new Task[100];
        int numOfTasks = 0;

        System.out.println(line);
        System.out.println("                Hewwo! I'm UwU Bot                 \n"
                          +"               （✿ ͡◕ ᴗ◕)つ━━✫・*。                  ");
        System.out.println(line);

        System.out.println("What can I dwo fwor ywu?");
        System.out.println(line);

        while(!(userInput = Input.nextLine()).equals("bye")) {
            System.out.println(line);
            if (userInput.equals("list")) {
                //list tasks
                if (numOfTasks == 0) {
                    System.out.println("Ywour task list is empty bwut its okay\nUwU Bot is always hwere fwor ywou");
                }
                for (int i = 1; i <= numOfTasks; i++) {
                    System.out.println(i + ". " + "[" + tasks[i - 1].getStatus() + "] " + tasks[i - 1].description);
                }
            } else {
                String[] arr = userInput.split(" ", 3);
                if(arr[0].equals("done")) {
                    //mark task as done
                    tasks[Integer.parseInt(arr[1]) - 1].markAsDone();
                    System.out.println("Niasu! I'we mwarked thwis task as done:\n[✓] " + tasks[Integer.parseInt(arr[1]) - 1].description);
                } else {
                    //add new task
                    tasks[numOfTasks] = new Task(userInput);
                    numOfTasks++;
                    System.out.println("added: " + userInput);
                }
            }
            System.out.println(line);
        }

        System.out.println(line);
        System.out.println("Bai Bai! See ywo swoon!");
        System.out.println(line);
    }
}
