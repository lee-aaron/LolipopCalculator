import java.util.*;


public class LolipopCentral {
	static Scanner scan = new Scanner(System.in);
	protected int money;
	
	public static void main(String []args)
	{
		LolipopGames lolipopGames = new LolipopGames();
		lolipopGames.dice.rollDice();
		Connect4 CF = new Connect4(); //Connect4 Object
		for(;;){
			System.out.println("What mini-game would you like to play? Connect4, TicTacToe, or Dice Roll ");
			String mg=scan.next(); //answer for mini game
			if(mg.equalsIgnoreCase("Connect4")){
				System.out.println("hi");
				CF.Connect();
			}
			
			else if(mg.equalsIgnoreCase("TicTacToe")){
				break;
			}
			else{
				break;
			}
			
		}
	}
	
}
