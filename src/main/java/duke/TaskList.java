package duke;

import duke.task.Task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int taskNum) {
        tasks.remove(taskNum-1);
    }

    public ArrayList<Task> getTaskList() {
        return tasks;
    }
}
