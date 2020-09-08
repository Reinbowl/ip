package duke;

public class DukeException extends Exception {
    /**
     * Constructs a new exception with the message for cause of exception.
     *
     * @param message for cause of exception.
     */
    public DukeException(String message) {
        super(message);
    }

    /**
     * Returns a string representation of exception.
     *
     * @return string representation of exception.
     */
    @Override
    public String toString() {
        return "Oww Nuu! " + this.getMessage();
    }
}
