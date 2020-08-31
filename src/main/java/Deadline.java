public class Deadline extends Task{
    protected String dueBy;

    public Deadline(String description, String dueBy) {
        super(description);
        setDueBy(dueBy);
        this.taskType = "D";
    }
    public void setDueBy(String dueBy) {
        this.dueBy = dueBy;
    }

    public String getDueBy() {
        return dueBy;
    }

    public String getTaskType() {
        return taskType;
    }

    //returns a formatted string containing all task information
    @Override
    public String getTaskInformation() {
        return super.getTaskInformation() + " (by: " + this.dueBy + ")";
    }
}
