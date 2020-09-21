package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

public class ListCommand extends Command {
    public ListCommand() {
        super(null);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ui.printList(tasks);
    }
}
