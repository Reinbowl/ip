package duke.exception;

public class DukeException extends Exception {
    /**
     * Creates a new exception with the message for cause of exception.
     *
     * @param message for cause of exception.
     */
    public DukeException(String message) {
        super(message);
    }
}
