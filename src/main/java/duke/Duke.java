package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final String LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    private static final Scanner input = new Scanner(System.in);
    private static final Save save = new Save();

    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";

    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        initialiseBot();
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
    private static void initialiseBot() {
        System.out.println(LINE);
        System.out.println("                Hewwo! I'm UwU Bot\n"
                + "              Hwere to hwelp you out");
        System.out.println(LINE);
        if (save.locateSave()) {
            tasks.addAll(save.loadSave());
        }
        System.out.println("Save file lwoaded!");
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
            e.printException();
        } catch (NumberFormatException e) {
            System.out.println("Plwease give me a number :(");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("I can't find that task nwumber in the list!");
        }
        save.writeSave(tasks);
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
        if (tasks.size() > 0 && Task.getTotalTaskNotDone() > 0) {
            System.out.println("Hwere is ywour list of tasks:");
            int counter = 1;
            for (Task t : tasks) {
                System.out.println(counter + ". " + t);
                counter++;
            }
            System.out.println("Can ywou doo the " + Task.getTotalTaskNotDone() + " remaining task?\n" +
                    "UwU Bot would like two help!");
        } else {
            System.out.println("Ywou have no tasks to doo! Yay!");
        }
    }

    /**
     * Marks the task with the associated number as done and prints a message to indicate it.
     * Format is done [task number]
     *
     * @param inputTaskNum number of task to be marked as done.
     * @throws NumberFormatException if task number is missing from input or input is not a number.
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
     * Adds a new task of type 'duke.task.ToDo'.
     * Format is todo [task description]
     *
     * @param taskInformation to be added.
     * @throws DukeException if task description is empty.
     */
    private static void executeCommandToDo(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException("The twask needs a descrwiption!");
        }

        tasks.add(new ToDo(taskInformation[1]));
        System.out.println("UwU looks like you have to " + taskInformation[1]);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left to doo");
    }

    /**
     * Adds a new task of type 'duke.task.Deadline'.
     * Format is deadline [task description] /by [due date]
     *
     * @param taskInformation of task to be added.
     * @throws DukeException if task description is empty or if due date is missing.
     */
    private static void executeCommandDeadline(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException("Itz a deadline twask, theres no descrwiption and dwue date/time!");
        } else if (!taskInformation[1].contains("/by")) {
            throw new DukeException("duke.task.Deadline task needs a dwue date/time!");
        }
        int byPos = taskInformation[1].indexOf("/by");
        if (taskInformation[1].substring(0, byPos).isBlank()) {
            throw new DukeException("Theres no task descrwiption!");
        } else if (taskInformation[1].substring(byPos + 3).isBlank()) {
            throw new DukeException("Ewvery deadline task needs a dwue date/time!");
        }

        String[] taskDetails = taskInformation[1].split(" /by ", 2);
        tasks.add(new Deadline(taskDetails[0], taskDetails[1]));
        System.out.println("OwO looks like " + taskDetails[0] + " needs two be dwone by " + taskDetails[1]);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }

    /**
     * Adds a new task of type 'duke.task.Event'.
     * Format is event [task description] /at [date and time]
     *
     * @param taskInformation of task to be added.
     * @throws DukeException if task description is empty or if date and time is missing.
     */
    private static void executeCommandEvent(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException("An event task is not one without a descrwiption and a stwart date/time!");
        } else if (!taskInformation[1].contains("/at")) {
            throw new DukeException("duke.task.Event task needs a stwart date/time!");
        }
        int atPos = taskInformation[1].indexOf("/at");
        if (taskInformation[1].substring(0, atPos).isBlank()) {
            throw new DukeException("I can't fwind the task descrwiption!");
        } else if (taskInformation[1].substring(atPos + 3).isBlank()) {
            throw new DukeException("To add event task, I need a stwart date/time!");
        }

        String[] taskDetails = taskInformation[1].split(" /at ", 2);
        tasks.add(new Event(taskDetails[0], taskDetails[1]));
        System.out.println("Nyaa " + taskDetails[0] + " is hwappening on " + taskDetails[1] + " better rwemembwer!");
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }
}


