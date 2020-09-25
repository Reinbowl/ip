package duke.task;

public abstract class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;

    /**
     * Creates a new task with the given description and default its done status to false.
     *
     * @param description of task.
     */
    public Task(String description) {
        setDescription(description);
        this.isDone = false;
    }

    /**
     * Sets task's description.
     *
     * @param description of task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the task's type.
     *
     * @param taskType of task.
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * Returns task's description.
     *
     * @return task's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns task's type.
     *
     * @return task's type.
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * Returns task's done status.
     * False if task is not done otherwise true.
     *
     * @return task's done status.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns a string representation of task's done status.
     *
     * @return string representation of task's done status.
     */
    public String getStatus() {
        return (isDone) ? "✓" : "✕";
    }

    /**
     * Sets the task's done status to true.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns a string representation of task in the format [taskType] [done status] description.
     *
     * @return string representation of task.
     */
    @Override
    public String toString() {
        return "[" + this.taskType + "]" + "[" + getStatus() + "] " + this.description;
    }
}
