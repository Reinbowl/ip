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
        this.date = DateTimeParser.dateParser(date);
    }

    public void setTime(String time) throws DukeException {
        this.time = DateTimeParser.timeParser(time);
    }

    public String getDateTime() {
        return date + " " + time;
    }

    public LocalDate getDate() {
        return date;
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
