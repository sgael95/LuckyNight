package model2;

import java.util.ArrayList;

public class BlackJackModel {
	
	private ArrayList<Player> players;
	private Dealer dealer;
	private Player player1;
	private boolean endOfGame;
	private int currentPlayer, playerScore, dealerScore;
	
	public BlackJackModel() {
		init();
	}
	
	public void init() {
		endOfGame = false;
		currentPlayer = 0;
		playerScore = 0;
		dealerScore = 0;
		players = new ArrayList<Player>();
		dealer = new Dealer();
		player1 = new Player();
		
		players.add(player1);
		players.add(dealer);
	}

	public void startGame() {
		
		dealer.dealCard(player1);
		dealer.dealCard(player1);
		dealer.dealCard(dealer);
		dealer.dealCard(dealer);
		
		
	}
	
	public boolean update(String command) {
		boolean inGame = true;
		
		while(inGame) {
			if(command.contentEquals("Exit") || command.contentEquals("Quit")) {
				System.exit(0);
			}
			
			if(currentPlayer == 1) {
				if(dealer.canHit()) {
					dealer.dealCard(dealer);
				} else {
					currentPlayer = getNextPlayer();
					inGame = false;
				}
			}
			
			if(command.contentEquals("Hit")) {
				if(player1.canHit()) {
					dealer.dealCard(player1);
				}
				inGame = false;
			}
			
			if(command.contentEquals("Stay")) {
				currentPlayer = getNextPlayer();
			}
			
			if(!dealer.canHit() && !player1.canHit()) {
				playerScore = player1.getHandScore();
				dealerScore = dealer.getHandScore();
				
				evaluateScore(playerScore, dealerScore);
				return true;
			}	
		}
		return false;
	}
	
	public int getNextPlayer() {
		return (currentPlayer + 1) % 2;
	}
	
	public void newGame() {
		
	}
	
	public void quitGame() {
		players = null;
		dealer = null;
		player1 = null;
		System.exit(0);
	}
	
	public void evaluateScore(int playerScore, int dealerScore) {
		if(playerScore > 21 && dealerScore > 21) {
			playerScore = playerScore - 21;
			dealerScore = dealerScore - 21;
			if(playerScore > dealerScore)
				currentPlayer = 1;
			else
				currentPlayer = 0;
		} else
			currentPlayer = 0;
	}
	
	public ArrayList<String> getPlayersHand() {return player1.getHand();}
	public ArrayList<String> getDealersHand() {return dealer.getHand();}
	public boolean getEndOfGame() {return endOfGame;}
	public int getCurrentPlayer() {return currentPlayer;}
	public int getPlayerScore() {return playerScore;}
	public int getDealerScore() {return dealerScore;}
	public void setCurrentPlayer(int currentPlayer) {this.currentPlayer = currentPlayer;}
	public void setEndOfGame(boolean endOfGame) {this.endOfGame = endOfGame;}
	public void setPlayerScore(int playerScore) {this.playerScore = playerScore;}
	public void setDealerScore(int dealerScore) {this.dealerScore = dealerScore;}
	
}
