package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.ArrayList;

public class Command {
    private final String COMMAND_BYE = "bye";
    private final String COMMAND_LIST = "list";
    private final String COMMAND_DONE = "done";
    private final String COMMAND_DELETE = "delete";
    private final String COMMAND_TODO = "todo";
    private final String COMMAND_DEADLINE = "deadline";
    private final String COMMAND_EVENT = "event";

    private final ArrayList<Task> tasks;
    private final Save save;

    /**
     * Sets the default task arraylist and save to be used.
     *
     * @param tasks default arraylist to use.
     * @param save  default save to use.
     */
    public Command(ArrayList<Task> tasks, Save save) {
        this.tasks = tasks;
        this.save = save;
    }

    /**
     * Chooses the appropriate command base on user's input.
     * Returns false if user enters "bye" otherwise returns true.
     *
     * @param userInput user's input.
     * @return boolean value.
     */
    public boolean executeUserCommand(String userInput) {
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
                save.writeSave(tasks);
                break;
            case COMMAND_DELETE:
                executeCommandDelete(userWords);
                save.writeSave(tasks);
                break;
            case COMMAND_TODO:
                executeCommandToDo(userWords);
                save.writeSave(tasks);
                break;
            case COMMAND_DEADLINE:
                executeCommandDeadline(userWords);
                save.writeSave(tasks);
                break;
            case COMMAND_EVENT:
                executeCommandEvent(userWords);
                save.writeSave(tasks);
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
        return true;
    }

    /**
     * Prints bye message.
     */
    private void executeCommandBye() {
        System.out.println("Bai Bai! See ywo swoon!");
    }

    /**
     * Prints all task's type, status and description and remaining task left not done.
     */
    private void executeCommandList() {
        if (tasks.size() > 0) {
            System.out.println("Hwere is ywour list of tasks:");
            int counter = 1;
            for (Task t : tasks) {
                System.out.println(counter + ". " + t);
                counter++;
            }
        }
        if (Task.getTotalTaskNotDone() > 0) {
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
     * @param taskNumInput number of task to be marked as done.
     */
    private void executeCommandDone(String[] taskNumInput) {
        int taskNum = verifyTaskNumInput(taskNumInput);
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
     * Deletes the task with the associated number from the list and prints a message to indicate it.
     * Format is delete [task number]
     *
     * @param taskNumInput number of task to be deleted.
     */
    private void executeCommandDelete(String[] taskNumInput) {
        int taskNum = verifyTaskNumInput(taskNumInput);
        Task taskToDelete = tasks.get(taskNum - 1);
        if (!taskToDelete.isDone()) {
            Task.reduceTotalTaskNotDone();
        }
        tasks.remove(taskNum - 1);
        System.out.println("OwO guess it's bwye bwye to this task:\n" + taskToDelete);
        System.out.println("Ywou now have " + tasks.size() + " twotal tasks in the list.");
    }

    /**
     * Verifies that user input contains a task number and extracts that task number.
     *
     * @param inputTaskNum user input that contains task number.
     * @return task number as an int.
     * @throws NumberFormatException if task number is missing from input or input is not a number.
     */
    private int verifyTaskNumInput(String[] inputTaskNum) throws NumberFormatException {
        if (inputTaskNum.length < 2) {
            throw new NumberFormatException();
        }
        return Integer.parseInt(inputTaskNum[1]);
    }

    /**
     * Adds a new task of type 'ToDo'.
     * Format is todo [task description]
     *
     * @param taskInformation to be added.
     * @throws DukeException if task description is empty.
     */
    private void executeCommandToDo(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException("The twask needs a descrwiption!");
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
     * @throws DukeException if task description is empty or if due date is missing.
     */
    private void executeCommandDeadline(String[] taskInformation) throws DukeException {
        verifyDeadlineInput(taskInformation);
        String[] taskDetails = taskInformation[1].split(" /by ", 2);
        tasks.add(new Deadline(taskDetails[0], taskDetails[1]));
        System.out.println("OwO looks like " + taskDetails[0] + " needs two be dwone by " + taskDetails[1]);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }

    /**
     * Verifies that user input for deadline task has the right format.
     *
     * @param taskInformation that user inputs.
     * @throws DukeException if task description is empty or if due date is missing.
     */
    private void verifyDeadlineInput(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException("Itz a deadline twask, theres no descrwiption and dwue date/time!");
        } else if (!taskInformation[1].contains("/by")) {
            throw new DukeException("Deadline task needs a dwue date/time!");
        }
        int byPos = taskInformation[1].indexOf("/by");
        if (taskInformation[1].substring(0, byPos).isBlank()) {
            throw new DukeException("Theres no task descrwiption!");
        } else if (taskInformation[1].substring(byPos + 3).isBlank()) {
            throw new DukeException("Ewvery deadline task needs a dwue date/time!");
        }
    }

    /**
     * Adds a new task of type 'Event'.
     * Format is event [task description] /at [date and time]
     *
     * @param taskInformation of task to be added.
     * @throws DukeException if task description is empty or if date and time is missing.
     */
    private void executeCommandEvent(String[] taskInformation) throws DukeException {
        verifyEventInput(taskInformation);
        String[] taskDetails = taskInformation[1].split(" /at ", 2);
        tasks.add(new Event(taskDetails[0], taskDetails[1]));
        System.out.println("Nyaa " + taskDetails[0] + " is hwappening on " + taskDetails[1] + " better rwemembwer!");
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }

    /**
     * Verifies that user input for event task has the right format.
     *
     * @param taskInformation that user inputs.
     * @throws DukeException if task description is empty or if due date is missing.
     */
    private void verifyEventInput(String[] taskInformation) throws DukeException {
        if (taskInformation.length < 2) {
            throw new DukeException("An event task is not one without a descrwiption and a stwart date/time!");
        } else if (!taskInformation[1].contains("/at")) {
            throw new DukeException("Event task needs a stwart date/time!");
        }
        int atPos = taskInformation[1].indexOf("/at");
        if (taskInformation[1].substring(0, atPos).isBlank()) {
            throw new DukeException("I can't fwind the task descrwiption!");
        } else if (taskInformation[1].substring(atPos + 3).isBlank()) {
            throw new DukeException("To add event task, I need a stwart date/time!");
        }
    }
}
