package duke.parser;

import duke.exception.DukeException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {
    private static final String[] dateformatStrings = {"yyyy/M/d", "yyyy-M-d", "d/M/yy", "d/M/yyyy", "d-M-yy", "d-M-yyyy"};
    private static final String[] timeformatStrings = {"h:m a", "hhmm a", "H:m", "HHmm"};

    public static LocalDate dateParser(String date) throws DukeException {
        for (String formatString : dateformatStrings) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);
            try {
                return LocalDate.parse(date, formatter);
            } catch (DateTimeException ignored) {
            }
        }
        throw new DukeException("Swomething is wrong with the date!");
    }

    public static LocalTime timeParser(String time) throws DukeException {
        time = time.toUpperCase();
        for (String formatString : timeformatStrings) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);
            try {
                return LocalTime.parse(time, formatter);
            } catch (DateTimeException ignored) {
            }
        }
        throw new DukeException("Swomething is wrong with the time!");
    }
}
