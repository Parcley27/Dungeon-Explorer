import java.util.Scanner;

public class DungeonExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        Player player = new Player("Player1");
        
        System.out.println("Welcome to Dungeon Explorer!");
        System.out.println("Type 'help' to see available commands.");

        while (isRunning) {
            System.out.print("\n> ");
            
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "help":
                    printHelp();

                    break;
                
                case "explore":
                    System.out.println("Run explore function");

                    break;

                case "attack":
                    System.out.println("Run attack function");

                    break;

                case "quit":
                    System.out.println("Thank you for playing."); 
                    System.out.println("Goodbye!");

                    isRunning = false;

                    break;
            }
        }

        scanner.close();

    }

    public static void printHelp() {
        System.out.println("Available Commands: ");
        System.out.println("- attack   : Attack an enemy if present");
        System.out.println("- explore  : Move into a new room");
        System.out.println("- help     : Shows command help menu");
        System.out.println("- quit     : End the game");

    }
    
}
