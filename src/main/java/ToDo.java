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
}
