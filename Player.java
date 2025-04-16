import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int health, attackPower;
    private Map<String, InventorySlot> inventory = new HashMap<>();
    private final int maxSlots = 5;

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
        String itemName = item.getName().toLowerCase();

        if (item.isStackable()) {
            InventorySlot slot = inventory.get(itemName);

            if (slot != null) {
                slot.add(1);

                System.out.println("Added another " + itemName + ". Total: " + slot.getQuantity());

            } else {
                if (inventory.size() < maxSlots) {
                    inventory.put(itemName, new InventorySlot(item, 1));

                    System.out.println("Picked up a " + itemName);

                } else {
                    System.out.println("Your inventory is full; drop something first.");

                }
            }

        } else {
            if (inventory.size() < maxSlots) {
                inventory.put(itemName, new InventorySlot(item, 1));
                System.out.println("Picked up a " + itemName);

            } else {
                System.out.println("Your inventory is full; drop something first.");

            }
        }

    }

    public void buff(int hp) {
        attackPower = attackPower + hp;
        System.out.println("Your attack power was buffed to " + attackPower + ".");

    }

    public void useItem(String itemName) {
        String key = itemName.toLowerCase();

        if (!inventory.containsKey(key)) {
            System.out.println("You do not have that item in your inventory.");

            return;

        }

        InventorySlot slot = inventory.get(key);
        Item item = slot.getItem();

        if (key.equals("heal potion")) {
            heal(20);

        } else if (key.equals("blade shard")) {
            buff(5);

        }

        inventory.remove(key);

        if (item.isStackable() && slot.getQuantity() > 1) {
            slot.remove(1);

        } else {
            inventory.remove(key);

        }
    }

    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty!");

        } else {
            System.out.println("Inventory:");

            for (InventorySlot slot : inventory.values()) {
                System.out.print("- ");

                Item item = slot.getItem();
                item.printDetails();

                System.out.print("- - Quantity: " + (item.isStackable() ? slot.getQuantity() : "1"));

            }
        }
    }

    public Map<String, InventorySlot> getInventory() {
        return inventory;

    }
}
