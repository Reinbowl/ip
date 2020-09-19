package duke.command;

import duke.task.Task;
import duke.task.TaskList;

public class DoneCommand extends Command {
    public DoneCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks) {
        int taskNum = Integer.parseInt(information);
        Task completedTask = tasks.getTask(taskNum);
        completedTask.markAsDone();
        //print done from ui
    }
}
