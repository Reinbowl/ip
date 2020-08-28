import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String line = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        Scanner input = new Scanner(System.in);
        List<Task> tasks = new ArrayList<Task>(); //make an list to store tasks

        //UwU Bot introduction
        System.out.println(line);
        System.out.println("                Hewwo! I'm UwU Bot                 \n"
                          +"               （✿ ͡◕ ᴗ◕)つ━━✫・*。                  ");
        System.out.println(line);
        System.out.println("What can I dwo fwor ywu?");
        System.out.println(line);

        String userInput;
        //while user does not input "bye"
        while(!(userInput = input.nextLine().trim()).equals("bye")) {
            System.out.println(line);
            if (userInput.equals("list")) {
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
                String[] inputWords = userInput.split(" "); //split user sentence into words
                if(inputWords[0].equals("done")) {
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
        }

        System.out.println(line);
        System.out.println("Bai Bai! See ywo swoon!");
        System.out.println(line);
    }
}
