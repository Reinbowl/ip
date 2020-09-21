package duke.task;

public class Deadline extends ToDo {
    protected String dueBy;

    /**
     * Creates a new Deadline Task with the given description and set it's taskType to Deadline.
     *
     * @param description of task.
     */
    public Deadline(String description, String dueBy) {
        super(description);
        setDueBy(dueBy);
        setTaskType("D");
    }

    /**
     * Sets the task's deadline.
     *
     * @param dueBy task's due date.
     */
    public void setDueBy(String dueBy) {
        this.dueBy = dueBy;
    }

    /**
     * Returns the task's deadline.
     *
     * @return task's due date.
     */
    public String getDueBy() {
        return dueBy;
    }

    /**
     * Returns a string representation of duke.task.Deadline type task.
     *
     * @return string representation of task.
     */
    @Override
    public String toString() {
        return super.toString() + " (by: " + this.dueBy + ")";
    }
}
