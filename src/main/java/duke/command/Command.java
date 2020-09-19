package duke.command;

import duke.task.Task;
import duke.task.TaskList;

public abstract class Command {
    protected String information;

    public Command(String information) {
        this.information = information;
    }

    public abstract void execute(TaskList tasks);

}
