package model;

import java.awt.image.BufferedImage;

/*
 * @author johannes
 */

public class BlackJackCard extends Card implements Facing {
	
	private String cardImageLocation1; 
	private Face facing1; 

	public BlackJackCard(Suit s, int value) {
		super(s, value);
		cardImageLocation1 = ImageLoader.getImageLocation(s, value);
	}
	
	public boolean isAce() {
		return faceValue == 1;
	}
	
	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}

	@Override
	public void setFaceUp() {
		facing1 = Face.UP;
	}

	@Override
	public void setFaceDown() {
		facing1 = Face.DOWN;
	}

	public String getCardImageLocation() {
		return cardImageLocation1;
	}

	
//	public void setCardImage(BufferedImage cardImage) {
//		this.cardImage = cardImage;
//	}

/*
 * @author johannes	
 */

// this function can replace the above one,
// but would it break your ImageLoader @Henry?
	
//public void setCardImage(String cardImage) {
//		this.cardImageLocation1 = cardImage;
//	}
	 
	
	
	public Face getFacing() {
		return facing1;
	}

	public void setFacing(Face facing) {
		this.facing1 = facing;
	}
	
	public int maxValue() {
		if (isAce()){
			return 11;
		}
		else {
			return value();
		}
	}
	
	public int minValue(){
		if (isAce()){
			return 1;
		}
		else {
			return value();
		}
	}
	
	public int value(){
		if(isAce()){
			return 1;
		}
		else if (faceValue >= 11 && faceValue <= 13) {
			return 10;
		}
		else {
			return faceValue;
		}
	}
}
