package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class title {
	
	frame.Main main;
	JPanel title, choices;
	JLabel titleName;
	JButton newGameButton,continueButton,exitButton;
	
	Control.titleHandler titleHandler;
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN,30);
	
	public title(frame.Main m){
		
		main = m;
		
		titleHandler = new Control.titleHandler(main,this);
		
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
		newGameButton.setFont(main.normalFont);
		newGameButton.setFocusPainted(false);
		newGameButton.addActionListener(titleHandler);
		
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.black);
		continueButton.setForeground(Color.white);
		continueButton.setFont(main.normalFont);
		continueButton.setFocusPainted(false);
		continueButton.addActionListener(titleHandler);
		
		exitButton = new JButton("Exit");
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.white);
		exitButton.setFont(main.normalFont);
		exitButton.setFocusPainted(false);
		exitButton.addActionListener(titleHandler);
		
		title.add(titleName);
		choices.add(newGameButton);
		choices.add(continueButton);
		choices.add(exitButton);
	
	}
	
	public void titleSetup(){
		
		
		main.con.add(title);
		main.con.add(choices);
		
		title.setVisible(true);
		choices.setVisible(true);
		
	}
	
	public void clearFrame() {
		
		title.setVisible(false);
		choices.setVisible(false);
		
	}
}
