package model2;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
		populateDeck();
		populateDeck();
		Collections.shuffle(deck);
	}
	
	public void populateDeck() {
		for(int i = 0; i<=3; i++) {
			for(int j=1; j<14; j++) {
				deck.add(new Card(j, i, Face.DOWN));
			}
		}
	}
	
	
	public Card dealCard() {
		Card card;
		card = deck.get(0);
		deck.remove(0);
		return card;
	}
	
	public String toString() {
		String deckOfCards = "The deck contains: \n" + deck;
		return deckOfCards;
	}
}
