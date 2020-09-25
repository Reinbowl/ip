package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.TaskList;

public class DeadlineCommand extends Command {
    /**
     * Creates a new DeadlineCommand to execute with the given information for new deadline task.
     * Format is deadline [description] /by [date] [time]
     * Acceptable date format is dd/mm/yy, yyyy/mm/dd, slashes can be replace with dashes.
     * Acceptable time format is both 12 hour and 24 hour, omitting colon requires the format hhmm.
     *
     * @param information of the deadline task to add.
     */
    public DeadlineCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] taskDetails = information.split(" /by ", 2);
        Deadline newTask = new Deadline(taskDetails[0], taskDetails[1]);
        tasks.addTask(newTask);
        ui.printDeadline(tasks, newTask);
        storage.write(tasks);
    }
}
