// Andrii Malakhovtsev
// Game Character Project

public class Main {
    public static void main(String[] args) {
        GameCharacter george = new GameCharacter("George", 220.0, 10.0, 1, 2);
        GameCharacter steve = new GameCharacter("Steve", 100.0, 15.0, 1, 2);

        do {
            george.defend(steve.attack());
            System.out.println(george);
            steve.defend(george.attack());
            System.out.println(steve);
        } while (!george.isDead() && !steve.isDead());

        System.out.println();
        george.printLifeStatus();
        steve.printLifeStatus();

    }
}