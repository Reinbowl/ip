public class Task {
    protected String description;
    protected String taskType;
    protected boolean isDone;
    private static int totalTaskCount = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        totalTaskCount++;
    }

    public String getStatus() {
        return (isDone) ? "✓" : "✕";
    }

    public void markAsDone() {
        this.isDone = true;
    }
}
