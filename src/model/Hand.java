package model;

import java.util.ArrayList;

public class Hand<T extends Card> {
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public int score(){
		int score = 0;
		for (T card : cards) {
			score += card.value(); //this does not do anything since cards have not been initialized 
		}
		return score;
	}
	
	public void addCard(T card){
		cards.add(card);
	}
}
