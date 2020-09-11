package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Save {
    private final String SAVE_FOLDER_PATH = "data";
    private final String SAVE_FILE_PATH = "data/tasklist.txt";

    private File saveFile;
    private Formatter formatter;

    /**
     * Finds if a save file exists and creates the save folder and file if there isn't one.
     * Returns true if a save file exists else returns false.
     *
     * @return boolean value
     */
    public boolean locateSave() {
        File saveFolder = new File(SAVE_FOLDER_PATH);
        if (saveFolder.exists() && saveFolder.isDirectory()) {
            System.out.println("Save fwolder found! Finding save file...");
        } else {
            System.out.println("No folder to store the save file! Hwold on, I can make wone...");
            if (saveFolder.mkdir()) {
                System.out.println("Yay! We can got a fwolder for the save file now!");
            } else {
                System.out.println("Oopsie! I fwailed to create a folder for the save file!");
                return false;
            }
        }
        saveFile = new File(SAVE_FILE_PATH);
        if (!saveFile.exists()) {
            System.out.println("Lwooks like its your fwirst time using me! Making new save file...");
            try {
                formatter = new Formatter(SAVE_FILE_PATH);
                System.out.println("Tuturu! Save file created!");
            } catch (FileNotFoundException e) {
                System.out.println("Save file not found!");
            }
            return false;
        } else {
            System.out.println("UwU fwound your save file!");
        }
        return true;
    }

    /**
     * Scans the save file for any tasks saved and add them into an ArrayList.
     *
     * @return ArrayList containing tasks scanned from the save file.
     */
    public ArrayList<Task> loadSave() {
        Scanner read = null;
        try {
            read = new Scanner(saveFile);
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found!");
        }
        ArrayList<Task> saveTasks = new ArrayList<>();
        Task taskRead;
        while (read.hasNextLine()) {
            String[] saveRead = read.nextLine().split(",");
            for (int i = 0; i < saveRead.length; i++) {
                saveRead[i] = saveRead[i].trim();
            }
            switch (saveRead[0]) {
            case "T":
                taskRead = new ToDo(saveRead[2]);
                break;
            case "D":
                taskRead = new Deadline(saveRead[2], saveRead[3]);
                break;
            case "E":
                taskRead = new Event(saveRead[2], saveRead[3]);
                if (saveRead[1].equals("1")) {
                    break;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + saveRead[0]);
            }
            if (saveRead[1].equals("true")) {
                taskRead.markAsDone();
            }
            saveTasks.add(taskRead);
        }
        return saveTasks;
    }

    /**
     * Writes the tasks in the ArrayList into a format that can be read when the save file is scanned.
     *
     * @param tasks ArrayList to be written into the save file.
     */
    public void writeSave(ArrayList<Task> tasks) {
        try {
            formatter = new Formatter(SAVE_FILE_PATH);
        } catch (FileNotFoundException e) {
            System.out.println("Save file is missing!");
        }
        for (Task t : tasks) {
            formatter.format("%s , %b , %s ", t.getTaskType(), t.isDone(), t.getDescription());
            switch (t.getTaskType()) {
            case "D":
                formatter.format(", %s", ((Deadline) t).getDueBy());
                break;
            case "E":
                formatter.format(" , %s", ((Event) t).getStartAt());
                break;
            }
            formatter.format("\n");
        }
        formatter.flush();
    }
}
