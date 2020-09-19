package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.task.ToDo;

public class TodoCommand extends Command {
    public TodoCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks) {
        Task newTask = new ToDo(information);
        tasks.addTask(newTask);
    }
}
