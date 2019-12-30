package asupekar_lab2;

import java.util.Scanner;

/**
 * This is a program in which we have two competitors, one is the computer while
 * other is a user. Both of them roll a dice and depending on their value of
 * dice, the winner is decided. At the end, the winner is declared with the
 * number of wins.
 * 
 * @author Aishwarya
 * @version 1.0
 *
 */

public class DiceGame {
	/**
	 * This function calls the rollDie method for both the computer and the user,
	 * while generating a random number and comparing those with each value of
	 * computer and the user. Asks the user if they want to repeat the program.
	 * 
	 * @param args A string of arrays containing command line argument.
	 */
	public static void main(String[] args) {
		final int ROLL_COUNT = 10;
		char userInput;
		final char YES = 'y';

		Scanner keyboard = new Scanner(System.in);

		welcome();
		do 
		{
			rollDie(ROLL_COUNT, keyboard);

			System.out.print("\nReady to play? (no to quit)");
			userInput = keyboard.nextLine().toLowerCase().charAt(0);
		} while (userInput == YES);
		
		goodbye();
	}

	/**
	 * A function which displays a welcome message on the console.
	 * 
	 */
	public static void welcome() {

		System.out.println("This is a game of you versus the " + "computer. We will each\nhave one die."
				+ " We roll our own die and the higher number\n" + "wins. We roll ten times and the one "
				+ "with the higher number\nof wins is the " + "grand winner.\n");
	}

	/**
	 * A function who has a value of die for both the computer and the user. It
	 * calculates who is the winner by comparing the value of dice and the number of
	 * wins.
	 * 
	 * @param rollNo   Final number of times the program operates
	 * @param keyboard For Scanner input.
	 */
	public static void rollDie(int rollNo, Scanner keyboard) {

		LoadedDice computer = new LoadedDice(6, 30);
		LoadedDice user = new LoadedDice(1, 30);
		int computerWinCount = 0;
		int userWinCount = 0;
		int computerOutcome = 0;
		int userOutcome = 0;

		for (int i = 1; i <= rollNo; i++) {
			computerOutcome = computer.roll();
			userOutcome = user.roll();
			
			System.out.println("\nRoll " + i + " of " + rollNo);
			System.out.println("I rolled a " + computerOutcome);
			System.out.print("Ready to roll? (Press ENTER when ready)");
			keyboard.nextLine();

			System.out.println("You rolled a " + userOutcome);

			if (computerOutcome > userOutcome) {
				computerWinCount++;
			} else if (computerOutcome < userOutcome) {
				userWinCount++;
			} else {
				// Case when both roll the same outcome. Discard this iteration and repeat
				i--;
			}
		}

		System.out.println("I won " + computerWinCount + " times");
		System.out.println("You won " + userWinCount + " times");

		if (computerWinCount > userWinCount) {
			System.out.println("Grand winner is me!");
		} else if (computerWinCount < userWinCount) {
			System.out.println("Grand winner is you!");
		}
	}

	/**
	 * A goodbye message which displays a thank you message on the console.
	 */
	public static void goodbye() {
		System.out.println("\nThanks for playing!");
	}
}