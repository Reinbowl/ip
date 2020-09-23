package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.TaskList;

public class EventCommand extends Command {
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
