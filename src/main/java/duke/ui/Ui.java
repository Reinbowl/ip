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

    public void showLine() {
        System.out.println(LINE);
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void printWelcome() {
        showLine();
        System.out.println("                Hewwo! I'm UwU Bot\n"
                + "              Hwere to hwelp you out");
        showLine();
        System.out.println("What can I dwo fwor ywou?");
        showLine();
    }

    public void printList(TaskList taskList) {
        if (taskList.getTotalTask() > 0) {
            System.out.println("Hwere is ywour list of " + taskList.getTotalTask() + " tasks:");
            printTaskList(taskList);
        } else {
            System.out.println("Ywou have no tasks to doo! Yay!");
        }
    }

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

    public void printDone(Task task) {
        System.out.println("Niasu! I'we mwarked thwis task as done:\n" + task);
    }

    public void printDelete(TaskList taskList, Task task) {
        System.out.println("OwO guess it's bwye bwye to this task:\n" + task);
        System.out.println("Ywou now have " + taskList.getTotalTask() + " twotal tasks in the list.");
    }

    public void printToDo(TaskList taskList, ToDo task) {
        System.out.println("UwU neww task to do:\n" + task);
        System.out.println("Ywou now have " + taskList.getTotalTask() + " twotal tasks in the list.");
    }

    public void printDeadline(TaskList taskList, Deadline task) {
        System.out.println("OwO new deadline twask added:\n" + task);
        System.out.println("Ywou now have " + taskList.getTotalTask() + " twotal tasks in the list.");
    }

    public void printEvent(TaskList taskList, Event task) {
        System.out.println("Nyaa upcwoming event added:\n" + task);
        System.out.println("Ywou now have " + taskList.getTotalTask() + " twotal tasks in the list.");
    }

    public void printBye() {
        System.out.println("Bai Bai! See ywo swoon!");
    }

    public void printError(String message) {
        System.out.println("Oww Nuu! " + message);
    }
}
