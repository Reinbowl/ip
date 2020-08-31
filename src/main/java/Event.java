public class Event extends ToDo{
    protected String startAt;

    /**
     * Sets task's description and type to Event.
     *
     * @param description of task.
     */
    public Event(String description, String startAt) {
        super(description);
        setStartAt(startAt);
        setTaskType("E");
    }

    /**
     * Sets the task's start date/time.
     *
     * @param startAt task's date/time.
     */
    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    /**
     * Returns task's start date/time.
     *
     * @return task's start date/time.
     */
    public String getStartAt() {
        return startAt;
    }

    /**
     * Returns a string representation of event type task.
     *
     * @return string representation of task.
     */
    @Override
    public String toString() {
        return super.toString() + " (at: " + this.startAt+ ")";
    }
}
