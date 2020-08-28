public class Event extends Task{
    protected String startAt;

    public Event(String description, String startAt) {
        super(description);
        this.startAt = startAt;
        this.taskType = "E";
    }

    public String getStartAt() {
        return startAt;
    }

    public String getTaskType() {
        return taskType;
    }
}
