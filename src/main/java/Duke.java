import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static final String line = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    public static final Scanner input = new Scanner(System.in);

    public static List<Task> tasks = new ArrayList<Task>();     //list to store tasks

    /*********************
     *       Main        *
     *********************/
    public static void main(String[] args) {
        welcomeMessage();

        String userInput;
        //keeps looping for user input
         do {
            System.out.println(line);
            userInput = input.nextLine().trim();
            System.out.println(line);
        } while(userCommand(userInput));
    }

    /*********************
     *   Intro Message   *
     *********************/
    private static void welcomeMessage() {
        System.out.println(line);
        System.out.println("                Hewwo! I'm UwU Bot\n"
                          +"              Hwere to hwelp you out");
        System.out.println(line);
        System.out.println("What can I dwo fwor ywou?");
    }

    /*********************
     * Commands Handling *
     *********************/
    public static boolean userCommand(String userInput) {
        String[] userWords = userInput.split(" ", 2);
        switch(userWords[0]) {
        case "bye":
            commandBye();
            return false;
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
        return true;
    }

    public static void commandBye() {
        System.out.println("Bai Bai! See ywo swoon!");
        System.out.println(line);
    }

    public static void commandList() {
        if (Task.getTotalTaskNotDone() > 0) {
            System.out.println("Hwere is ywour list of tasks:");
            int counter = 1;
            //loop to print all tasks
            for (Task t : tasks) {
                System.out.println(counter + ". " + t.getTaskInformation());
                counter++;
            }
            System.out.println("Can ywou doo the " + Task.getTotalTaskNotDone() + " remaining task?\nUwU Bot would like two help!");
        } else {
            System.out.println("Ywou have no tasks! Yay!");
        }
    }

    /********************************************
     * Command: done                            *
     * input format: done (task number)         *
     ********************************************/
    public static void commandDone(int taskNum) {
        Task completedTask = tasks.get(taskNum-1);
        completedTask.markAsDone();
        System.out.println("Niasu! I'we mwarked thwis task as done:\n[✓] " + completedTask.getDescription());
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left to doo");
    }

    /********************************************
     * Command: todo                            *
     * input format: todo (task)                *
     ********************************************/
    public static void commandToDo(String taskInformation) {
        tasks.add(new ToDo(taskInformation));
        System.out.println("UwU looks like you have to " + taskInformation);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left to doo");
    }

    /********************************************
     * Command: deadline                        *
     * input format: deadline (task) /by (due)  *
     ********************************************/
    public static void commandDeadline(String taskInformation) {
        String[] taskInfo = taskInformation.split(" /by ", 2);
        tasks.add(new Deadline(taskInfo[0], taskInfo[1]));
        System.out.println("OwO looks like " + taskInfo[0] + " needs two be dwone by " + taskInfo[1]);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }

    /********************************************
     * Command: event                           *
     * input format: event (task) /at (date)    *
     ********************************************/
    public static void commandEvent(String taskInformation) {
        String[] taskInfo = taskInformation.split(" /at ", 2);
        tasks.add(new Event(taskInfo[0], taskInfo[1]));
        System.out.println("Nyaa " + taskInfo[0] + " is hwappening on " + taskInfo[1] + " better rwemembwer!");
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }
}


