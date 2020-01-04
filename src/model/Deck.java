package model;

import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Henry
 *
 * Class will get the deck ready 
 * @param <T> cards 
 */
public class Deck<T extends Card> {
	public void setDeckOfCards(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}
	
	public void shuffle(){
		//seed random number generator with system time
		Random rand = new Random();		
		for(int i = cards.size() - 1; i > 0; i--){
			int index = rand.nextInt(52);
			T temp = cards.get(index);
			cards.add(index, cards.get(i));
			cards.add(i, temp);
		}
	}
	
	public int remainingCards(){
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int numberOfCards){
		@SuppressWarnings("unchecked")
		T[] hand = (T[]) new Object[numberOfCards];
		for (int i = 0; i < numberOfCards; i++) {
			hand[i] = cards.get(dealtIndex);
			dealtIndex++;
		}
		return hand;
	}
	
	public T dealCard(){
		T c = cards.get(dealtIndex);
		dealtIndex++;		
		return c;
	}
	
    /**
     * Get the size of the given deck.
     *
     * @return the number of cards in the deck
     */
    public int size() {
        read.lock();
        try {
            return cards.size();
        } finally {
            read.unlock();
        }
    }
    
	private ArrayList<T> cards;
	private int dealtIndex = 0;
	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock read = readWriteLock.readLock();
	private final Lock write = readWriteLock.writeLock();
}
