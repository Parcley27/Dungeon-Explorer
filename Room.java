public class Room {
    private String name;
    private String description;
    private boolean isFound;
    private Monster monster;
    private Item item;
    

    // Constructor
    public Room(String name, String description, boolean isFound, Monster monster, Item item) {
        this.name = name;
        this.description = description;
        this.isFound = isFound;
        this.monster = monster;
        this.item = item;

    }

    public void printRoomDetails() {
        System.out.println(name + ": " + description);

        if (monster != null) {
            System.out.println("A " + monster.getName() + " with " + monster.getHealth() + " health is here!");


        } else {
            System.out.println("This room is empty of monsters.");

        }

        if (item != null) {
            System.out.println("A " + item.getName() + " is in the room.");

        } else {
            System.out.println("No items are in this room.");
            
        }
    }

    public String getName() {
        return name;

    }

    public String getDescription() {
        return description;

    }

    public void markAsFound() {
        isFound = true;

    }

    public boolean isFound() {
        return isFound;

    }

    public Monster getMoster() {
        return monster;

    }

    public void clearMonster() {
        monster = null;

    }

    public boolean hasItem() {
        if (item != null) {
            return true;

        }

        return false;

    }

    public Item takeItem() {
        Item foundItem = item;
        item = null;

        return foundItem;

    }
}
