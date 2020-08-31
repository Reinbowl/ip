public class Deadline extends ToDo{
    protected String dueBy;

    /**
     * Sets task's description and type to Deadline.
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
     * Returns task's deadline.
     *
     * @return task's deadline.
     */
    public String getDueBy() {
        return dueBy;
    }

    /**
     * Returns a string representation of Deadline type task.
     *
     * @return string representation of task.
     */
    @Override
    public String toString() {
        return super.toString() + " (by: " + this.dueBy + ")";
    }
}
