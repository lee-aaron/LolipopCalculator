
public class DiceRoll {

	Long dice;
	Long dicey;
	
	public DiceRoll() {
		
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
		if(dice <= 2)
		{
			rollDice();
		} else {
			System.out.println(dice + "." + dicey);
		}
		
	}
	
	//Used to give multiplier based on odds of winning
	private void returnMultiplier(Long dice)
	{
		Long scalar[] = new Long[100];
		
	}
	
}
