package model;

public enum Suit {
	
	//Class for suit of cards 
	HEART(0), CLUB(1), DIAMOND(2), SPADE(3);
	
	private int value;
	
	private Suit(int v){
		this.value = v;
	}

	public int getValue() {
		return value;
	}
	
	//Switch statement for getting correct suit
	public static Suit getSuitFromValue(int value){
		switch(value) {
		case 0:	return HEART;
		case 1: return CLUB;
		case 2: return DIAMOND;
		case 3: return SPADE;
		default: return null;
		}
	}

}
