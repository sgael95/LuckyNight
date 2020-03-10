package model2;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> hand;
	private ArrayList<String> cardLocations;
	private int score;
	
	public Hand() {
		hand = new ArrayList<Card>();
		cardLocations = new ArrayList<String>();
	}
	
	public void addCard(Card c) {
		hand.add(c);
		cardLocations.add(c.getImageLocation());
	}
	
	public void removeCards() {
		hand.clear();
		cardLocations.clear();
	}

	public int size() {
		int count = 0;
		for(Card c : hand) {
			count++;
		}
		return count;
	}
	
	public ArrayList<String> getCardLocations(){return cardLocations;}
	
	//TODO implement scoring of hand.
	public int getScore() {
		score = 0;
		for(Card c: hand) {
			score += c.getValue();
		}
		return score;
	}
	
	public String toString() {
		String handCards = "Cards in hand: \n" + hand;
		return handCards;
	}

}
