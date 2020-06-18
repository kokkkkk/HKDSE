package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class title{
	
	
	public JFrame window;
	
	public JLayeredPane con;
	
	Font normalFont = new Font("Times New Roman", Font.PLAIN,21);
	Font smallFont = new Font("Times New Roman", Font.PLAIN,17);
	Font VerysmallFont = new Font("Times New Roman", Font.PLAIN,9);
	
	JPanel title, choices;
	JLabel titleName;
	JButton newGameButton,continueButton,exitButton;
	
	frame.Game game;
	
	Control.titleHandler titleHandler;
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN,30);
	
	public title(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null); //customize layout not use default layout
		
		//con = window.getContentPane();
		
		con = window.getLayeredPane();
		
		titleHandler = new Control.titleHandler(this);
		
		title = new JPanel();
		title.setBounds(100,30,600,100);
		title.setBackground(Color.RED);
		
		choices = new JPanel();
		choices.setLayout(new GridLayout(3,1));
		choices.setBounds(160,160,500,300);
		choices.setBackground(Color.blue);
		
		titleName = new JLabel("DSE Life");
		titleName.setFont(titleFont);
		titleName.setForeground(Color.white);
		
		newGameButton = new JButton("New Game");
		newGameButton.setBackground(Color.black);
		newGameButton.setForeground(Color.white);
		newGameButton.setFont(normalFont);
		newGameButton.setFocusPainted(false);
		newGameButton.setActionCommand("new");
		newGameButton.addActionListener(titleHandler);
		
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.black);
		continueButton.setForeground(Color.white);
		continueButton.setFont(normalFont);
		continueButton.setFocusPainted(false);
		continueButton.setActionCommand("continue");
		continueButton.addActionListener(titleHandler);
		
		exitButton = new JButton("Exit");
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.white);
		exitButton.setFont(normalFont);
		exitButton.setFocusPainted(false);
		exitButton.setActionCommand("exit");
		exitButton.addActionListener(titleHandler);
		
		title.add(titleName);
		choices.add(newGameButton);
		choices.add(continueButton);
		choices.add(exitButton);
		
		titleSetup();
		
		window.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new title();
	}
	
	public void titleSetup(){
		
		con.add(title);
		con.add(choices);
		
		title.setVisible(true);
		choices.setVisible(true);
		
	}
	
	public void clearFrame() {
		
		title.setVisible(false);
		choices.setVisible(false);
		
	}
}
