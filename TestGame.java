public class TestGame {
    public static void main(String[] args) {
        Player player = new Player("Player1");

        Monster goblin = new Monster("Goblin", 30, 5);

        Room cave = new Room("Cave", "A dark cave with dripping water.", true, goblin, null);

        player.printStats();
        cave.printRoomDetails();

        System.out.println("\nBattle Begins!");
        goblin.takeDamage(player.getAttackPower());

        if (goblin.getHealth() == 0) {
            System.out.println("You have defeated the goblin!");
            cave.clearMonster();

        }

        cave.printRoomDetails();

    }  
}
