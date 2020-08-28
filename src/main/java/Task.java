public class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;
    private static int totalTaskNotDone = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        totalTaskNotDone++;
    }

    public String getStatus() {
        return (isDone) ? "✓" : "✕";
    }

    public void markAsDone() {
        this.isDone = true;
        reduceTotalTaskNotDone();
    }

    private static void reduceTotalTaskNotDone() {
        totalTaskNotDone--;
    }

    public static int getTotalTaskNotDone() {
        return totalTaskNotDone;
    }

    public String getTaskInformation() {
        return "[" + this.taskType + "]" + "[" + getStatus() + "] " + this.description;
    }
}
