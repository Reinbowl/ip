package duke.command;

import duke.task.Task;
import duke.task.TaskList;

import java.util.ArrayList;

public class ListCommand extends Command {
    public ListCommand() {
        super(null);
    }

    @Override
    public void execute(TaskList tasks) {
        ArrayList<Task> taskArrayList = tasks.getTaskList();
        //print all tasks using ui
        //print total remaining task
    }
}
