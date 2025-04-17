package to.pkgdo.list;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import java.util.Collections;

public class ToDoList {


    public static void main(String[] args) {
        // - To-Do List
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> tasks = new ArrayList<>();
        
        boolean stay = true;
        
        int option = 0;
        
        System.out.println("""
                           Welcome to your To-Do List!
                           
                           Type "1" to add a task!
                           
                           """);
        
        int firstInput = 0;
        while (stay){
            
            if(firstInput > 0) {
                 System.out.println("""
                                    What would you like to do now? 
                                    1. Add a task! 
                                    2. View Tasks 
                                    3. Delete a Task
                                    4. Sort Tasks
                                    5. Exit """);
            }
            
            // Checks if user is inputing a valid number/option
            boolean validOption = false;
            
            while(!validOption){
                option = scanner.nextInt();
                scanner.nextLine();
                if (option > 0 && option < 5) {
                    validOption = true;
                }
                else{
                    System.out.println("BEEEEEP!!! Not an option, please choose 1-3.");
                }
            }
            
            switch(option){
                case 1 -> {
                    AddTask(scanner, tasks);
                }
                case 2 -> {
                    DisplayTasks(tasks);
                }
                case 3 -> { // Option to remove a task!
                    DeleteTask(scanner, tasks);
                }
                case 4 -> {
                    Collections.sort(tasks);
                    DisplaySortedTasks(tasks);
                }
                case 5 -> {
                    System.out.println("Goodbyeee!");
                    stay = false;
                }
            }
            
            firstInput++;
        }
    }
    
    public static void AddTask(Scanner scanner, ArrayList<String> tasks){
        System.out.println("What is the name of your task?: (Type done"
                            + " if you dont want to add more tasks)");
        boolean done = false;
        while (!done){
            String task = scanner.nextLine();
            if (task.equalsIgnoreCase("done")){
                done = true;
            }
            else{
                tasks.add(task);
            }
        }
    }
    public static void DeleteTask(Scanner scanner, ArrayList<String> tasks){
        System.out.println("Which task would you like to remove?: (Input it's number!)");
        int taskToDelete = scanner.nextInt();
        taskToDelete = taskToDelete - 1;
        System.out.println(tasks.get(taskToDelete) + " has been removed!");  
        tasks.remove(taskToDelete);
    }
    
    public static void DisplayTasks(ArrayList<String> tasks){
        if (tasks.isEmpty()){
                        System.out.println("You have no tasks!");
                    }
                    else {
                        System.out.println("-----------------------------------");
                        System.out.println("Here are your tasks: ");
                        // START > CHECK > STEP
                        for (int i = 0; i < tasks.size(); i++){
                            System.out.println(i + 1 + ". " + tasks.get(i));
                            // tasks.get, gets the String located in its index number
                            // Which means, 0 is the first task and so on...
                        }
                        System.out.println("-----------------------------------");
                    }
    }
    public static void DisplaySortedTasks(ArrayList<String> tasks){
        if (tasks.isEmpty()){
            System.out.println("You have no tasks!");
                    }
                    else {
                        System.out.println("-----------------------------------");
                        System.out.println("Here are your sorted tasks A-Z: ");
                        // START > CHECK > STEP
                        for (int i = 0; i < tasks.size(); i++){
                            System.out.println(i + 1 + ". " + tasks.get(i));
                            // tasks.get, gets the String located in its index number
                            // Which means, 0 is the first task and so on...
                        }
                        System.out.println("-----------------------------------");
                    }
    }
}
