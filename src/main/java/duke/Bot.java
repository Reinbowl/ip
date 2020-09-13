package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Bot {
    private final String LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    private final Scanner input = new Scanner(System.in);

    private final ArrayList<Task> tasks = new ArrayList<>();
    private final String SAVE_FOLDER_PATH = "data";
    private final String SAVE_FILE_PATH = "data/tasklist.txt";
    private final Save save = new Save(SAVE_FOLDER_PATH, SAVE_FILE_PATH);
    private final Command command = new Command(tasks, save);

    /**
     * Set-up the bot and start it.
     */
    public void startBot() {
        initialiseBot();
        runBot();
    }

    /**
     * Prints welcome message for the bot and loads old save file or create one.
     */
    private void initialiseBot() {
        System.out.println(LINE);
        System.out.println("                Hewwo! I'm UwU Bot\n"
                + "              Hwere to hwelp you out");
        System.out.println(LINE);
        findSave();
        System.out.println(LINE);
        System.out.println("What can I dwo fwor ywou?");
    }

    /**
     * Begin the bot for user to use.
     */
    private void runBot() {
        String userInput;
        do {
            System.out.println(LINE);
            userInput = input.nextLine().trim();
            System.out.println(LINE);
        } while (command.executeUserCommand(userInput));
    }

    /**
     * Finds the save file at the default location and load it, creates one if one does not exist.
     */
    private void findSave() {
        if (save.locateSave()) {
            tasks.addAll(save.loadSave());
        }
        System.out.println("Save file lwoaded!");
    }
}
