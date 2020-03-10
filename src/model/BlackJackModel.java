/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Henry 
 *
 */

//This is where we will begin to make the game 
public class BlackJackModel implements CardGame{

	//setting all variables needed 
	private ArrayList<Player> players; //array list to hold number of players
	private BlackJackDealer dealer; //instance of a BlackJackDealer
	private Player currentPlayer; //instance of player 
	private int index; //for index 
	
	//method for BlackJackModel 
	public BlackJackModel() {
		//Making players and initializing game 
		players = new ArrayList<Player>();
		initializeGame(1);
	}
	
	//method for adding a player and need to make a class for it too 
	@Override
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	//method for setting a dealer
	@Override
	public void setDealer(Dealer dealer) {
		dealer = (BlackJackDealer) dealer;
		
	}
	
	//method for the start of the game
	@Override
	public void startGame() {
		//Instance of BlackJackCard
		BlackJackCard playerCard; 
		BlackJackCard dealerCard; 
		
		//Giving first card to player
		for(Player player: players) {
			playerCard = (BlackJackCard) dealer.dealCard();
			playerCard.setFaceUp();
			player.takeCard(playerCard);
		}
		
		//Giving second card to dealer
		dealerCard = (BlackJackCard) dealer.dealCard();
		dealerCard.setFaceUp();
		dealer.takeCard(dealerCard);
		
		//Giving third card to player
		for(Player player: players) {
			playerCard = (BlackJackCard) dealer.dealCard();
			playerCard.setFaceUp();
			player.takeCard(playerCard);
		}
		
		//Giving fourth card to dealer
		dealerCard = (BlackJackCard) dealer.dealCard();
		dealerCard.setFaceUp();
		dealer.takeCard(dealerCard);
		
		currentPlayer = players.get(0);
	}
	
	//method for quitting the game
	@Override
	public void quitGame() {
		
		//Clear players dealer, and index 
		players.clear();
		dealer = null; 
		currentPlayer = null; 
		System.exit(0);
	}
	
	//Method for new game
	@Override
	public void newGame() {
		
		players.clear();
		dealer = null; 
		currentPlayer = null; 
		players = new ArrayList<Player>();
		initializeGame(1);
		
	}
	
	
	//method for generating the deck 
	public Deck<Card> generateDeck(){
		//instances of deck and cards
		Deck<Card> deck = new Deck<>();
		ArrayList<Card> cards = new ArrayList<>();
		//Creating cards
		for(int j = 1; j <= 13; j++) {
			cards.add(new BlackJackCard(Suit.CLUB, j));
			cards.add(new BlackJackCard(Suit.HEART, j));
			cards.add(new BlackJackCard(Suit.SPADE, j));
			cards.add(new BlackJackCard(Suit.DIAMOND, j));
			
			//for second deck of cards hope this works 
			cards.add(new BlackJackCard(Suit.CLUB, j));
			cards.add(new BlackJackCard(Suit.HEART, j));
			cards.add(new BlackJackCard(Suit.SPADE, j));
			cards.add(new BlackJackCard(Suit.DIAMOND, j));
		}
		
		deck.setDeckOfCards(cards);
		deck.shuffle();
		return deck;
	}
	
	//method for getting current player 
	public Player getCurrentPlayer() {
		return currentPlayer; 
	}
	
	//method for getting all players
	public ArrayList<Player> getPlayers(){
		System.out.println(players);
		return players;
	}
	
	//method for getting the dealer
	public BlackJackDealer getDealer() {
		return dealer; 
	}
	
	//method for updating the game 
	public void update(String command) {
		
		//If Exit is pressed exit program 
		if(command.contentEquals("Exit") || command.contentEquals("Quit")) {
			System.exit(0);
		}
		
		//If dealer is next and can hit
		if(currentPlayer.equals(dealer)) {
			
			if(dealer.canHit()){ dealer.hit(dealer); }
			
		}//TODO implement a multiplayer mode
		 
		//if(command.contentEquals("Hit") && currentPlayer.canHit())
		if(command == "Hit") {
			BlackJackCard playerCard; 
			currentPlayer = getNextPlayer();
				currentPlayer.hit(dealer);
				dealer.dealCard();
				playerCard = (BlackJackCard) dealer.dealCard();
				playerCard.setFaceUp();
				System.out.println(playerCard.value());
				System.out.println(currentPlayer.getPlayerType());
				currentPlayer.takeCard(playerCard);
				for(Player player: players) {
					playerCard = (BlackJackCard) dealer.dealCard();
					playerCard.setFaceUp();
					player.takeCard(playerCard);
				}
		}
		
		if(command.equals("stand")) {
				currentPlayer.stand();
				System.out.println("Stand");
			}
		
		//Whatever is pressed next player will then be their turn 
		currentPlayer = getNextPlayer();
		System.out.println(currentPlayer.getPlayerType());
	}
	
	
	//method for setting current player
	public void setCurrentPlayer(BlackJackPlayer currentPlayer) {
		this.currentPlayer = currentPlayer; 
	}
	
	//method for getting the next player 
	private Player getNextPlayer() {
		
		//TODO need to implement in case there is no next player 
		int nextplayerIndex = (index + 1) % players.size();
		//return players.get(nextplayerIndex);
		return players.get(0);
	}
	
	//method for initializing the game with corresponding players
	@Override
	public void initializeGame(int numberOfPlayers) {
		Deck<Card> gameDeck = generateDeck();
		
		addPlayer(new BlackJackPlayer(PlayerType.USER));
		
		for(int k = 0; k < numberOfPlayers-1; k++) {
			addPlayer(new BlackJackPlayer(PlayerType.CPU));
		}
		
		dealer = new BlackJackDealer(gameDeck);
		
		index = 0; 
	}
	
}
