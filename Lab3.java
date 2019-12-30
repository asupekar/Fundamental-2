package asupekar_lab3;

import java.util.Scanner;

/**
 * This program allows the user to guess a number between a range decided by the
 * user. If the guess is too high or too low, the program will display an output
 * respectively.
 * 
 * @author Aishwarya
 * @version 1.0
 *
 */

public class Lab3 {
	/**
	 * This program prompts user to guess a number between a given range and
	 * displays whether the number is too high or too low. And if the number is
	 * correct to the target number, it displays that the value is correct.
	 * 
	 * @param args A String containing arguments from command line.
	 */
	public static void main(String[] args) {

		boolean flag = false;
		final char YES = 'y';
		char response;
		final int MIN_RANGE = 100;
		final int MAX_RANGE = 200;
		welcome();
		
		Scanner keyboard = new Scanner(System.in);
		
		GuessGame game = new GuessGame(MIN_RANGE, MAX_RANGE);
		
		do {		
			game.newTarget(game.getRangeMinimum(), game.getRangeMaximum());

			int target;
			do {
				target = game.getTarget();
				flag = game.guess(target, game.getRangeMinimum(), game.getRangeMaximum(), keyboard);
			} while (!flag);

			game.displayStatistics();

			System.out.print("\nReady to play again? (no to quit) ");
			String userInput = keyboard.nextLine();
			System.out.println();
			response = userInput.toLowerCase().charAt(0);
		} while (response == YES);

		goodbye();
		keyboard.close();
	}

	/**
	 * This function displays a welcome message on the console.
	 */
	public static void welcome() {
		System.out.println("This is a guessing game where you will guess a number\n"
				+ "and I tell you if it is too low or too high.\n\n");
	}

	/**
	 * This function displays a thank you message on the console.
	 */
	public static void goodbye() {
		System.out.println("Thanks for playing!");
	}
}
