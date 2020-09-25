package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.TaskList;

public class EventCommand extends Command {
    /**
     * Creates a new EventCommand to execute with the given information for new event task.
     * Format is event [description] /at [date] [time]
     * Acceptable date format is dd/mm/yy, yyyy/mm/dd, slashes can be replace with dashes.
     * Acceptable time format is both 12 hour and 24 hour, omitting colon requires the format hhmm.
     *
     * @param information of the event task to add.
     */
    public EventCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] taskDetails = information.split(" /at ", 2);
        Event newTask = new Event(taskDetails[0], taskDetails[1]);
        tasks.addTask(newTask);
        ui.printEvent(tasks, newTask);
        storage.write(tasks);
    }
}
