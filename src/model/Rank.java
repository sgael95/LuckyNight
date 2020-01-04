package model;

public enum Rank {
	//ACE has a special value, the default is one, but if the value being added to ace is < 11, ACE is an 11
		ACE(1), TWO(2), THREE(3), 
		FOUR(4), FIVE(5), SIX(6), 
		SEVEN(7), EIGHT(8), NINE(9), 
		TEN(10), JACK(10), QUEEN(10), 
		KING(10);
		
		private final int value; //represents the value of some card
		/**
		 * Sets the value of a rank
		 * @param {@code int}
		 */
		Rank(int value){
			this.value = value;
		}
		public int getValue() {
			return value;
		}
}
