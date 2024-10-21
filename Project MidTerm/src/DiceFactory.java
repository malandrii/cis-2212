import java.util.Random;

public class DiceFactory {
	// Instance variables to store the rolls, sides, and number of dice
	private int myNumberOfDice;
	private int myNumberOfRolls;
	private int myNumberOfSides;
	private int[] results;

	/**
	 * The rollDice method simulates rolling numberOfDice with numberOfSides the numberOfRolls times.
	 * The method doesn't return anything.
	 */
	public void rollDice(int numberOfRolls, int numberOfSides, int numberOfDice) {
		this.myNumberOfDice = numberOfDice;
		this.myNumberOfRolls = numberOfRolls;
		this.myNumberOfSides = numberOfSides;

		// Calculate the size of results array (from 2 to 12 for two dice)
		int minSum = myNumberOfDice;
		int maxSum = myNumberOfDice * myNumberOfSides;
		results = new int[maxSum - minSum + 1];

		Random rand = new Random();
		for (int i = 0; i < myNumberOfRolls; i++) {
			int sum = 0;
			for (int j = 0; j < myNumberOfDice; j++) {
				sum += rand.nextInt(myNumberOfSides) + 1; // Random number from 1 to numberOfSides
			}
			results[sum - minSum]++; // Increment the count for the corresponding sum
		}
	}

	/**
	 * The getResults method builds a String showing the results of the last simulation.
	 */
	public String getResults() {
		if (results == null) {
			return "No simulation has been run yet.";
		}

		StringBuilder resultStr = new StringBuilder();
		for (int i = 0; i < results.length; i++) {
			resultStr.append((i + myNumberOfDice) + ") " + results[i] + "\n");
		}
		return resultStr.toString();
	}

	/**
	 * Return an int array with the results of the last simulation.
	 */
	public int[] getResultsArray() {
		if (results == null) {
			return null;
		}

		return results.clone();
	}
}
