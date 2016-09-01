import java.util.*;

public class Connect4 {
	final static int width = 7; // row
	final static int height = 7; // col
	final static String prompt1 = "Player 1's turn: ";
	final static String prompt2 = "Player 2's turn: ";
	static char[][] field = new char[width][height];
	static Scanner scan = new Scanner(System.in);
	static int piecesPlaced = 0;

	public static void drop(char b) {
		String prompt = b == 'X' ? prompt1 : prompt2;
		int count = 0;
		System.out.println(prompt);
		int cnum = scan.nextInt(); // column number
		while (true) {
			if (count == height) {
				System.out.println("Column is full");
				System.out.println(prompt);
				count = 0;
				cnum = scan.nextInt();
				continue;
			}
			if (cnum > 7 || cnum < 1) {
				System.out.println("Invalid Column");
				count = 0;
				System.out.println(prompt);
				cnum = scan.nextInt();
				continue;
			}
			if (field[count][cnum - 1] == ' ') { // checks to see if space is
													// blank, puts X there if it
													// is
				field[count][cnum - 1] = b;
				piecesPlaced++;
				break;
			}
			count++;
		}
	}

	public static void cBoard() {
		for (int row = 0; width > row; row++) {
			for (int col = 0; height > col; col++) {
				field[row][col] = ' ';
			}
		}
	}

	public static void printBoard() {
		// prints the board
		for (int row = width - 1; row >= 0; row--) {
			System.out.print("| ");
			for (int col = 0; width > col; col++) {
				System.out.print(field[row][col] + "| ");
			}
			System.out.println();
		}
		for (int col = 0; col < 7; ++col)
			System.out.print("---");
		System.out.print("-");
		System.out.println();
	}

	public static boolean checkWin(char b) {
		// check for | vertical win
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height - 4; col++) {
				if (field[row][col] == b && field[row][col + 1] == b && field[row][col + 2] == b
						&& field[row][col + 3] == b) {
					System.out.println("Player " + (b == 'X' ? "1 " : "2 ") + "is the winner!");
					return true;
				}

			}
		}
		// check for ---- horizontal win
		for (int col = 0; col < height; col++) {
			for (int row = 0; row < width - 4; row++) {
				if (field[row][col] == b && field[row + 1][col] == b && field[row + 2][col] == b
						&& field[row + 3][col] == b) {
					System.out.println("Player " + (b == 'X' ? "1 " : "2 ") + "is the winner!");
					return true;
				}
			}
		}
		// check for / kind of diagonal win
		for (int col = 0; col < height - 3; col++) {
			for (int row = 0; row + 3 < width; row++) {
				// System.out.println("col " + col + "\t" + "row " + row);
				/*
				 * for (int i = 0; i<4; i++)
				 * System.out.println(field[row+i][col+i]);
				 */
				if (field[row][col] == b && field[row + 1][col + 1] == b && field[row + 2][col + 2] == b
						&& field[row + 3][col + 3] == b) {
					System.out.println("Player " + (b == 'X' ? "1 " : "2 ") + "is the winner!");
					return true;
				}
			}
		}
		// check for \ kind of diagonal win
		for (int col = height - 1; col - 3 >= 0; col--) {
			for (int row = 0; row + 3 < width; row++) {
				// System.out.println("col " + col + "\t" + "row " + row);
				/*
				 * for (int i = 0; i<4; i++)
				 * System.out.println(field[row+i][col-i]);
				 */
				if (field[row][col] == b && field[row + 1][col - 1] == b && field[row + 2][col - 2] == b
						&& field[row + 3][col - 3] == b) {
					System.out.println("Player " + (b == 'X' ? "1 " : "2 ") + "is the winner!");
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isTied() {
		return piecesPlaced >= width * height;
	}

