package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

public abstract class Command {
    protected String information;
    private static boolean isExit = false;

    public Command(String information) {
        this.information = information;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    public static void exit() {
        isExit = true;
    }

    public boolean isExit() {
        return isExit;
    }
}
