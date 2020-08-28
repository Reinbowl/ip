public class Deadline extends Task{
    protected String dueBy;

    public Deadline(String description, String dueBy) {
        super(description);
        this.dueBy = dueBy;
        this.taskType = "D";
    }

    public String getDueBy() {
        return dueBy;
    }

    public String getTaskType() {
        return taskType;
    }

    public void printTaskInfo() {
        System.out.print("[" + this.taskType + "]" + " [" + this.isDone + "] " + this.description + "(by: " + this.dueBy + ")");
    }
}
