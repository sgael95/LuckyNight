package blackjack;

import javax.swing.*;
import controller.BlackJackController;
import view.BlackJackView;
import model.BlackJackModel;
import view.MainMenuView;

public class BlackJackDriver {

	public static void main(String[] args) {
		
		//Catch error and display message in case game does not want to start to help debug
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		MainMenuView menu = new MainMenuView();
		BlackJackModel game = new BlackJackModel();
		BlackJackView view = new BlackJackView();
		BlackJackController controller = new BlackJackController(game, view, menu);
		menu.show(); 

	}
}
