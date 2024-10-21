import java.util.Scanner;

public class DiceManager {
    // Use these values for the quick roll option.
    final int ROLLS = 1000;
    final int DICE = 2;
    final int SIDES = 6;

    // Declare variables for a DiceFactory and console input.
    private DiceFactory diceFactory;
    private Scanner input;

    /**
     * Construct a Scanner and a new DiceFactory object.
     */
    public DiceManager() {
        diceFactory = new DiceFactory();
        input = new Scanner(System.in);
    }

    /**
     * Launch the Dice Roller program menu.
     */
    public void go() {
        System.out.println("\nWelcome to Dice Roller.\n");

        int choice;
        do {
            displayMenu();
            choice = inputInt(input, "Enter your choice: ", 0, 3);

            switch (choice) {
                case 0: // Quit
                    break;
                case 1: // Quick roll
                    diceFactory.rollDice(ROLLS, SIDES, DICE);
                    System.out.println("Quick roll: two 6-sided dice rolled 1000 times.");
                    System.out.println(diceFactory.getResults());
                    break;
                case 2: // Custom roll
                    int rolls = inputInt(input, "Enter the number of rolls: ", 1, Integer.MAX_VALUE);
                    int sides = inputInt(input, "Enter the number of sides per die: ", 1, Integer.MAX_VALUE);
                    int dice = inputInt(input, "Enter the number of dice: ", 1, Integer.MAX_VALUE);
                    diceFactory.rollDice(rolls, sides, dice);
                    System.out.println(diceFactory.getResults());
                    break;
                case 3: // Results array
                    int[] resultsArray = diceFactory.getResultsArray();
                    System.out.println("Results array: " + java.util.Arrays.toString(resultsArray));
                    break;
            }
        } while (choice != 0);
    }

    /**
     * Private helper method that displays the menu.
     */
    private void displayMenu() {
        System.out.println("\nHere's the menu of choices -");
        System.out.println("0) Quit");
        System.out.printf("1) Quick roll with the default values (rolls = %d, dice = %d, sides = %d)\n", ROLLS, DICE, SIDES);
        System.out.println("2) Custom dice rolling (You enter the number of rolls, dice and sides.)");
        System.out.println("3) Get the array showing the results of the last simulation.");
    }

    /**
     * (Mostly) Error-proof method to get an int in a specified range from the user.
     */
    private int inputInt(Scanner input, String prompt, int min, int max) {
        int number = -1; // -1 Just to make the compiler happy.
        boolean nonInteger = true;
        do {
            try {
                System.out.print(prompt);
                number = Integer.parseInt(input.nextLine());

                if (number > max || number < min) {
                    System.out.printf("That number is out of range [%d to %d]. Please, try again.\n", min, max);
                }
                else {
                    nonInteger = false;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Make sure you enter an integer. Please, try again.");
            }
        } while (nonInteger);

        return number;
    }
}
