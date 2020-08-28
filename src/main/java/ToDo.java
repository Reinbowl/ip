public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
        this.taskType = "T";
    }

    public String getTaskType() {
        return taskType;
    }

    public void printTaskInfo() {
        System.out.print("[" + this.taskType + "]" + " [" + this.isDone + "] " + this.description);
    }
}
