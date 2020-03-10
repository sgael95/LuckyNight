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

import model2.*;
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
	private JButton btnQuit = new JButton("Quit");
	private JButton btnStay = new JButton("Stay");
	
	
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
		
		//Stay Button 
		btnStay.setBounds(215, 410, 60, 30);
		btnStay.setBackground(Color.darkGray);
		
		//Split Button 
		btnQuit.setBounds(315, 410, 60, 30);
		btnQuit.setBackground(Color.darkGray);
		
		//Adding everything to the frame 
		frmBlackjack.getContentPane().setLayout(null);
		frmBlackjack.getContentPane().setBackground(new java.awt.Color(39, 119, 20)); //Pool Felt Green
		frmBlackjack.getContentPane().add(btnHit);
		frmBlackjack.getContentPane().add(btnStay);
		frmBlackjack.getContentPane().add(btnQuit);
		
		//UserUI
		userPane = new JLayeredPane();
		userPane.setBorder(new TitledBorder(null, "Your Hand", TitledBorder.LEADING, TitledBorder.TOP, null, Color.white));
		userPane.setBounds(170, 230, 170, 160);
		userPane.setBackground(new java.awt.Color(49, 49, 52)); //Matted Black 
		userPane.setOpaque(true);
		frmBlackjack.getContentPane().add(userPane);
		
		//user card 1
		JLabel lblU = new JLabel("");
		lblU.setBounds(10, 30, 71, 96);
		userPane.add(lblU, 0);
		userLabels.add(lblU);
		
		//user card 2
		JLabel lblU_1 = new JLabel("");
		lblU_1.setBounds(30, 30, 71, 96);
		userPane.add(lblU_1, 0);
		userLabels.add(lblU_1);
		
		JLabel lblU_2 = new JLabel("");
		lblU_2.setBounds(50, 30, 71, 96);
		userPane.add(lblU_2, 0);
		userLabels.add(lblU_2);
		
		JLabel lblU_3 = new JLabel("");
		lblU_3.setBounds(70, 30, 71, 96);
		userPane.add(lblU_3, 0);
		userLabels.add(lblU_3);
		
		JLabel lblU_4 = new JLabel("");
		lblU_4.setBounds(90, 30, 71, 96);
		userPane.add(lblU_4, 0);
		userLabels.add(lblU_4);
		
		
		userX = 36;
		
		//DealerUI 
		dealerPane = new JLayeredPane();
		dealerPane.setBorder(new TitledBorder(null, "House Hand", TitledBorder.LEADING, TitledBorder.TOP, null, Color.red));
		dealerPane.setBounds(170, 40, 170, 160);
		dealerPane.setBackground(new java.awt.Color(49, 49, 52)); //Matted Black 
		dealerPane.setOpaque(true);
		frmBlackjack.getContentPane().add(dealerPane);
		
		
		//dealer card 1
		JLabel lblD = new JLabel("");
		lblD.setBounds(10, 37, 71, 96);
		dealerPane.add(lblD, 0);		
		dealerLabels.add(lblD);
		
		//dealer card 2
		JLabel lblD_1 = new JLabel("");
		lblD_1.setBounds(30, 37, 71, 96);
		dealerPane.add(lblD_1, 0);
		dealerLabels.add(lblD_1);
		
		JLabel lblD_2 = new JLabel("");
		lblD_2.setBounds(50, 37, 71, 96);
		dealerPane.add(lblD_2, 0);
		dealerLabels.add(lblD_2);
		
		JLabel lblD_3 = new JLabel("");
		lblD_3.setBounds(70, 37, 71, 96);
		dealerPane.add(lblD_3, 0);
		dealerLabels.add(lblD_3);
		
		JLabel lblD_4 = new JLabel("");
		lblD_4.setBounds(90, 37, 71, 96);
		dealerPane.add(lblD_4, 0);
		dealerLabels.add(lblD_4);
		
		
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
	
	public void clearCards() {
		int count = 0;
		for(JLabel c : dealerLabels) {
			JLabel label = dealerLabels.get(count);
			label.setIcon(null);
			label.revalidate();
			label.repaint();
			
			JLabel label2 = userLabels.get(count);
			label2.setIcon(null);
			label2.revalidate();
			label2.repaint();
			
			count++;
		}
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
    
    
    public void addHitListener(ActionListener hit){
    	btnHit.addActionListener(hit);
    }
    
    public void addQuitListener(ActionListener quit) {
    	btnQuit.addActionListener(quit);
    }
    
    public void addStayListener(ActionListener stay) {
    	btnStay.addActionListener(stay);
    }

}
