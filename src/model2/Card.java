package model2;

public class Card {
	
	private static final String resourcePath = "../resources/";
	private static final String imgExtention = ".png";
	
	private int suit;
	private int value;
	private String[] cardSuit = {"Clubs", "Spades", "Diamonds", "Hearts" };
	private String[] cardValue = {null, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k" };
	private Face face;
	private String imageLocation;
	

	public Card(int value, int suit, Face face) {
		this.value = value;
		this.suit = suit;
		this.face = face;
		setImageLocation();
	}
	
	public Card(int value, int suit) {
		this.value = value;
		this.suit = suit;
		setImageLocation();
	}
	
	public void setSuit(int suit) {this.suit = suit;}
	public void setValue(int value) {this.value = value;}
	public void setFace(Face face) {this.face = face;}
	public void setImageLocation(String imageLocation) {this.imageLocation = imageLocation;}
	public void setImageLocation() {
		String result = resourcePath;
		char suitCharacter;
		char valueCharacter;
		
		switch(suit) {
		case 0: suitCharacter = 'c';
			break;
		case 1: suitCharacter = 's';
			break;
		case 2: suitCharacter = 'd';
			break;
		case 3: suitCharacter = 'h';
			break;
			default: throw new IllegalArgumentException();
		}
		
		result = result + suitCharacter + cardValue[value] + imgExtention;
		imageLocation = result;
	}
	
	public int getSuit() {return suit;}
	public int getValue() {return value;}
	public Face getFace() {return face;}
	public String getImageLocation() {return imageLocation;}
	
	public String toString() {
		return "Value: " + cardValue[value] + "\tSuit: " + cardSuit[suit] + "\tFaced: " 
				+ face + "\n";
	}

}
