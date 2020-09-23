package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

public class DeleteCommand extends Command {
    public DeleteCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int taskNum = Integer.parseInt(information);
        Task removedTask = tasks.getTask(taskNum);
        if (!removedTask.isDone()) {
            Task.reduceTotalTaskNotDone();
        }
        tasks.deleteTask(taskNum);
        ui.printDelete(tasks, removedTask);
        storage.write(tasks);
    }
}
