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
    private Formatter saveText;

    public boolean locateSave() {
        File saveFolder = new File(SAVE_FOLDER_PATH);
        if(saveFolder.exists() && saveFolder.isDirectory()) {
            System.out.println("Save fwolder found! Finding save file...");
        } else {
            System.out.println("No folder to store the save file! Hwold on, I can make wone...");
            if(saveFolder.mkdir()) {
                System.out.println("Yay! We can got a fwolder for the save file now!");
            } else {
                System.out.println("Oopsie! I fwailed to create a folder for the save file!");
                return false;
            }
        }
        saveFile = new File(SAVE_FILE_PATH);
        if(!saveFile.exists()) {
            System.out.println("Lwooks like its your fwirst time using me! Making new save file...");
            try {
                saveText = new Formatter(SAVE_FILE_PATH);
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

    public ArrayList<Task> loadSave() {
        Scanner read = null;
        try {
            read = new Scanner(saveFile);
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found!");
        }
        ArrayList<Task> saveTasks = new ArrayList<>();
        Task taskRead;
        while(read.hasNextLine()) {
            String[] saveRead = read.nextLine().split(",");
            for(int i = 0; i < saveRead.length; i++) {
                saveRead[i] = saveRead[i].trim();
            }
            switch(saveRead[0]) {
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
            if (saveRead[1].equals("1")) {
                taskRead.markAsDone();
            }
            saveTasks.add(taskRead);
        }
        return saveTasks;
    }
}
