package duke.ui;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.ToDo;

import java.util.ArrayList;
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
        printTaskList(taskList);
        printTotalTaskNotDone();
    }

    private void printTaskList(TaskList taskList) {
        ArrayList<Task> tasks = taskList.getTaskList();
        if (tasks.size() > 0) {
            System.out.println("Hwere is ywour list of " + Task.getTotalTask() + " tasks:");
            int counter = 1;
            for (Task t : tasks) {
                System.out.println(counter + ". " + t);
                counter++;
            }
        }
    }

    private void printTotalTaskNotDone() {
        if (Task.getTotalTaskNotDone() > 0) {
            System.out.println("Can ywou doo the " + Task.getTotalTaskNotDone() + " remaining task?\n" +
                    "UwU Bot would like two help!");
        } else {
            System.out.println("Ywou have no tasks to doo! Yay!");
        }
    }

    public void printDone(Task task) {
        System.out.println("Niasu! I'we mwarked thwis task as done:\n" + task);
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left to doo");
    }

    public void printDelete(Task task) {
        System.out.println("OwO guess it's bwye bwye to this task:\n" + task);
        System.out.println("Ywou now have " + Task.getTotalTask() + " twotal tasks in the list.");
    }

    public void printToDo(ToDo task) {
        System.out.println("UwU looks like you have to " + task.getDescription());
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left to doo");
    }

    public void printDeadline(Deadline task) {
        System.out.println("OwO looks like " + task.getDescription() + " needs two be dwone by " + task.getDueBy());
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }

    public void printEvent(Event task) {
        System.out.println("Nyaa " + task.getDescription() + " is hwappening on " + task.getStartAt() +
                " better rwemembwer!");
        System.out.println("Ywou now have " + Task.getTotalTaskNotDone() + " tasks left two do");
    }

    public void printBye() {
        System.out.println("Bai Bai! See ywo swoon!");
    }

    public void printError(String message) {
        System.out.println("Oww Nuu! " + message);
    }
}
