package duke.command;

import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

public class ByeCommand extends Command {
    public ByeCommand() {
        super(null);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        isExit = true;
        ui.printBye();
    }
}
