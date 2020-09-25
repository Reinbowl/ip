package duke.command;

import duke.exception.DukeException;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.task.ToDo;

public class TodoCommand extends Command {
    /**
     * Creates a new ToDoCommand to execute with the given information for new todo task.
     * Format is todo [description]
     *
     * @param information of the todo task to add.
     */
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
