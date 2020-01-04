package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.BlackJackCard;
import model.BlackJackDealer;
import model.BlackJackModel;
import model.BlackJackPlayer;
import model.ImageLoader;
import model.Player;
import view.BlackJackView;
import view.MainMenuView;


public class BlackJackController implements ActionListener{

	private static final int TestingPlayer = 1; 
	//initialize game model and view
	private BlackJackView view; 
	private BlackJackModel game; 
	private MainMenuView menu;
	
	
	
	public BlackJackController(BlackJackModel game, BlackJackView view, MainMenuView menu){
		//Constructor calling game and view 
		this.game = game;
		this.view = view;
		this.menu = menu;
		
		menu.addStartListener(new StartListener());
		menu.addSettingsListener(new SettingsListener());
		menu.addRulesListener(new RulesListener());
		
		view.addHitListener(new HitListener());
	}

	
	private void initialize() {
		//TO DO later 
		game.startGame(); //start the game 
		ArrayList<String> dealerStrings = getDealerHandImageStrings(game.getDealer()); //Get the dealers hand 
		
		
		assert(game.getPlayers().size() == 1); //Single player mode 
		ArrayList<String> userStrings = getPlayerHandImageStrings(game.getPlayers().get(0)); // TODO make this better, assumes dealer is last
		
		view.setDealerCards(dealerStrings); // displaying dealer cards
		view.setUserCards(userStrings); // displaying player cards
		
	}
	

	private ArrayList<String> getDealerHandImageStrings(BlackJackDealer dealer) {
		ArrayList<String> imageList = new ArrayList<String>(5);
		for(BlackJackCard card : dealer.getHand().getCards()){
			imageList.add(card.getCardImageLocation());
		}
		return imageList;
	}

	private ArrayList<String> getPlayerHandImageStrings(Player player){
		ArrayList<String> imageList = new ArrayList<String>(5);
		for(BlackJackCard card : player.getHand().getCards()){
			imageList.add(card.getCardImageLocation());
		}
		return imageList;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// insert everything 
		String command = e.getActionCommand();
		//update method not created yet 
		game.update(command);
		
	}
	
	class HitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = "Hit";
			game.update(command);
			//System.out.println("Working");
		}
	}
	
	
	/**
	 * Listener classes for main menu.
	 * @author gaelsanchez
	 *
	 */
	class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			view.show();
			initialize();
			menu.disable();
		}
	}
	
	class SettingsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class RulesListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}

}
