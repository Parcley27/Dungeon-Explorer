public class Room {
    private String name;
    private String description;
    private Monster monster;

    // Constructor
    public Room(String name, String description, Monster monster) {
        this.name = name;
        this.description = description;
        this.monster = monster;

    }

    public void printRoomDetails() {
        System.out.println(name + ": " + description);

        if (monster != null) {
            System.out.println("A " + monster.getName() + " with " + monster.getHealth() + " is here!");


        } else {
            System.out.println("This room is empty of monsters.");

        }
    }

    public String getName() {
        return name;

    }

    public String getDescription() {
        return description;

    }

    public Monster getMoster() {
        return monster;

    }

    public void clearMonster() {
        monster = null;

    }
}
