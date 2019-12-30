package asupekar_lab6;

import java.util.Scanner;

/**
 * Gets the postfix expression from the console and prints the evaluation
 * 
 * @author Aishwarya
 * @version 1.0
 */
public class RPNCalculator {
	
	/**
	 * Gets the postfix expression from the console and prints the evaluation
	 * 
	 * @param args command line args
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws IllegalArgumentException {
		
		String input;
		double answer;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("RPN Calculator");

		System.out.println("\n(blank line to quit)");
		
		// Keep asking for postfix expressions until user enters blankline
		do {
			System.out.print("calc> ");
			input = keyboard.nextLine();
		
			if(input.length() == 0) {
				System.out.print("\nBye!");
				return;
			}
		
			RPN rpn = new RPN(input);
		
			answer = rpn.evaluate();
		
			System.out.println(answer);
		}
		while(input.length() > 0);

		keyboard.close();
	}
}
