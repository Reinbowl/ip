package duke.command;

import duke.DukeException;
import duke.task.TaskList;

public abstract class Command {
    protected String information;
    private static boolean isExit = false;

    public Command(String information) {
        this.information = information;
    }

    public abstract void execute(TaskList tasks) throws DukeException;

    public static void exit() {
        isExit = true;
    }

    public boolean isExit() {
        return isExit;
    }
}
