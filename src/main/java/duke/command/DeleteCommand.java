package duke.command;

import duke.DukeException;
import duke.task.Task;
import duke.task.TaskList;

public class DeleteCommand extends Command {
    public DeleteCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        int taskNum = Integer.parseInt(information);
        Task removedTask = tasks.getTask(taskNum);
        if (!removedTask.isDone()) {
            Task.reduceTotalTaskNotDone();
        }
        tasks.deleteTask(taskNum);
        //print delete from ui
    }
}
