public class Monster {
    private String name;
    private int health, attackPower;

    // Monster constructor
    public Monster(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;

    }

    public void printStats() {
        System.out.println("Moster: " + name);
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

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) health = 0;

        System.out.println("The " + name + " takes " + damage + " damage, dropping it to " + health + " health.");

    }
}
