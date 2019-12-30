package asupekar_lab6;

import java.util.Scanner;

/**
 * RPN validates and evaluates a postfix expression using stack
 * 
 * @author Aishwarya
 * @version 1.0
 */
public class RPN {

	private String exp;
	private Scanner scan;
	private ArrayStack stack;

	/**
	 * Constructor to initialize stack, scanner and expression string
	 * @param exp Postfix expression
	 */
	public RPN(String exp) {
		this.exp = exp;
		scan = new Scanner(exp);
		stack = new ArrayStack(10);
	}

	/**
	 * Evaluates the postfix expression
	 * @return result of the expression string
	 */
	public double evaluate() {

		double result = 0.0;

		// Check if the exp has enough operators
		if (!validPostfix(exp)) {
			throw new IllegalArgumentException("not enough operators!");
		}

		// Scan each string from expression separated by a space
		while (scan.hasNext()) {
			// It's an operand
			if (scan.hasNextDouble()) {
				stack.push(Double.parseDouble(scan.next()));
			} 
			// Could be an operator
			else {
				performOperation(scan.next());
			}
		}
		result = stack.pop();
		return result;
	}

	/**
	 * Checks whether the expression is correct
	 * @param exp postfix expression
	 * @return true if it is a valid expression
	 */
	private boolean validPostfix(String exp) {
		int operatorCount = 0;
		int operandCount = 0;

		Scanner scan = new Scanner(exp);

		while (scan.hasNext()) {
			if (scan.hasNextDouble()) {
				operandCount++;
			} else {
				operatorCount++;
			}
			scan.next();
		}
		
		scan.close();
		
		if((operandCount - operatorCount) <= 1) {
			return true;
		}

		return false;
	}

	/**
	 * Performs add, subtract, multiply, divide operations
	 * @param operator to be applied on operands
	 */
	private void performOperation(String operator) {

		if (stack.size() < 2) {
			throw new IllegalArgumentException("too many operators!");
		}

		double a = stack.pop();
		double b = stack.pop();

		switch (operator) {
		case "+":
			stack.push(a + b);
			break;
		case "-":
			stack.push(b - a);
			break;
		case "*":
			stack.push(a * b);
			break;
		case "/":
			stack.push(b / a);
			break;
		default:
			throw new IllegalArgumentException("Unknown operator: " + operator);
		}
	}
}
