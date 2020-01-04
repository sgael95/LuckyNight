package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.util.ArrayList;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import controller.*;


public class BlackJackView extends JFrame {
	
	private static final long serialVersionUID = 8857222390306612430L;
	private JFrame frmBlackjack;
	private ArrayList<JLabel> dealerLabels;
	private ArrayList<JLabel> userLabels;
	private JLayeredPane userPane;
	private JLayeredPane dealerPane;
	private static final int CARDHEIGHT = 96;
	private static final int CARDWIDTH = 71;
	private static final int DEALER_Y = 37;
	private static final int USER_Y = 30;
	private int userX;
	private int dealerX;
	private JButton btnHit = new JButton("Hit");
	
	
	//constructor
	public BlackJackView(BlackJackModel model, BlackJackController controller) { 
		super(); 
		pack();
	 }
	
	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frmBlackjack.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BlackJackView() {
		dealerLabels = new ArrayList<>();
		userLabels = new ArrayList<>();
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlackjack = new JFrame();
		frmBlackjack.setTitle("Lucky Night: Black Jack");
		
		frmBlackjack.setBounds(100, 100, 500, 500);
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlackjack.setResizable(false);
		
		
		//Hit Button 
		btnHit.setBounds(115, 410, 60, 30);
		btnHit.setBackground(Color.darkGray);
		//sbtnHit.addActionListener(new hitCard()); //Method not working
		
		//Stay Button 
		JButton btnStand = new JButton("Stay");
		btnStand.setBounds(215, 410, 60, 30);
		btnStand.setBackground(Color.darkGray);
		
		//Split Button 
		JButton btnSplit = new JButton("Split");
		btnSplit.setBounds(315, 410, 60, 30);
		btnStand.setBackground(Color.darkGray);
		
		//Adding everything to the frame 
		frmBlackjack.getContentPane().setLayout(null);
		frmBlackjack.getContentPane().setBackground(new java.awt.Color(39, 119, 20)); //Pool Felt Green
		frmBlackjack.getContentPane().add(btnHit);
		frmBlackjack.getContentPane().add(btnStand);
		frmBlackjack.getContentPane().add(btnSplit);
		
		//UserUI
		userPane = new JLayeredPane();
		userPane.setBorder(new TitledBorder(null, "Your Hand", TitledBorder.LEADING, TitledBorder.TOP, null, Color.white));
		userPane.setBounds(170, 250, 160, 160);
		userPane.setBackground(new java.awt.Color(49, 49, 52)); //Matted Black 
		userPane.setOpaque(true);
		frmBlackjack.getContentPane().add(userPane);
		
		//user card 1
		JLabel lblU = new JLabel("u1");
		lblU.setBounds(10, 30, 71, 96);
		userPane.add(lblU, 0);
		userLabels.add(lblU);
		
		//user card 2
		JLabel lblU_1 = new JLabel("u2");
		lblU_1.setBounds(30, 30, 71, 96);
		userPane.add(lblU_1, 0);
		userLabels.add(lblU_1);
		
		userX = 36;
		
		//DealerUI 
		dealerPane = new JLayeredPane();
		dealerPane.setBorder(new TitledBorder(null, "House Hand", TitledBorder.LEADING, TitledBorder.TOP, null, Color.red));
		dealerPane.setBounds(170, 40, 160, 160);
		dealerPane.setBackground(new java.awt.Color(49, 49, 52)); //Matted Black 
		dealerPane.setOpaque(true);
		frmBlackjack.getContentPane().add(dealerPane);
		
		
		//dealer card 1
		JLabel lblD = new JLabel("d1");
		lblD.setBounds(10, 37, 71, 96);
		dealerPane.add(lblD, 0);		
		dealerLabels.add(lblD);
		
		//dealer card 2
		JLabel lblD_1 = new JLabel("d2");
		lblD_1.setBounds(30, 37, 71, 96);
		dealerPane.add(lblD_1, 0);
		dealerLabels.add(lblD_1);
		
		dealerX = 36;
		
		
		//Adding Menu bar and its content
		JMenuBar menuBar = new JMenuBar();
		frmBlackjack.setJMenuBar(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnGame.add(mntmNewGame);
		mntmNewGame.addActionListener(new newApp());
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnGame.add(mntmQuit);	
		mntmQuit.addActionListener(new exitApp());
	}
	
	/**
	 * @param cardImages
	 */
	public void setDealerCards(ArrayList<String> cardImages){
		assert(cardImages.size() == dealerLabels.size());
		
		for(int i = 0; i < cardImages.size(); i++){
			JLabel label = dealerLabels.get(i);
			label.setIcon(new ImageIcon(BlackJackView.class.getResource(cardImages.get(i))));
			label.setText("");
			label.revalidate();
			label.repaint();
		}
		frmBlackjack.revalidate();
		frmBlackjack.repaint();
	}
	
	/**
	 * @param cardImages
	 */
	public void setUserCards(ArrayList<String> cardImages){
		assert(cardImages.size() == userLabels.size());
		
		for(int i = 0; i < cardImages.size(); i++){
			JLabel label = userLabels.get(i);
			label.setIcon(new ImageIcon(BlackJackView.class.getResource(cardImages.get(i))));
			label.setText("");
			label.revalidate();
			label.repaint();
		}
		frmBlackjack.revalidate();
		frmBlackjack.repaint();
	}
	
	/**
	 * @param cardImage
	 */
	public void addUserCard(String cardImage){
		JLabel label = new JLabel("");
		label.setBounds(userX, USER_Y, CARDWIDTH, CARDHEIGHT);
		label.setIcon(new ImageIcon(BlackJackView.class.getResource(cardImage)));
		userPane.add(label, 0);
		userX += 13;		
	}
	
	/**
	 * @param cardImage
	 */
	public void addDealerCard(String cardImage){
		JLabel label = new JLabel("");
		label.setBounds(dealerX, DEALER_Y, CARDWIDTH, CARDHEIGHT);
		label.setIcon(new ImageIcon(BlackJackView.class.getResource(cardImage)));
		dealerPane.add(label, 0);
		dealerX += 13;
	}
	
	// For exiting the game need to call make a class for all the actions 
    static class exitApp implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BlackJackModel model = new BlackJackModel();
            model.quitGame();
          
        }
    }
    
 // For exiting the game need to call make a class for all the actions 
    static class newApp implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BlackJackModel model = new BlackJackModel();
            model.newGame();
          
        }
    }
    
    //Not implemented correctly need to revise 
    static class hitCard extends BlackJackModel implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		new BlackJackModel();
            
    	}
    }
    
    public void addHitListener(ActionListener hit){
    	btnHit.addActionListener(hit);
    }

}
