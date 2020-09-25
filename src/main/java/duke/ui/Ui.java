package duke.ui;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.ToDo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ui {
    private final String LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Prints the line separator.
     */
    public void showLine() {
        System.out.println(LINE);
    }

    /**
     * Reads user input.
     *
     * @return String containing user's input.
     */
    public String readInput() {
        return scanner.nextLine().trim();
    }

    /**
     * Prints the welcome message.
     */
    public void printWelcome() {
        showLine();
        System.out.println("Hewwo! I'm UwU Bot\n"  +
                "###      ###                  ###      ###\n" +
                "###      ###                  ###      ###\n" +
                "###      ###  ###        ###  ###      ###\n" +
                "###      ###  ###   ##   ###  ###      ###\n" +
                " ##########   ###  ####  ###   ########## \n" +
                "  ########     #####  #####     ########  \n");
        showLine();
        System.out.println("What can I dwo fwor ywou?");
        showLine();
    }

    /**
     * Prints every task in the given task list.
     *
     * @param taskList to print.
     */
    public void printList(TaskList taskList) {
        if (taskList.getTotalTask() > 0) {
            System.out.println("Hwere is ywour list of " + taskList.getTotalTask() + " tasks:");
            printTaskList(taskList);
        } else {
            System.out.println("Ywou have no tasks to doo! Yay!");
        }
    }

    /**
     * Prints every task in the given task list along with the date.
     *
     * @param taskList to print.
     * @param date of task list.
     */
    public void printListOnDate(TaskList taskList, LocalDate date) {
        if (taskList.getTotalTask() > 0) {
            System.out.println("All thwis task are on " + date.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ":");
            printTaskList(taskList);
        } else {
            System.out.println("Ywou have no tasks on " + date.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + "!");
        }
    }

    private void printTaskList(TaskList taskList) {
        int counter = 1;
        for (Task t : taskList.getTaskList()) {
            System.out.println(counter + ". " + t);
            counter++;
        }
    }

    /**
     * Prints message that given task is marked as done.
     *
     * @param task marked as done.
     */
    public void printDone(Task task) {
        System.out.println("Niasu! I'we mwarked thwis task as done:\n" + task);
    }

    /**
     * Prints message that given task is deleted from the given task list.
     *
     * @param taskList that task is deleted from.
     * @param task deleted.
     */
    public void printDelete(TaskList taskList, Task task) {
        System.out.println("OwO guess it's bwye bwye to this task:\n" + task);
        System.out.println("Ywou now have " + taskList.getTotalTask() + " twotal tasks in the list.");
    }

    /**
     * Prints message that given ToDo task is added to the given task list.
     *
     * @param taskList to add task to.
     * @param task to add.
     */
    public void printToDo(TaskList taskList, ToDo task) {
        System.out.println("UwU neww todo task added:\n" + task);
        System.out.println("Ywou now have " + taskList.getTotalTask() + " twotal tasks in the list.");
    }

    /**
     * Prints message that given Deadline task is added to the given task list.
     *
     * @param taskList to add task to.
     * @param task to add.
     */
    public void printDeadline(TaskList taskList, Deadline task) {
        System.out.println("OwO new deadline twask added:\n" + task);
        System.out.println("Ywou now have " + taskList.getTotalTask() + " twotal tasks in the list.");
    }

    /**
     * Prints message that given Event task is added to the given task list.
     *
     * @param taskList to add task to.
     * @param task to add.
     */
    public void printEvent(TaskList taskList, Event task) {
        System.out.println("Nyaa upcwoming event added:\n" + task);
        System.out.println("Ywou now have " + taskList.getTotalTask() + " twotal tasks in the list.");
    }

    /**
     * Prints every task in the given task list that contains the given key.
     *
     * @param taskList of tasks that matches given key.
     * @param key that tasks match to.
     */
    public void printFind(TaskList taskList, String key) {
        if (taskList.getTotalTask() > 0) {
            System.out.println("Thwis are the tasks that match \"" + key + "\":");
            printTaskList(taskList);
        } else {
            System.out.println("Thwere is no task that matches \"" + key + "\".");
        }
    }

    /**
     * Prints the bye message.
     */
    public void printBye() {
        System.out.println("Bai Bai! See ywo swoon!");
    }

    /**
     * Prints the error message.
     *
     * @param message error message.
     */
    public void printError(String message) {
        System.out.println("Oww Nuu! " + message);
    }
}
