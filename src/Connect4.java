import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Connect4 {
	
	final static int width = 7; // row
	final static int height = 7; // col
	final static String prompt1 = "Player's turn: ";
	//final static String prompt2 = "Player 2's turn: ";
	final static String prompt3 = "Computer's move:";
	static char[][] field = new char[width][height];
	static Scanner scan = new Scanner(System.in);
	static int piecesPlaced = 0;
	
	final static String prompt4 = "Player Wins!";
	final static String prompt5 = "Computer Wins!";
	
	public void drop(char b) {
		String prompt = b == 'X' ? prompt1 : prompt3;
		int count = 0;
		System.out.println(prompt);
		if(prompt.equalsIgnoreCase(prompt1)){
			int cnum = scan.nextInt(); // column number
			while (true) {
				if (count == height) {
					System.out.println("Column is full. Try Again: ");
					count = 0;
					cnum = scan.nextInt();
					continue;
				}
				if (cnum > 7 || cnum < 1) {
					System.out.println("Invalid move. Try Again: ");
					count = 0;
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
		else if(prompt.equalsIgnoreCase(prompt3)){ //Connect4 AI
			int comp = (int) Math.random() * 7;
			while(comp<7 && comp >1){
				if (count == height) {
					count = 0;
					continue;
				}
				if(field[count][comp - 1]==' '){
					field[count][comp - 1] = b;
					piecesPlaced++;
					break;
				}
			}
		}
	}

	public void cBoard() {
		for (int row = 0; width > row; row++) {
			for (int col = 0; height > col; col++) {
				field[row][col] = ' ';
			}
		}
	}

	public void printBoard() {
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
		System.out.println(" 1  2  3  4  5  6  7");
	}

	public boolean checkWin(char b) {
		// check for | vertical win
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height - 4; col++) {
				if (field[row][col] == b && field[row][col + 1] == b && field[row][col + 2] == b
						&& field[row][col + 3] == b) {
					System.out.println((b == 'X' ? prompt4: prompt5));
					return true;
				}

			}
		}
		// check for ---- horizontal win
		for (int col = 0; col < height; col++) {
			for (int row = 0; row < width - 4; row++) {
				if (field[row][col] == b && field[row + 1][col] == b && field[row + 2][col] == b
						&& field[row + 3][col] == b) {
					System.out.println((b == 'X' ? prompt4: prompt5));
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
					System.out.println((b == 'X' ? prompt4: prompt5));
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
					System.out.println((b == 'X' ? prompt4: prompt5));
					return true;
				}
			}
		}
		return false;
	}

	public boolean isTied() {
		return piecesPlaced >= width * height;
	}
	public void Connect(){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Start?(y/n):");
		char choice='y';
		try
		{
			choice=br.readLine().charAt(0);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		if(choice=='n'||choice=='N')
		{
			return;
		}
		System.out.println("Use a standard numpad as an entry grid, as so:\n ");
		
		cBoard();
		printBoard();
		System.out.println("Choose a column #1-7 to place your piece");
		while (true) {
			drop('X');
			printBoard();
			if (checkWin('X')) {
				break;
			}
			if (isTied()) {
				System.out.println("Game is tied");
				break;
			}
			drop('0');
			printBoard();
			if (checkWin('0')) {
				break;
			}
		}
	}
}
