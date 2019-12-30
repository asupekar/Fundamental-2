package asupekar_p1;

import java.util.Scanner;

/**
 * P1 plays a tic tac toe game 
 * @author Aishwarya
 * @version 1.0 
 *
 */
public class P1 {

	private static final int MAX_ROWS = 3;
	private static final int MAX_COLS = 3;
	private final static int X_WINNER = 1;
	private final static int O_WINNER = 2;
	private final static int TIE = 0;
	private final static char YES = 'y';
	private static int xWinCount = 0;
	private static int oWinCount = 0;
	private static int tieCount = 0;

	/**
	 * This function plays a tic tac toe game for 3x3 board
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		char response;
		welcome();
		int winner;
		do {
			// Create a new board
			TicTacToe board = new TicTacToe(MAX_ROWS, MAX_COLS);
			board.printBoard();
			winner = playGame(board, keyboard);

			if (winner == X_WINNER) {
				xWinCount++;
			} else if (winner == O_WINNER) {
				oWinCount++;
			} else if (winner == TIE) {
				tieCount++;
			}

			board.gameStatus(xWinCount, oWinCount, tieCount);

			System.out.print("Do you want to play again? ");
			response = keyboard.nextLine().toLowerCase().charAt(0);
		} while (response == YES);

		goodbye();
		keyboard.close();
	}
	
	/**
	 * Plays the game and returns who was the winner. -1 represents no winner and game in progress
	 * @param board 2D matrix representing the object of TicTacToe
	 * @param keyboard for input from console
	 * @return int representing who is the winner 0 is tie, 1 is X and 2 is O, -1 is no winner
	 */
	private static int playGame(TicTacToe board, Scanner keyboard) {

		char c;
		int row, col;
		int winner = -1;

		for (int i = 0; i < 9; i++) {
			if (i % 2 == 0) {
				c = 'X';
			} else {
				c = 'O';
			}

			System.out.println(c + ", it is your turn.");
			do {
				System.out.print("Which row? ");
				row = keyboard.nextInt();
			} while (row > MAX_ROWS-1 || row < 0);
			keyboard.nextLine();
			do {
				System.out.print("Which column? ");
				col = keyboard.nextInt();
			} while (col > 2 || col < 0);
			
			keyboard.nextLine();

			// If the row and col is already taken then retry
			if (!board.setCharOnBoard(row, col, c)) {
				i--;
			}

			// check if its a tie only when the board is fully filled
			if (i == 8 && board.checkTie() == 0) {
				System.out.println("No winner - it was a tie!");
				winner = TIE;
			}
			
			// Check for winner
			if (board.checkWinner(c) == 1 || board.checkWinner(c) == 2) {

				if (board.checkWinner(c) == 1) {
					winner = X_WINNER;
				} else {
					winner = O_WINNER;
				}

				return winner;
			}
			board.printBoard();
		}

		return winner;
	}

	/**
	 * Print welcome message
	 */
	public static void welcome() {
		System.out.println("\nWelcome to TicTacToe!\n\n\n");
	}

	/**
	 * Print good bye message
	 */
	public static void goodbye() {
		System.out.println("Thank you for playing TicTacToe!");
	}
}
