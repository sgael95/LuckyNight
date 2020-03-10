package model2;

import java.util.ArrayList;

public class Player {
	
	private Hand playerHand;
	private int playerScore, cardsCount;
	
	public Player() {
		playerHand = new Hand();
	}
	
	public void takeCard(Card c) {
		playerHand.addCard(c);
	}
	
	public int getHandScore() {
		playerScore = playerHand.getScore();
		return playerScore;
	}
	
	public int getHandSize() {
		return playerHand.size();
	}
	
	public ArrayList<String> getHand(){
		ArrayList<String> hand = playerHand.getCardLocations();
		return hand;
	}
	
	public void emptyHand() {
		playerHand.removeCards();
	}
	
	public boolean canHit() {
		playerScore = getHandScore();
		cardsCount = getHandSize();
		
		if(playerScore < 21 && cardsCount < 5)
			return true;
		return false;

	}
	
	public String toString() {
		getHandScore();
		String playerStats = "Player has a score of: " + playerScore
				+ "\n" + playerHand;
		return playerStats;
	}

}
