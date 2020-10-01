# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/duke/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
```
Hewwo! I'm UwU Bot
###      ###                  ###      ###
###      ###                  ###      ###
###      ###  ###        ###  ###      ###
###      ###  ###   ##   ###  ###      ###
 ##########   ###  ####  ###   ########## 
  ########     #####  #####     ########  
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
What can I dwo fwor ywou?
```
# Table of Content

1\. **KEY FEATURES**  
- 1.1 Key features

2\. **COMMANDS**  
- 2.1 Bye  
- 2.2 Todo  
- 2.3 Deadline  
- 2.4 Event  
- 2.5 List  
- 2.6 Done  
- 2.7 Delete  
- 2.8 Find

3\. **FORMATS**  
- 3.1 Task format 
    - 3.1.1 Todo format  
    - 3.1.2 Deadline format  
    - 3.1.3 Event format  
- 3.2 Date format  
- 3.3 Time format

4\. **SUMMARY**  
- 4.1 Table of Commands


# 1 KEY FEATURES
Key features of the bot.
## 1.1 Key features
Keep track of your tasks with three different types: todo, deadline, event.
You can then list the tasks on a specific date or simply list all your tasks.
Mark tasks as done once they are completed and delete tasks that do not need to be tracked anymore.

# 2 COMMANDS
Commands to use the bot.
## 2.1 Bye  
Exits the program.
### Syntax
`bye`  

## 2.2 Todo  
Adds a task of type todo into your list.
### Syntax
`todo [task description]`  
  
`task description` description of the todo task

## 2.3 Deadline  
Adds a task of type deadline into your list.
### Syntax
`deadline [task description] /by [date] [time]`  
  
`task description` description of the deadline task  
`date` date of the deadline task    
`time` time of the deadline task  
  
*For acceptable date & time formats see section 3 on Formats*  

## 2.4 Event  
Adds a task of type event into your list.
### Syntax
`event [task description] /at [date] [time]`  
  
`task description` description of the event task  
`date` date of the event task    
`time` time of the event task  
  
*For acceptable date & time formats see section 3 on Formats*  

## 2.5 List  
Lists the tasks in your list.
### Syntax
`list [date]`
  
`date` optional input to list tasks on a specific date

*For acceptable date formats see section 3.2 on Date format*  

## 2.6 Done  
Marks the specified task from the list as done.
### Syntax
`done [task index]`

`task index` index of task to mark as done based on the task index by calling the `list` command without specifying a
date

## 2.7 Delete  
Deletes the specified task from the list.
### Syntax
`delete [task index]`

`task index` index of task to delete based on the task index by calling the `list` command without specifying a date  

## 2.8 Find
Finds the specified key in the task description of every task in the list.
### Syntax
`find [key]`

`key` key to search for in the task description

# 3 FORMATS
Interpreting bot output formats and acceptable bot input formats.  

## 3.1 Task format  
Interpreting the task output.
### 3.1.1 Todo format  
Adding a todo task will display the following:
```
todo finish project
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
UwU neww todo task added:
[T][✕] finish project
Ywou now have 1 twotal tasks in the list.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
`[T]` - stands for the task type, Todo  
`[✕]` - means that the task is not done, if the task is done a `[✓]` is displayed instead  
`finish project` - the task description  
The last line shows your total task in the list.  

### 3.1.2 Deadline format 
Adding a deadline task will display the following:
```
deadline submit report /by 2/10/20 1800
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
OwO new deadline twask added:
[D][✕] submit report (by: 2 Oct 2020 6:00 PM)
Ywou now have 1 twotal tasks in the list.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
`[D]` - stands for the task type, Deadline  
`[✕]` - means that the task is not done, if the task is done a `[✓]` is displayed instead  
`submit report` - the task description  
`2 Oct 2020` - due date of the deadline task, always displayed in day month year format  
`6:00 PM` - due time of the deadline task, always displayed in the 12-hour format  
The last line shows your total task in the list.  

### 3.1.3 Event format
Adding an event task will display the following:  
```
event project meeting /at 30/9/20 2000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Nyaa upcwoming event added:
[E][✕] project meeting (at: 30 Sep 2020 8:00 PM)
Ywou now have 1 twotal tasks in the list.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```
`[E]` - stands for the task type, Event  
`[✕]` - means that the task is not done, if the task is done a `[✓]` is displayed instead  
`project meeting` - the task description  
`30 Sep 2020` - date of the event task, always displayed in day month year format  
`8:00 PM` - time of the event task, always displayed in the 12-hour format  
The last line shows your total task in the list.  

## 3.2 Date format  
The following are acceptable date formats:  

`YYYY/M/D` example: `2020/5/6` is `6 May 2020`  
`D/M/YY` example: `2/2/20` or `2/2/2020` is `2 Feb 2020`  

Slashes `/` can be replaced with dashes `-`, example: `2020-11-5` is `5 Nov 2020`  

## 3.3 Time format
The following are acceptable time formats:

`hh:mm` example: `1:03` is `1:03 AM`  
`hh:mm aa` example: `1:03 pm` is `1:03 PM`  
`hhmm` example: `0805` is `8:05 AM`  
`hhmm aa` example: `0805 pm` is `8:05 PM`  

# 4 SUMMARY
Summary of the bot.
### 4.1 Table of Commands
Command | Command Description | Syntax  
--------|---------------------|-------  
bye | exits program | `bye`  
todo | adds a todo task | `todo [task description]`  
deadline | adds a deadline task | `deadline [task description] /by [date] [time]`  
event | adds an event task | `event [task description] /at [date] [time]`  
list | list all tasks | `list`  
list (date) | list all tasks on date | `list [date]`  
done | marks task as done | `done [task index]`  
delete | deletes task | `delete [task index]`  
find | find keyword in tasks | `find [key]`  
