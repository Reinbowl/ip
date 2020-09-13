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
     * Prints string representation of exception.
     *
     */
    public void printException() {
        System.out.println("Oww Nuu! " + this.getMessage());
    }
}
