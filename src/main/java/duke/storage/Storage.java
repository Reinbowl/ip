package duke.storage;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String FILE_PATH;

    public Storage(String FILE_PATH) throws DukeException {
        this.FILE_PATH = FILE_PATH;
        initialise();
    }

    private void initialise() throws DukeException {
        File storageFile = new File(FILE_PATH);
        File storageFolder = new File(storageFile.getParent());
        if (storageFolder.exists() && storageFolder.isDirectory()) {
            System.out.println("Save fwolder found! Finding save file...");
        } else {
            System.out.println("No folder to store the save file! Hwold on, I can make wone...");
            if (!storageFolder.mkdir()) {
                throw new DukeException("I fwailed to create a folder for the save file!");
            }
        }
        try {
            if (storageFile.createNewFile()) {
                System.out.println("Lwooks like its your fwirst time using me! I will make a swave file!");
            } else {
                System.out.println("UwU fwound your save file!");
            }
        } catch (IOException e) {
            throw new DukeException("Somethwing bad happen while making storage file!");
        }
    }

    public ArrayList<Task> load() throws DukeException {
        Scanner reader = null;
        try {
            reader = new Scanner(new File(FILE_PATH));
        } catch (FileNotFoundException e) {
            throw new DukeException("Somethwing bad happen while trying to read the storage file!");
        }
        ArrayList<Task> tasks = new ArrayList<>();
        while (reader.hasNextLine()) {
            loadTask(reader, tasks);
        }
        return tasks;
    }

    private void loadTask(Scanner reader, ArrayList<Task> storageTasks) throws DukeException {
        Task task;
        String[] storageLine = reader.nextLine().split(",");
        for (int i = 0; i < storageLine.length; i++) {
            storageLine[i] = storageLine[i].trim();
        }
        switch (storageLine[0]) {
        case "T":
            task = new ToDo(storageLine[2]);
            break;
        case "D":
            task = new Deadline(storageLine[2], storageLine[3]);
            break;
        case "E":
            task = new Event(storageLine[2], storageLine[3]);
            break;
        default:
            throw new DukeException("Erwor reading twask!");
        }
        if (storageLine[1].equals("true")) {
            task.markAsDone();
        }
        storageTasks.add(task);
    }

    public void write(TaskList taskList) throws DukeException {
        ArrayList<Task> tasks = taskList.getTaskList();
        try {
            FileWriter writer = new FileWriter(new File(FILE_PATH));
            writeTask(writer, tasks);
            writer.close();
        } catch (IOException e) {
            throw new DukeException("Somethwing bad happen while writing to storage file!");
        }
    }

    private void writeTask(FileWriter writer, ArrayList<Task> tasks) throws IOException {
        for (Task t : tasks) {
            writer.append(String.format("%s , %b , %s ", t.getTaskType(), t.isDone(), t.getDescription()));
            switch (t.getTaskType()) {
            case "D":
                writer.append(String.format(", %s", ((Deadline) t).getDateTime()));
                break;
            case "E":
                writer.append(String.format(" , %s", ((Event) t).getDateTime()));
                break;
            }
            writer.append("\n");
        }
    }
}
