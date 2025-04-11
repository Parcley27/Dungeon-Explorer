import java.util.ArrayList;

public class Player {
    private String name;
    private int health, attackPower;
    private ArrayList<Item> inventory = new ArrayList<>();

    // Constructor to initialize player
    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.attackPower = 10;

    }

    public void printStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Power: " + attackPower);

        viewInventory();

    }

    public String getName() {
        return name;

    }

    public int getHealth() {
        return health;

    }

    public int getAttackPower() {
        return attackPower;

    }

    public void updateName(String updatedName) {
        name = updatedName;

    }

    public void takeDamage(int damage, String monsterName) {
        health -= damage;

        if (health < 0) health = 0;

        System.out.println("You take " + damage + " damage from the " + monsterName + ", dropping you to " + health + " health.");

    }

    public void heal(int amount) {
        health = Math.min(health + amount, 100);
        System.out.println("Your health was increased to " + health + "hp.");

    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("You picked up a " + item.getName() + "!");

    }

    public void buff(int hp) {
        attackPower = attackPower + hp;
        System.out.println("Your attack power was buffed to " + attackPower + ".");

    }

    public void useItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);

            if (item.getName().equalsIgnoreCase(itemName)) {
                if (itemName.equalsIgnoreCase("heal potion")) {
                    heal(20);

                }

                if (item.getName().equalsIgnoreCase("blade shard")) {
                    buff(5);

                }

                inventory.remove(i);

            }            
        }
    }

    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty!");

        } else {
            System.out.println("Inventory:");

            for (Item item : inventory) {
                System.out.print("- ");
                item.printDetails();

            }
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;

    }
}
