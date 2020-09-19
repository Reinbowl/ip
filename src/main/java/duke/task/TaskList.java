package duke.task;

import duke.DukeException;
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

    public Task getTask(int taskNum) throws DukeException {
        try {
            return tasks.get(taskNum - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("I can't find that task nwumber in the list!");
        }
    }
}
