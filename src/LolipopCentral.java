import java.util.*;

public class LolipopCentral {
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String []args) {
		System.out.println("Welcome to LolipopCentral!" + "\n" + "Here, you can play mini-games and earn points (a.k.a Lollipops)." + "\n" + "Have Fun! :)" +"\n" + "P.S. Everything here is Text-Based");
		LolipopGames lolipopGames = new LolipopGames();
		//LolipopSave lolipopSave = new LolipopSave();
		//Method m = LolipopSave.class.getDeclaredMethod("LolipopSave");
		//m.setAccessible(true);
		//m.invoke(lolipopSave);
		Boolean settings = true;
		double points = 0; //point counter
		while(settings){
			System.out.println("What would you like to do? ");
			System.out.println("\n" + "Game    Save" + "\n" + "\n" + "Lollipops    Quit" + "\n" + "\n");
			String opt = scan.next(); //option
			if(opt.equalsIgnoreCase("Game")){ //access mini games
				for(;;){
					System.out.println("What mini-game would you like to play? Connect4 or TicTacToe " + "\n" + "Enter 'Quit' to exit MiniGames" + "\n");
					String mg=scan.next(); //answer for mini game
					if(mg.equalsIgnoreCase("Connect4")){
						lolipopGames.connect.Connect();
						continue;
					}
					
				
					else if(mg.equalsIgnoreCase("TicTacToe")){
						lolipopGames.ttt.startMatch();
						continue;
					}

					else if(mg.equalsIgnoreCase("Quit")){
						break;
					}
					else{
						System.out.println("Please enter a valid option: ");
						mg=scan.next();
						continue;
					}
				
				}
			}

			else if(opt.equalsIgnoreCase("Save")){ //save progress
				//lolipopSave.addData(money);
				System.out.println("Your game was saved successfully" + "\n");
			}
			else if(opt.equalsIgnoreCase("Lollipops")){ //currency
				System.out.println("You have " + points + " lollipops" + "\n");
			}
			else if(opt.equalsIgnoreCase("Quit")){
				settings = false;
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
