import java.util.List;
import java.util.ArrayList;

public class CommandControl {
    public static String line = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    private static List<Task> tasks = new ArrayList<Task>(); //make an list to store tasks

    public static boolean userCommand(String userInput) {
        System.out.println(line);
        String[] inputWords = userInput.split(" "); //split user sentence into words

        if (userInput.equals("bye")) {
            //user entered "bye"
            return false;
        } else if (userInput.equals("list")) {
            //list tasks
            if (tasks.size() == 0) {
                //list is empty
                System.out.println("Ywour task list is empty bwut its okay\nUwU Bot is always hwere fwor ywou");
            } else {
                System.out.println("Hwere is ywour list of tasks:");
                int counter = 1;
                //loop to print all tasks
                for (Task t : tasks) {
                    System.out.println(counter + ". " + "[" + t.getStatus() + "] " + t.description);
                    counter++;
                }
            }
        } else {
            if (inputWords[0].equals("done")) {
                //mark task as done
                Task completedTask = tasks.get(Integer.parseInt(inputWords[1]) - 1);
                completedTask.markAsDone();
                System.out.println("Niasu! I'we mwarked thwis task as done:\n[✓] " + completedTask.description);
            } else {
                //add new task
                tasks.add(new Task(userInput));
                System.out.println("added: " + userInput);
            }
        }

        System.out.println(line);
        return true;
    }
}
