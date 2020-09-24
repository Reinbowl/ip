package duke.task;

import duke.exception.DukeException;
import duke.parser.DateTimeParser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate date;
    protected LocalTime time;

    /**
     * Creates a new Deadline Task with the given description, date, time and set it's taskType to Deadline.
     *
     * @param description of task.
     */
    public Event(String description, String startAt) throws DukeException {
        super(description);
        setTaskType("E");
        setDateTime(startAt);
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

    /**
     * Sets the date of the task to the given date.
     *
     * @param date to set to.
     * @throws DukeException if date fails to parse.
     */
    public void setDate(String date) throws DukeException {
        this.date = DateTimeParser.dateParser(date);
    }

    /**
     * Sets the time of the task to the given time.
     *
     * @param time to set to.
     * @throws DukeException if time fails to parse.
     */
    public void setTime(String time) throws DukeException {
        this.time = DateTimeParser.timeParser(time);
    }

    /**
     * Returns a string representation of task date and time.
     *
     * @return string representation of task date and time.
     */
    public String getDateTime() {
        return date + " " + time;
    }

    /**
     * Returns the task date as a LocalDate object.
     *
     * @return LocalDate object containing task date.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns a string representation of task in the format [taskType] [done status] description (at: date time).
     *
     * @return string representation of task.
     */
    @Override
    public String toString() {
        return super.toString() + " (at: " + date.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + " " +
                time.format(DateTimeFormatter.ofPattern("K:mm a")) + ")";
    }
}
