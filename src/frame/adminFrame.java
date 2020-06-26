package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class adminFrame {

	//Press A to open Admin Panel
	
	int valueNum = 8;
	int boolNum = 6;
	
	JFrame window;
	JPanel valuePanel,boolPanel,submitPanel;
	JButton submit;
	
	String[] label = {"day", "mark", "knowledge", "examSkill", "iniValue", "moneyValue", "eneryValue", 
			"energyUseupDay","exhaust", "energyUseup", "tired", "moneyUseup", "closeWindow"};
	
	Font smallFont = new Font("Times New Roman", Font.PLAIN,17);
	
	buttonHandler buttonHandler;
	
	public adminFrame(game g){
		
		buttonHandler = new buttonHandler(g);
		
		window = new JFrame();
		window.setSize(400, 500);
		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null); //customize layout not use default layout
		
		valuePanel = new JPanel();
		valuePanel.setBounds(0,0,400,200);
		valuePanel.setBackground(Color.blue);
		valuePanel.setLayout(new GridLayout(valueNum,2));
		
		int i = 0;
		
		while(i < valueNum){
			createLabel(i, valuePanel);
			createTextfield(i,valuePanel);
			i++;
		}
		
		
		boolPanel = new JPanel();
		boolPanel.setBounds(0,200,400,200);
		boolPanel.setBackground(Color.blue);
		boolPanel.setLayout(new GridLayout(boolNum,3));
		
		while(i - (valueNum-1) < boolNum){
			createLabel(i, boolPanel);
			createButton(i,boolPanel);
			i++;
		}
		
		submitPanel = new JPanel();
		submitPanel.setBounds(0,400,400,100);
		submitPanel.setBackground(Color.blue);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.white);
		submit.setForeground(Color.black);
		submit.setFont(smallFont);
		submit.setFocusPainted(false);
		submit.setActionCommand("submit");
		submit.addActionListener(buttonHandler);
		
		submitPanel.add(submit);
		
		window.add(valuePanel);
		window.add(boolPanel);
		window.add(submitPanel);
		window.setVisible(true);
		
	}
	
	private void createLabel(int i, JPanel p){
		
		JLabel createLabel = new JLabel(label[i]);
		
		createLabel.setFont(smallFont);
		createLabel.setForeground(Color.white);
		
		p.add(createLabel);
		
	}
	
private void createTextfield(int i, JPanel p){
		
		JTextField createTextfield = new JTextField();
		
		createTextfield.setName(label[i]);
		
		p.add(createTextfield);
		
	}

private void createButton(int i, JPanel p){
	
	JButton createButton_true = new JButton();
	
	createButton_true = new JButton("True");
	createButton_true.setBackground(Color.black);
	createButton_true.setForeground(Color.white);
	createButton_true.setFont(smallFont);
	createButton_true.setFocusPainted(true);
	createButton_true.setActionCommand(label[i]+"\btrue");
	createButton_true.setName(label[i]+"\btrue");
	createButton_true.addActionListener(buttonHandler); //when click, call the class
	
	p.add(createButton_true);
	

	JButton createButton_false = new JButton();
	
	createButton_false = new JButton("False");
	createButton_false.setBackground(Color.black);
	createButton_false.setForeground(Color.white);
	createButton_false.setFont(smallFont);
	createButton_false.setFocusPainted(true);
	createButton_false.setActionCommand(label[i]+"\bfalse");
	createButton_false.setName(label[i]+"\bfalse");
	createButton_false.addActionListener(buttonHandler); //when click, call the class
	
	p.add(createButton_false);
	
}

public void setButton(String name){
	
}

public class buttonHandler implements ActionListener {
	
	frame.game game;
	
	public buttonHandler(frame.game g){
		
		game = g;
		
	}
	
	public void actionPerformed(ActionEvent event){
		
		String action = event.getActionCommand();
		
		if(action.contains("\b")){
			String[] command = action.split("\b");
			
			for(int i = valueNum; i<boolNum;i++){
				if(command[0].equals(label[i])){
					
				}
			}
		}
		
		switch(action) {
		case "submit":
			
        
			
			break;
			
			
			
		}
		
	}
	
	
}


}
