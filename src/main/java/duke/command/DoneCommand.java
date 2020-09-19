package duke.command;

import duke.DukeException;
import duke.task.Task;
import duke.task.TaskList;

public class DoneCommand extends Command {
    public DoneCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        int taskNum = Integer.parseInt(information);
        Task completedTask = tasks.getTask(taskNum);
        if (completedTask.isDone()) {
            completedTask.markAsDone();
        } else {
            throw new DukeException("That task is already dwone!");
        }
        //print done from ui
    }
}
