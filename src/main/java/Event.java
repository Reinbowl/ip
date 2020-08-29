public class Event extends Task{
    protected String startAt;

    public Event(String description, String startAt) {
        super(description);
        setStartAt(startAt);
        this.taskType = "E";
    }

    public void setStartAt(String startAt) {
        String[] words = startAt.split(" ", 2);
        this.startAt = words[1];
    }

    public String getStartAt() {
        return startAt;
    }

    public String getTaskType() {
        return taskType;
    }

    //returns a formatted string containing all task information
    @Override
    public String getTaskInformation() {
        return super.getTaskInformation() + "(at: " + this.startAt+ ")";
    }
}
