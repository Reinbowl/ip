package duke.task;

import duke.exception.DukeException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate date;
    protected LocalTime time;

    /**
     * Creates a new Event Task with the given description and set it's taskType to Event.
     *
     * @param description of task.
     */
    public Event(String description, String startAt) throws DukeException {
        super(description);
        setTaskType("E");
        setDateTime(startAt);
        increaseTotalTask();
    }

    private void setDateTime(String startAt) throws DukeException {
        String[] datetime = startAt.split(" ", 2);
        setDate(datetime[0]);
        try {
            setTime(datetime[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Did ywou forget the date or the time?");
        }
    }

    public void setDate(String date) throws DukeException {
        for (String formatString : formatStrings) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);
            try {
                this.date = LocalDate.parse(date, formatter);
                return;
            } catch (DateTimeException e) {
            }
        }
        throw new DukeException("Swomething is wrong with the due date!");
    }

    public void setTime(String time) throws DukeException {
        try {
            this.time = LocalTime.parse(time);
        } catch (DateTimeException e) {
            throw new DukeException("Swomething is wrong with the time!");
        }
    }

    public String getDateTime() {
        return date + " " + time;
    }

    /**
     * Returns a string representation of event type task.
     *
     * @return string representation of task.
     */
    @Override
    public String toString() {
        return super.toString() + " (at: " + date.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + " " +
                time.format(DateTimeFormatter.ofPattern("K:mm a")) + ")";
    }
}
