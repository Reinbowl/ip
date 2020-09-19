package duke.command;

import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;

public class EventCommand extends Command {
    public EventCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks) {
        String[] taskDetails = information.split(" /at ", 2);
        Task newTask = new Event(taskDetails[0], taskDetails[1]);
        tasks.addTask(newTask);
        //print event
    }
}
