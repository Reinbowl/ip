package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.task.ToDo;

public class TodoCommand extends Command {
    public TodoCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ToDo newTask = new ToDo(information);
        tasks.addTask(newTask);
        ui.printToDo(tasks, newTask);
        storage.write(tasks);
    }
}
