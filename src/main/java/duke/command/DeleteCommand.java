package duke.command;

import duke.task.Task;
import duke.task.TaskList;

public class DeleteCommand extends Command {
    public DeleteCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks) {
        int taskNum = Integer.parseInt(information);
        Task removedTask = tasks.getTask(taskNum);
        tasks.deleteTask(taskNum);
        //print delete from ui
    }
}
