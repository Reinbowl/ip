package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.TaskList;

public class DeadlineCommand extends Command {
    public DeadlineCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] taskDetails = information.split(" /by ", 2);
        Deadline newTask = new Deadline(taskDetails[0], taskDetails[1]);
        tasks.addTask(newTask);
        ui.printDeadline(newTask);
        storage.write(tasks);
    }
}
