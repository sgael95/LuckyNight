package model2;

public class Dealer extends Player{
	
	private Deck deck;
	
	public Dealer() {
		super();
		deck = new Deck();
	}
	
	public void dealCard(Player player) {
		Card card = deck.dealCard();
		player.takeCard(card);
	}
	
	public String toString() {
		String dealerStats = "The Dealers deck: " + deck
				+ "\nDealers hand: " + super.toString();
		return dealerStats;
	}

}
