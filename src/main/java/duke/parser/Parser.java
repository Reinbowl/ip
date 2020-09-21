package duke.parser;

import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;
import duke.exception.DukeException;

public class Parser {
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_DELETE = "delete";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";

    public static Command parse(String userInput) throws DukeException {
        String[] userWords = userInput.split(" ", 2);
        switch (userWords[0]) {
        case COMMAND_BYE:
            return new ByeCommand();
        case COMMAND_LIST:
            return new ListCommand();
        case COMMAND_DONE:
            verifyTaskNum(userWords);
            return new DoneCommand(userWords[1]);
        case COMMAND_DELETE:
            verifyTaskNum(userWords);
            return new DeleteCommand(userWords[1]);
        case COMMAND_TODO:
            verifyTodo(userWords);
            return new TodoCommand(userWords[1]);
        case COMMAND_DEADLINE:
            verifyDeadline(userWords);
            return new DeadlineCommand(userWords[1]);
        case COMMAND_EVENT:
            verifyEvent(userWords);
            return new EventCommand(userWords[1]);
        default:
            throw new DukeException("I don't undwerstand that command :<");
        }
    }

    private static void verifyTaskNum(String[] input) throws DukeException {
        try {
            Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            throw new DukeException("Plwease give me one number :(");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("I need a twask number");
        }
    }

    private static void verifyTodo(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("The todo twask needs a descrwiption!");
        }
    }

    private static void verifyDeadline(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("Itz a deadline twask, theres no descrwiption and dwue date/time!");
        } else if (!input[1].contains("/by")) {
            throw new DukeException("Deadline task needs a dwue date/time!");
        }
        int byPos = input[1].indexOf("/by");
        if (input[1].substring(0, byPos).isBlank()) {
            throw new DukeException("Theres no task descrwiption!");
        } else if (input[1].substring(byPos + 3).isBlank()) {
            throw new DukeException("Ewvery deadline task needs a dwue date/time!");
        }
    }

    private static void verifyEvent(String[] input) throws DukeException {
        if (input.length < 2) {
            throw new DukeException("An event task is not one without a descrwiption and a stwart date/time!");
        } else if (!input[1].contains("/at")) {
            throw new DukeException("Event task needs a stwart date/time!");
        }
        int atPos = input[1].indexOf("/at");
        if (input[1].substring(0, atPos).isBlank()) {
            throw new DukeException("I can't fwind the task descrwiption!");
        } else if (input[1].substring(atPos + 3).isBlank()) {
            throw new DukeException("To add event task, I need a stwart date/time!");
        }
    }
}
