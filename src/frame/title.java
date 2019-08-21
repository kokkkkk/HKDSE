package frame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class title {
	
	frame.Main main;
	JPanel title, choices;
	JLabel titleName;
	JButton newGameButton,continueButton,exitButton;
	
	public title(frame.Main m){
		
		main = m;
		
		title = new JPanel();
		title.setBounds(100,30,600,100);
		title.setBackground(Color.RED);
		
		//title.add(titleName);
		//choices.add(newGameButton);
		//choices.add(continueButton);
		//choices.add(exitButton);
		
	}
	
	public void titleSetup(){
		
		main.con.add(title);
		//main.con.add(choices);
		
	}
}
