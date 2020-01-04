package model;

public interface CardGame {
	public void addPlayer(Player player);
	public void setDealer(Dealer dealer);
	public void initializeGame(int numberOfPlayers);
	public void quitGame();
	public void startGame();
	public void newGame(); 
}
