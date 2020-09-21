package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

public class DoneCommand extends Command {
    public DoneCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int taskNum = Integer.parseInt(information);
        Task completedTask = tasks.getTask(taskNum);
        if (!completedTask.isDone()) {
            completedTask.markAsDone();
        } else {
            throw new DukeException("That task is already dwone!");
        }
        ui.printDone(completedTask);
        storage.write(tasks);
    }
}
