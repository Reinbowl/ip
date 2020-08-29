import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static final String line = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    public static List<Task> tasks = new ArrayList<Task>();     //make a list to store tasks

    /*********************
     *       Main        *
     *********************/
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        welcomeMessage();

        String userInput;
        //keeps looping for user input
        while(true) {
            System.out.println(line);
            userInput = input.nextLine();
            userInput = userInput.trim();
            System.out.println(line);
            userCommand(userInput);
        }
    }

    private static void welcomeMessage() {
        //UwU Bot introduction
        System.out.println(line);
        System.out.println("                Hewwo! I'm UwU Bot                 \n"
                          +"               （✿ ͡◕ ᴗ◕)つ━━✫・*。                  ");
        System.out.println(line);
        System.out.println("What can I dwo fwor ywu?");
    }

    /*********************
     * Commands Handling *
     *********************/
    public static void userCommand(String userInput) {
        String[] userWords = userInput.split(" ", 2);
        switch(userWords[0]) {
        case "bye":
            commandBye();
            break;
        case "list":
            commandList();
            break;
        case "done":
            int taskNum = Integer.parseInt(userWords[1]);
            commandDone(taskNum);
            break;
        case "todo":
            commandToDo(userWords[1]);
            break;
        case "deadline":
            commandDeadline(userWords[1]);
            break;
        case "event":
            commandEvent(userWords[1]);
            break;
        default:
            System.out.println("Invalid command");
        }
    }

    public static void commandBye() {
        System.out.println("Bai Bai! See ywo swoon!");
        System.out.println(line);
        System.exit(0);
    }

    public static void commandList() {
        System.out.println("Hwere is ywour list of tasks:");
        int counter = 1;
        //loop to print all tasks
        for (Task t : tasks) {
            System.out.println(counter + ". " + t.getTaskInformation());
            counter++;
        }
        System.out.println("Can ywou doo all ? UwU Bot would like two help! :3");
    }

    public static void commandDone(int taskNum) {
        Task completedTask = tasks.get(taskNum-1);
        completedTask.markAsDone();
        System.out.println("Niasu! I'we mwarked thwis task as done:\n[✓] " + completedTask.description);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two doo");
    }

    public static void commandToDo(String taskInformation) {
        tasks.add(new ToDo(taskInformation));
        System.out.println("UwU looks like you have to " + taskInformation);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two doo");
    }

    public static void commandDeadline(String taskInformation) {
        String[] taskInfo = taskInformation.split("/", 2);
        tasks.add(new Deadline(taskInfo[0], taskInfo[1]));
        System.out.println("OwO looks like " + taskInfo[0] + "needs two be dwone " + taskInfo[1]);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two doo");
    }

    public static void commandEvent(String taskInformation) {
        String[] taskInfo = taskInformation.split("/", 2);
        tasks.add(new Event(taskInfo[0], taskInfo[1]));
        System.out.println("Nyaa " + taskInfo[0] + "is hwapeening on " + taskInfo[1] + " better rwemembwer!");
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two doo");
    }
}


