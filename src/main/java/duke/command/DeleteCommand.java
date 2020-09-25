package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

public class DeleteCommand extends Command {
    /**
     * Creates a new DeleteCommand to execute with the given information for the task to remove.
     * Format is delete [task number]
     * Task number should be referenced to the list with all task by calling the list command without specifying a date.
     *
     * @param information of the task completed.
     */
    public DeleteCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int taskNum = Integer.parseInt(information);
        Task removedTask = tasks.getTask(taskNum);
        tasks.deleteTask(taskNum);
        ui.printDelete(tasks, removedTask);
        storage.write(tasks);
    }
}
