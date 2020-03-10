package model;

public class Dealer {
	
	protected Deck<Card> deck;
	
	public Dealer(Deck<Card> dealer){
		this.deck = dealer;
	}
	
	public Card dealCard(){
		return deck.dealCard();
	}
}
