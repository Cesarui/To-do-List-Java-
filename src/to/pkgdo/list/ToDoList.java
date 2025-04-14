package to.pkgdo.list;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {


    public static void main(String[] args) {
        // - To-Do List
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> tasks = new ArrayList<>();
        
        boolean stay = true;
        
        int option = 0;
        
        System.out.println("What would you like to do? "
                    + "\n1. Add a task! "
                    + "\n2. View Tasks "
                    + "\n3. Exit ");
        
        int firstInput = 0;
        
        while (stay){
            
            if(firstInput > 0) {
                 System.out.println("What would you like to do now? "
                    + "\n1. Add a task! "
                    + "\n2. View Tasks "
                    + "\n3. Exit ");
            }
            
            boolean validOption = false;
            
            while(!validOption){
                option = scanner.nextInt();
                scanner.nextLine();
                if (option > 0 && option < 4) {
                    validOption = true;
                }
                else{
                    System.out.println("BEEEEEP!!! Not an option, please choose 1-3.");
                }
            }
            
            switch(option){
                case 1:
                    System.out.println("What is the name of your task?: (Type done"
                    + " if you dont want to add more tasks)");
                    AddTask(scanner, tasks);
                    break;
                case 2:
                System.out.println("-----------------------------------");
                System.out.println("Here are your tasks: ");
                // START > CHECK > STEP
                for (int i = 0; i < tasks.size(); i++){
                    System.out.println(i + 1 + ". " + tasks.get(i)); 
                    // tasks.get, gets the String located in its index number
                    // Which means, 0 is the first task and so on...
                }
                System.out.println("-----------------------------------");
                break;
                case 3:
                System.out.println("Goodbyeee!");
                stay = false;
                break;
            }
            
            firstInput++;
        }
        
        
        
        
    }
    
    public static void AddTask(Scanner scanner, ArrayList<String> tasks){
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
    
}
