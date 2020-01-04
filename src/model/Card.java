package model;

public abstract class Card {
	
	public Card(Suit s, int value){
		this.faceValue = value;
		this.suit = s;
	}
	
	/**
     * Accessor for the suit of a card.
     *
     * @return the card's suit
     */
    public Suit getSuit() {
        return suit;
    }
    
    /**
     * Accessor for the number of a card.
     *
     * @return the cards number
     */
    public Number getNumber() {
        return faceValue;
    }
    
	public abstract int value();
	
	public boolean isAvailable(){
		return available;
	}
	
	public void markUnavailable(){
		available = false;
	}
	
	public void markAvailable(){
		available = true;
	}
	
	protected Suit suit;
	private boolean available = true;
	protected int faceValue;
	
}
