package duke.task;

import duke.exception.DukeException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate date;
    protected LocalTime time;

    /**
     * Creates a new Deadline Task with the given description and set it's taskType to Deadline.
     *
     * @param description of task.
     */
    public Deadline(String description, String dueBy) throws DukeException {
        super(description);
        setTaskType("D");
        setDateTime(dueBy);
        increaseTotalTask();
    }

    private void setDateTime(String dueBy) throws DukeException {
        String[] datetime = dueBy.split(" ", 2);
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
     * Returns a string representation of duke.task.Deadline type task.
     *
     * @return string representation of task.
     */
    @Override
    public String toString() {
        return super.toString() + " (by: " + date.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + " " +
                time.format(DateTimeFormatter.ofPattern("K:mm a")) + ")";
    }
}
