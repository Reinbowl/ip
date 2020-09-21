package duke.task;

public abstract class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;

    private static int totalTask = 0;
    private static int totalTaskNotDone = 0;

    /**
     * Creates a new task with the given description, default its done status to false and increase both the total
     * number of task and total number of task not done.
     *
     * @param description of task.
     */
    public Task(String description) {
        setDescription(description);
        this.isDone = false;
        totalTask++;
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
        reduceTotalTaskNotDone();
    }

    /**
     * Decreases total number of task by one.
     */
    public static void reduceTotalTask() {
        totalTask--;
    }

    /**
     * Returns total number of tasks.
     *
     * @return total number of tasks.
     */
    public static int getTotalTask() {
        return totalTask;
    }

    /**
     * Decreases total number of task not done by one.
     */
    public static void reduceTotalTaskNotDone() {
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
