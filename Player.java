public class Player {
    private String name;
    private int health, attackPower;

    // Constructor to initialize player
    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.attackPower = 10;

    }

    public void updateName(String updatedName) {
        name = updatedName;

    }

    public void printStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Power: " + attackPower);

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

    public void takeDamage(int damage, String monsterName) {
        health -= damage;

        if (health < 0) health = 0;

        System.out.println("You take " + damage + " damage from the " + monsterName + ", dropping you to " + health + " health.");

    }
    
}
