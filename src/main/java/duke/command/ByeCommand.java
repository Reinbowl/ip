package duke.command;

import duke.task.TaskList;

public class ByeCommand extends Command {
    public ByeCommand() {
        super(null);
    }

    @Override
    public void execute(TaskList tasks) {
        Command.exit();
        //print ui bye
    }
}
