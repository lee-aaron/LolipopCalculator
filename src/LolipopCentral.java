import java.util.*;

public class LolipopCentral {
	
	protected int money;
	
	public static void main(String []args)
	{
		String mg;
		Scanner scan = new Scanner (System.in);
		LolipopGames lolipopGames = new LolipopGames();
		lolipopGames.dice.rollDice();
		for(;;){
			System.out.println("What mini-game would you like to play? Connect4, TicTacToe, or Dice Roll ");
			mg=scan.nextString();
			if(mg = "Connect4"){
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
	}
	
}
