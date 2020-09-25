package duke.command;

import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

public class ByeCommand extends Command {
    /**
     * Creates a new ByeCommand to execute.
     */
    public ByeCommand() {
        super(null);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        isExit = true;
        ui.printBye();
    }
}
