package asupekar_lab3;

import java.util.Random;
import java.util.Scanner;

/**
 * This program generates a random number between a given range and asks user to
 * guess a number.
 * 
 * @author Aishwarya
 * @version 1.0
 *
 */
public class GuessGame {

	private int startRange;
	private int endRange;
	private int count; 
	private int target;

	/**
	 * This constructor sets the initial value of the start and end of the range.
	 * 
	 * @param start Starting range of number.
	 * @param end   Ending range if a number.
	 */
	public GuessGame(int start, int end) {
		startRange = start;
		endRange = end;
		count = 0;
	}

	/*
	 * This function displays the number of times required for guessing a number.
	 */
	void displayStatistics() {
		System.out.println("You guessed " + count + " times");
		count = 0;//Reset the guess count.
	}

	/**
	 * This function creates a random number between the given range.
	 * 
	 * @param min Start range for generating random number.
	 * @param max End range for generating random number.
	 */
	void newTarget(int min, int max) {
		Random rand = new Random();

		int num = rand.nextInt(max - min + 1) + min;
		target = num;
	}

	/**
	 * This is a getter function which returns the target value.
	 * 
	 * @return The number to be guessed.
	 */
	public int getTarget() {
		return target;
	}

	/**
	 * This function prompts user to guess the number. If the number is greater then
	 * the target, it displays a too high and if the number is too low, it displays
	 * a too low message on console.
	 * 
	 * @param num      The number to be guessed.
	 * @param start    The start range.
	 * @param end      The end range.
	 * @param keyboard For input from the user.
	 * @return boolean Is the number equal to or not equal to the target number.
	 */
	boolean guess(int num, int start, int end, Scanner keyboard) {
		int guessNumber;
		do {
			System.out.print("Guess a number between " + start + " and " + end + ": ");
			guessNumber = keyboard.nextInt();
			keyboard.nextLine();
		} while (guessNumber < start || guessNumber > end);

		displayHint(num, guessNumber);

		if (num != guessNumber) {
			count++;
			return false;
		}

		return true;
	}

	/**
	 * This function displays on the console if the number is too high or too low,
	 * by comparing the number with the target value.
	 * 
	 * @param num         The target number.
	 * @param guessNumber The number guessed by the user.
	 */
	void displayHint(int num, int guessNumber) {
		if (num < guessNumber) {
			System.out.println(guessNumber + " is too high.");
		} else if (num > guessNumber) {
			System.out.println(guessNumber + " is too low.");
		} else {
			System.out.println("That's correct!");
		}
	}

	/**
	 * This function returns the start range.
	 * 
	 * @return startRange The start range of the number.
	 */
	int getRangeMinimum() {
		return startRange;
	}

	/**
	 * This function returns the end range.
	 * 
	 * @return endRange The end range of the number.
	 */
	int getRangeMaximum() {
		return endRange;
	}
}