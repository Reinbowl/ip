package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

public class DoneCommand extends Command {
    /**
     * Creates a new DoneCommand to execute with the given information for the task completed.
     * Format is done [task number]
     * Task number should be referenced to the list with all task by calling the list command without specifying a date.
     *
     * @param information of the task completed.
     */
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
