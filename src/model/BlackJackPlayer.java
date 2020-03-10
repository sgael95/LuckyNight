package model;

public class BlackJackPlayer implements Player {
	
	public BlackJackPlayer(PlayerType pt){
		hand = new BlackJackHand();
		playerType = pt;
	}
	
	@Override
	public boolean canHit() {
		boolean canHit = false;
		if(!(hand.busted()) && !(hand.is21())){
			canHit = true;
		}
		return canHit;
	}
	
	@Override
	public void takeCard(Card c) {
		hand.addCard((BlackJackCard) c);
	}
	
	@Override
	public void hit(Dealer d) {
		takeCard(d.dealCard());
	}

	@Override
	public void stand() {

	}
	
	public PlayerType getPlayerType() {
		return playerType;
	}
	
	public BlackJackHand getHand(){
		return hand;
	}
	
	private BlackJackHand hand;
	private PlayerType playerType;
}
