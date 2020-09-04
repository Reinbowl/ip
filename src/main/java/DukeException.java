public class DukeException extends Exception {

    public static final String TaskFormatException = "task_format_exception";
    public static final String DeadlineFormatException = "deadline_format_exception";
    public static final String EventFormatException = "event_format_exception";

    /**
     * Constructs a new exception related to Duke with the message.
     *
     * @param message of the exception.
     */
    public DukeException(String message) {
        super(message);
    }

    /**
     * Handles the exception thrown from Duke by retrieving the message.
     *
     * @param e exception thrown from Duke.
     */
    public static void handleDukeException(Exception e) {
        switch (e.getMessage()) {
        case TaskFormatException:
            System.out.println("Oopsie! I need the task infwormation!");
        case DeadlineFormatException:
            System.out.println("Ayaya! The deadline task hwas no due date!");
        case EventFormatException:
            System.out.println("Tuturu! When is the event hwappening?");
        }
    }
}
