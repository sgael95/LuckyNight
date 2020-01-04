/**
 * 
 */
package model;

public class BlackJackDealer extends Dealer implements Player {
	
	public BlackJackDealer(Deck<Card> deck) {
		super(deck);
		hand = new BlackJackHand();
	}
	
	// This gets the dealer their hand
	public BlackJackHand getHand() {
		return hand;
	}
	
	public PlayerType getPlayerType(){
		return playerType;
	}
	
	// This adds a card to the dealers hand
	public void hit (Dealer dealer) {
		takeCard(deck.dealCard());
	}
	
	@Override
	public void takeCard(Card card) {
		hand.addCard((BlackJackCard) card);
	}
	
	// Determines if the dealer can take another card
	@Override
	public boolean canHit() {
		boolean canHit = false;
		if(hand.score() < 17 && !hand.busted() && !hand.is21()){
			canHit = true;
		}
		return canHit;	
	}
	
	@Override
	public void stand() {
		
	}
	
	// This is the dealers hand
		private BlackJackHand hand;
		private PlayerType playerType = PlayerType.CPU;	

}
