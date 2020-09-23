package duke.command;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

import java.time.LocalDate;

public class ListCommand extends Command {
    private LocalDate date;

    public ListCommand() {
        super(null);
        date = null;
    }

    public ListCommand(LocalDate date) {
        super(null);
        this.date = date;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (date == null) {
            ui.printList(tasks);
        } else {
            TaskList tasksOnDate = new TaskList();
            for (Task t : tasks.getTaskList()) {
                if (t instanceof Deadline && ((Deadline) t).getDate().equals(date)) {
                    tasksOnDate.addTask(t);
                } else if (t instanceof Event && ((Event) t).getDate().equals(date)) {
                    tasksOnDate.addTask(t);
                }
            }
            ui.printListOnDate(tasksOnDate, date);
        }
    }
}
