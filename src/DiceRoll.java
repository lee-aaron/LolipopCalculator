import java.util.*;

public class DiceRoll {

	Long dice, dicey;
	String odds, hiLow, rolls;
	int roll;
	double money;
	static Scanner scan = new Scanner (System.in);
	
	public DiceRoll() {

	}
	
	//Configure for dice game
	public int diceConfig(double money)
	{
		this.money = money;
		System.out.println("Would you like to roll above or below the roll? Type above or below.");
		hiLow = scan.next();
		if(hiLow.equals("above"))
		{
			System.out.println("What is the roll? Enter a number between 1.99 - 98.99");
			odds = String.valueOf(scan.next());
			if(odds.compareTo("1.99")<0 || odds.compareTo("98.99")>0)
			{
				System.out.println("Enter a valid number.");
				odds = String.valueOf(scan.next());
			}
		} else if(hiLow.equals("below")) {
			System.out.println("What is the roll? Enter a number between 1.00 - 98.00");
			odds = String.valueOf(scan.next());
			if(odds.compareTo("1.00")<0 || odds.compareTo("98.00")>0)
			{
				System.out.println("Enter a valid number.");
				odds = String.valueOf(scan.next());
			}
		} else {
			System.out.println("Must type a valid answer.");
		}
		System.out.println("How many times would you like to roll?");
		roll = scan.nextInt();
		if(roll <= 0) {
			System.out.println("Cannot be less than or equal to 0.");
			diceConfig(money);
		} else {
			return roll;
		}
		return 1;
	}
	
	/*Roll between 0.00 and 100.00; Returns a decimal in the hundredth place
	 *Giving House 2%
	 *Implementing rolls above and scalar return multiplier
	 */
	public void rollDice() {
		Double rand = Math.random() * 100;
		String s = String.valueOf(rand);
		for(int i = 0; i < s.length(); i++)
		{
			if(s.substring(i,i+1).equals("."))
			{
				String x = s.substring(0,i);
				String y = s.substring(i+1,i+3);
				dice = Long.parseLong(x);
				dicey = Long.parseLong(y);
			}
		}
		if(dice < 0 || dice > 100)
		{
			rollDice();
		} else{
			System.out.println("Roll: " + dice + "." + dicey);
		}
	}
	
	//Checks to see if user won
	public double checkWinnings() {
		String s = String.valueOf(dice) + "." + String.valueOf(dicey);
		if(hiLow.equals("above"))
		{
			for(int i = 0; i < odds.length(); i++)
			{
				if(odds.substring(i,i+1).compareTo(s.substring(i,i+1))>0)
				{
					System.out.println("You Lost!");
					return -money;
				} else {
					System.out.println("You Won!");
					return money * returnMultiplier();
				}
			}
		} else {
			for(int i = 0; i < odds.length(); i++)
			{
				if(odds.substring(i,i+1).compareTo(s.substring(i,i+1))<0)
				{
					System.out.println("You Lost!");
					return -money;
				} else {
					System.out.println("You Won!");
					return money * returnMultiplier();
				}
			}
		}
		return 0;
	}
	
	//Used to give multiplier based on odds of winning
	private double returnMultiplier()
	{
		
		return 2;
		
	}
	
}
