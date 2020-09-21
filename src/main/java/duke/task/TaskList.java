package duke.task;

import duke.exception.DukeException;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Creates a new Task ArrayList to store tasks.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates a new Task ArrayList that will include the given Task ArrayList.
     *
     * @param tasks Task ArrayList to be included on creation.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    /**
     * Adds the given task to the end of the ArrayList.
     *
     * @param task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes the task at the given index in the ArrayList.
     *
     * @param taskNum index of task to delete.
     */
    public void deleteTask(int taskNum) {
        tasks.remove(taskNum-1);
    }

    /**
     * Returns the Task ArrayList.
     *
     * @return Task ArrayList.
     */
    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    /**
     * Returns the task at the given index in the ArrayList.
     *
     * @param taskNum index of task.
     * @return task at index taskNum-1.
     * @throws DukeException if the given index is out of range.
     */
    public Task getTask(int taskNum) throws DukeException {
        try {
            return tasks.get(taskNum - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("I can't find that task nwumber in the list!");
        }
    }
}
