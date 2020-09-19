package duke.command;

import duke.task.Deadline;
import duke.task.Task;
import duke.task.TaskList;

public class DeadlineCommand extends Command {
    public DeadlineCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks) {
        String[] taskDetails = information.split(" /by ", 2);
        Task newTask = new Deadline(taskDetails[0], taskDetails[1]);
        tasks.addTask(newTask);
        //print deadline from ui
    }
}
