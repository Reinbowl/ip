package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

public abstract class Command {
    protected String information;
    protected boolean isExit = false;

    /**
     * Creates a new Command to execute with the given information.
     *
     * @param information for command.
     */
    public Command(String information) {
        this.information = information;
    }

    /**
     * Executes the command on the given TaskList, prints the response with the given Ui and writes to the save file
     * in the given Storage.
     *
     * @param tasks TaskList given to execute command on.
     * @param ui containing response to print.
     * @param storage of save file to write to.
     * @throws DukeException if execution of command fails.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Returns the exit status.
     * Will only be true if ByeCommand is created.
     *
     * @return exit status.
     */
    public boolean isExit() {
        return isExit;
    }
}
