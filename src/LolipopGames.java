public class LolipopGames { //Allows access to games
	public Connect4 connect = null;
	public TicTacToe ttt = null;
	public LolipopGames() {
		
		connect = new Connect4();
		ttt = new TicTacToe();
	}
	
}
