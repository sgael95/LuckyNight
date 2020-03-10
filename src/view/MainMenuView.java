package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;


import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainMenuView extends JFrame implements ActionListener {
	
	private JFrame menu = new JFrame();
	private JButton startBtn = new JButton("Start");
	private JButton settingsBtn = new JButton("Settings");
	private JButton rulesBtn = new JButton("Rules");
	private JLabel welcomeMessage = new JLabel("Welcome to LuckyNight!");
	
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainMenuView(){
		initialize();
	}
	
	private void initialize(){
		menu.setTitle("Lucky Night: Black Jack");
		
		menu.setBounds(100, 100, 500, 500);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setResizable(false);
		
		//startBtn = new JButton("Start");
		startBtn.setBounds(215, 200, 90, 30);
		startBtn.setBackground(Color.darkGray);
		
		//settingsBtn = new JButton("Settings");
		settingsBtn.setBounds(215, 300, 90, 30);
		settingsBtn.setBackground(Color.darkGray);
		
		//rulesBtn = new JButton("Rules");
		rulesBtn.setBounds(215, 400, 90, 30);
		rulesBtn.setBackground(Color.darkGray);
		
		welcomeMessage.setBounds(200, 100, 300, 100);
		welcomeMessage.setVisible(true);
		
		menu.getContentPane().setLayout(null);
		menu.getContentPane().setBackground(new java.awt.Color(39, 119, 20)); //Pool Felt Green
		menu.getContentPane().add(startBtn);
		menu.getContentPane().add(settingsBtn);
		menu.getContentPane().add(rulesBtn);
		menu.getContentPane().add(welcomeMessage);
		
	}
	
	public void disable(){
		menu.setVisible(false);
	}
	
	
	public void addStartListener(ActionListener str){
		startBtn.addActionListener(str);
	}
	
	public void addSettingsListener(ActionListener set){
		settingsBtn.addActionListener(set);
	}
	
	public void addRulesListener(ActionListener rul){
		rulesBtn.addActionListener(rul);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
