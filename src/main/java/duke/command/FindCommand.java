package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class FindCommand extends Command {
    public FindCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        TaskList tasksFound = new TaskList();
        for(Task t : tasks.getTaskList()) {
            if (t.getDescription().contains(information)) {
                tasksFound.addTask(t);
            }
        }
        ui.printFind(tasksFound, information);
    }
}
