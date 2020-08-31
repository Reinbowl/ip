public class ToDo extends Task {
    /**
     * Sets task's description and type to ToDo.
     *
     * @param description of task.
     */
    public ToDo(String description) {
        super(description);
        setTaskType("T");
    }

    /**
     * Returns task's type.
     *
     * @return task's type.
     */
    public String getTaskType() {
        return taskType;
    }
}
