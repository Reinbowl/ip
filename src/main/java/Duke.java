import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private static final String LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    private static final Scanner input = new Scanner(System.in);

    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";

    private static final List<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args) {
        printWelcomeMessage();
        String userInput;
        do {
            System.out.println(LINE);
            userInput = input.nextLine().trim();
            System.out.println(LINE);
        } while (executeUserCommand(userInput));
    }

    /**
     * Prints welcome message for the bot.
     */
    private static void printWelcomeMessage() {
        System.out.println(LINE);
        System.out.println("                Hewwo! I'm UwU Bot\n"
                + "              Hwere to hwelp you out");
        System.out.println(LINE);
        System.out.println("What can I dwo fwor ywou?");
    }

    /**
     * Chooses the appropriate command base on user's input.
     * Returns false if user enters "bye" otherwise returns true.
     *
     * @param userInput user's input.
     * @return boolean value.
     */
    private static boolean executeUserCommand(String userInput) {
        try {
            String[] userWords = userInput.split(" ", 2);
            switch (userWords[0]) {
            case COMMAND_BYE:
                executeCommandBye();
                return false;
            case COMMAND_LIST:
                executeCommandList();
                break;
            case COMMAND_DONE:
                executeCommandDone(userWords);
                break;
            case COMMAND_TODO:
                executeCommandToDo(userWords);
                break;
            case COMMAND_DEADLINE:
                executeCommandDeadline(userWords);
                break;
            case COMMAND_EVENT:
                executeCommandEvent(userWords);
                break;
            default:
                System.out.println("Awoo! I don't undwerstand that command :<");
            }
        } catch (DukeException e) {
            DukeException.handleDukeException(e);
        } catch (NumberFormatException e) {
            System.out.println("Plwease give me a number :(");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("That task nwumber is not in the list.");
        }
        return true;
    }

    /**
     * Prints bye message.
     */
    private static void executeCommandBye() {
        System.out.println("Bai Bai! See ywo swoon!");
        System.out.println(LINE);
    }

    /**
     * Prints all task's type, status and description.
     */
    private static void executeCommandList() {
        if (Task.getTotalTaskNotDone() > 0) {
            System.out.println("Hwere is ywour list of tasks:");
            int counter = 1;
            for (Task t : tasks) {
                System.out.println(counter + ". " + t);
                counter++;
            }
            System.out.println("Can ywou doo the " + Task.getTotalTaskNotDone() + " remaining task?\nUwU Bot would like two help!");
        } else {
            System.out.println("Ywou have no tasks! Yay!");
        }
    }

    /**
     * Marks the task with the associated number as done and prints a message to indicate it.
     * Format is done [task number]
     *
     * @param inputTaskNum number of task to be marked as done.
     * @throws NumberFormatException if task number is missing from input.
     */
    private static void executeCommandDone(String[] inputTaskNum) throws NumberFormatException {
        if (inputTaskNum.length < 2) {
            throw new NumberFormatException();
        }
        int taskNum = Integer.parseInt(inputTaskNum[1]);
        Task completedTask = tasks.get(taskNum - 1);
        if (completedTask.isDone()) {
            System.out.println("That task is already dwone!");
            return;
        }
        completedTask.markAsDone();
        System.out.println("Niasu! I'we mwarked thwis task as done:\n" + completedTask);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left to doo");
    }

    /**
     * Adds a new task of type 'ToDo'.
     * Format is todo [task description]
     *
     * @param taskInformation to be added.
     * @throws DukeException if task information is empty.
     */
    private static void executeCommandToDo(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException(DukeException.TaskFormatException);
        }
        tasks.add(new ToDo(taskInformation[1]));
        System.out.println("UwU looks like you have to " + taskInformation[1]);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left to doo");
    }

    /**
     * Adds a new task of type 'Deadline'.
     * Format is deadline [task description] /by [due date]
     *
     * @param taskInformation of task to be added.
     * @throws DukeException if task information is empty or if due date is missing.
     */
    private static void executeCommandDeadline(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException(DukeException.TaskFormatException);
        } else if (!taskInformation[1].contains("/by")) {
            throw new DukeException(DukeException.DeadlineFormatException);
        }
        String[] taskInfo = taskInformation[1].split(" /by ", 2);
        tasks.add(new Deadline(taskInfo[0], taskInfo[1]));
        System.out.println("OwO looks like " + taskInfo[0] + " needs two be dwone by " + taskInfo[1]);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }

    /**
     * Adds a new task of type 'Event'.
     * Format is event [task description] /at [date and time]
     *
     * @param taskInformation of task to be added.
     * @throws DukeException if task information is empty or if date and time is missing.
     */
    private static void executeCommandEvent(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException(DukeException.TaskFormatException);
        } else if (!taskInformation[1].contains("/at")) {
            throw new DukeException(DukeException.EventFormatException);
        }
        String[] taskInfo = taskInformation[1].split(" /at ", 2);
        tasks.add(new Event(taskInfo[0], taskInfo[1]));
        System.out.println("Nyaa " + taskInfo[0] + " is hwappening on " + taskInfo[1] + " better rwemembwer!");
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }
}


