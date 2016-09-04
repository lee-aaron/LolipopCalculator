//import java.lang.reflect.Method;
import java.util.*;

public class LolipopCentral {
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String []args) {
		System.out.println("Welcome to LolipopCentral!" + "\n" + "Here, you can play minigames and earn " + "\n" + "Lollipops to buy items in the shop" + "\n");
		
		LolipopGames lolipopGames = new LolipopGames();
		LolipopSave lolipopSave = new LolipopSave();
		//Method m = LolipopSave.class.getDeclaredMethod("LolipopSave");
		//m.setAccessible(true);
		//m.invoke(lolipopSave);
		double money = 10; // starting currency
		
		while(true){
			System.out.println("What would you like to do? ");
			System.out.println("\n" + "Game    Shop" + "\n" + "\n" + "Save    Lollipops" + "\n" + "\n" + "Quit" + "\n");
			String opt = scan.next(); //option
			if(opt.equalsIgnoreCase("Game")){ //access mini games
				for(;;){
					System.out.println("What mini-game would you like to play? Connect4, TicTacToe, or DiceRoll " + "\n" + "Enter 'Quit' to exit MiniGames" + "\n");
					String mg=scan.next(); //answer for mini game
					if(mg.equalsIgnoreCase("Connect4")){
						System.out.println("Enter 10 Lollipops to play (Y/N): " + "\n");
						String Loli = scan.next(); //Enter Lolipop currency
						if(Loli.equalsIgnoreCase("Y")){
							money =- 10;
							lolipopGames.connect.Connect();
							continue;
						}
						else{
							continue;
						}
					}
				
					else if(mg.equalsIgnoreCase("TicTacToe")){
						continue;
					}
					else if(mg.equalsIgnoreCase("DiceRoll")){
						lolipopGames.dice.rollDice();
						continue;
					}
					else{
						break;
					}
				
				}
			}
			else if(opt.equalsIgnoreCase("Shop")){ //shop
			
			}
			else if(opt.equalsIgnoreCase("Save")){ //save progress
				lolipopSave.addData(money);
				System.out.println("Your game was saved successfully" + "\n");
			}
			else if(opt.equalsIgnoreCase("Lollipops")){ //currency
				System.out.println("You have " + money + " lollipops" + "\n");
			}
			else if(opt.equalsIgnoreCase("Quit")){
				break;
			}
			else{
				System.out.println("Please enter a valid option");
				System.out.println();
				continue;
			}
		}
	}
	
}
