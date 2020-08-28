public class Deadline extends Task{
    protected String dueBy;

    public Deadline(String description, String dueBy) {
        super(description);
        setDueBy(dueBy);
        this.taskType = "D";
    }
    public void setDueBy(String dueBy) {
        String[] words = dueBy.split(" ", 2);
        this.dueBy = words[1];
    }

    public String getDueBy() {
        return dueBy;
    }

    public String getTaskType() {
        return taskType;
    }

    @Override
    public String getTaskInformation() {
        return super.getTaskInformation() + "(by: " + this.dueBy + ")";
    }
}
