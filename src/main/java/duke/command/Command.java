package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

public abstract class Command {
    protected String information;
    protected boolean isExit = false;

    public Command(String information) {
        this.information = information;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return isExit;
    }
}
