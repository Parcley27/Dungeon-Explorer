import java.util.Scanner;

public class DungeonExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Player1");

        boolean isRunning = true;

        Room[] dungeon = {
            new Room("Enterance", "Your starting location.", true, null, null),
            new Room("Cave", "A dark cave with dripping water.", false, new Monster("goblin", 30, 5), new Item("Potion", "Restores 20 health")),
            new Room("Corridor", "An errie, torch lit corridor.", false, null, null),
            new Room("Carving room", "A room filled with ancient carvings.", false, new Monster("skeleton", 25, 12), new Item("Blade Shard", "Boosts attack power"))

        };

        int currentRoomIndex = 0;
        
        System.out.println("\nWelcome to Dungeon Explorer!");

        System.out.print("\nPlease enter your player's name to begin: ");
        String playerName = scanner.nextLine();

        player.updateName(playerName);

        System.out.println("Welcome, " + player.getName() + "! Your adventure begins...");
        System.out.println("\nType 'help' to see available commands.");

        while (isRunning) {
            System.out.print("\n> ");
            
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "a":
                case "attack":
                    Room currentRoom = dungeon[currentRoomIndex];
                    Monster monster = currentRoom.getMoster();

                    if (monster != null) {
                        monster.takeDamage(player.getAttackPower());

                        if (monster.getHealth() == 0) {
                            System.out.println("You have defeated the " + monster.getName() + "!");
                            currentRoom.clearMonster();
                
                        } else {
                            System.out.println("\nThe " + monster.getName() + " hits you back!");
                            player.takeDamage(monster.getAttackPower(), monster.getName());

                            if (player.getHealth() == 0) {
                                System.out.println("You died to the " + monster.getName() + "!");
                                System.out.println("** GAME OVER **");
                    
                            }
                        }

                    } else {
                        System.out.println("There's nothing here to attack!");

                    }

                    break;
                
                case "h":
                case "help":
                    printHelp();

                    break;
                
                case "i":
                case "inventory":
                    player.viewInventory();
                    
                    break;
                
                case "mp":
                case "map":
                    for (Room room : dungeon) {
                        if (room.isFound()) {
                            if (room != dungeon[0]) {
                                System.out.print(" = ");

                            }

                            System.out.print(room == dungeon[currentRoomIndex] ? "[* " : "[ ");

                            System.out.print(room.getName());

                            System.out.print(room == dungeon[currentRoomIndex] ? " *]" : " ]");

                        } else {
                            System.out.print(" = [?]");
                            break;

                        }
                    }

                    System.out.println();

                    break;
                
                case "m":
                case "move":
                    System.out.print("Direction > ");

                    String direction = scanner.nextLine().toLowerCase();
                    
                    switch (direction) { 
                        case "e":                       
                        case "east":
                            if (currentRoomIndex < (dungeon.length - 1)) {
                                currentRoomIndex++;

                                System.out.println("You move east one room...");

                                dungeon[currentRoomIndex].markAsFound();
                                dungeon[currentRoomIndex].printRoomDetails();

                            } else {
                                System.out.println("You've reached this end, there's nowhere else to go east!");

                            }

                            break;
                        
                        case "w":
                        case "west":
                            if (currentRoomIndex > 0) {
                                currentRoomIndex--;

                                System.out.println("You move west one room...");

                                dungeon[currentRoomIndex].markAsFound();
                                dungeon[currentRoomIndex].printRoomDetails();

                            } else {
                                System.out.println("You've reached this end, there's nowhere else to go west!");

                            }

                            break;
                        
                        default:
                            System.out.println("Unknown command. Type 'help' for a list of commands.");

                    } 

                    break;
                
                case "p":
                case "pick up":
                    currentRoom = dungeon[currentRoomIndex];

                    if (currentRoom.hasItem()) {
                        Item foundItem = currentRoom.takeItem();
                        player.addItem(foundItem);

                    } else {
                        System.out.println("There's nothing to pick up here!");

                    }

                    break;
                
                case "r":
                case "room info":
                    dungeon[currentRoomIndex].printRoomDetails();

                    break;
                
                case "s":
                case "stats":
                    player.printStats();

                    break;

                case "q":
                case "quit":
                    System.out.println("Thank you for playing."); 
                    System.out.println("Goodbye, " + player.getName() + "!\n");

                    isRunning = false;

                    break;
                
                default:
                    System.out.println("Unknown command. Type 'help' for a list of commands.");

            }
        }

        scanner.close();

    }

    public static void printHelp() {
        System.out.println("Available Commands: ");
        System.out.println("- attack    (a)  : Attack an enemy if present");
        System.out.println("- help      (h)  : Show command help menu");
        System.out.println("- inventory (i)  : Display player inventory");
        System.out.println("- map       (mp) : Display the known dungeon map");
        System.out.println("- move      (m)  : Move into a new room");
        System.out.println("- - east    (e)  : Move east one room");
        System.out.println("- - west    (w)  : Move west one room");
        System.out.println("- pick up   (p)  : Picks up any items in the current room");
        System.out.println("- room info (r)  : Display info for the current room");
        System.out.println("- stats     (s)  : Display player stats");
        System.out.println("- quit      (q)  : End the game");

    }
    
}
