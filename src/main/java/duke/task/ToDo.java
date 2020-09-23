package duke.task;

public class ToDo extends Task {
    /**
     * Creates a new Todo Task with the given description and set it's taskType ToDo.
     *
     * @param description of task.
     */
    public ToDo(String description) {
        super(description);
        setTaskType("T");
        increaseTotalTask();
    }
}
