public abstract class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;
    private static int totalTaskNotDone = 0;

    /**
     * Sets task's description and default its done status to false and increase the total number of task not done.
     *
     * @param description of task.
     */
    public Task(String description) {
        setDescription(description);
        this.isDone = false;
        totalTaskNotDone++;
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
     * Returns task's done status.
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
        reduceTotalTaskNotDone();
    }

    /**
     * Decreases total number of task not done by one.
     */
    private static void reduceTotalTaskNotDone() {
        totalTaskNotDone--;
    }

    /**
     * Returns total number of tasks not done.
     *
     * @return total number of tasks not done.
     */
    public static int getTotalTaskNotDone() {
        return totalTaskNotDone;
    }

    /**
     * Returns a string representation of task.
     *
     * @return string representation of task.
     */
    @Override
    public String toString() {
        return "[" + this.taskType + "]" + "[" + getStatus() + "] " + this.description;
    }
}
