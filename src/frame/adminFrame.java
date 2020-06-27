package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Basic.initial;


public class adminFrame {

	//Press A to open Admin Panel
	
	int valueNum = 8;
	int boolNum = 5;
	
	int day = initial.day;
	int[] mark = initial.study;
	int[] knowledge = initial.knowledge;
	int[] examSkill = initial.examSkill; 
	int iniValue = initial.iniValue;
	int moneyValue = initial.moneyValue;
	int energyValue = initial.energyValue; 
	int energyUseupDay = initial.energyUseupDay;
	
	JFrame window;
	JPanel valuePanel,boolPanel,submitPanel;
	JLabel commandSet;
	JButton submit;
	
	String[] label = {"day", "mark", "knowledge", "examSkill", "iniValue", "moneyValue", "energyValue", 
			"energyUseupDay","exhaust", "energyUseup", "tired", "moneyUseup", "closeWindow"};
	
	Font smallFont = new Font("Times New Roman", Font.PLAIN,17);
	
	buttonHandler buttonHandler;
	focusHandler focusHanler = new focusHandler();
	
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
		boolPanel.setBounds(0,250,400,200);
		boolPanel.setBackground(Color.blue);
		boolPanel.setLayout(new GridLayout(boolNum,3));
		
		while(i - valueNum < boolNum){
			createLabel(i, boolPanel);
			createButton(i,boolPanel);
			i++;
		}
		
		submitPanel = new JPanel();
		submitPanel.setBounds(0,200,400,50);
		submitPanel.setBackground(Color.blue);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.white);
		submit.setForeground(Color.black);
		submit.setFont(smallFont);
		submit.setFocusPainted(false);
		submit.setActionCommand("submit");
		submit.addActionListener(buttonHandler);
		
		commandSet = new JLabel("Command: ");
		commandSet.setFont(smallFont);
		commandSet.setForeground(Color.white);
		
		submitPanel.add(submit);
		submitPanel.add(commandSet);
		
		window.add(valuePanel);
		window.add(submitPanel);
		window.add(boolPanel);
	
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
		
		createTextfield.setName("text\t"+label[i]);
		createTextfield.addFocusListener(focusHanler);
		
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
	createButton_false.addActionListener(buttonHandler); //when click, call the class
	
	p.add(createButton_false);
	
	}
	
	public class focusHandler implements FocusListener {

		@Override
		public void focusGained(FocusEvent event) {
			
		}

		@Override
		public void focusLost(FocusEvent event) {
			String action =  ((Component) event.getSource()).getName();
			
			 if(action.contains("\t")){
					
					String[] command = action.split("\t");
					for(int i = 0; i< valueNum; i++){
						if(command[1].equals(label[i])){
							System.out.print(((JTextField) event.getSource()).getText());
							textFieldAction(label[i],((JTextField) event.getSource()).getText());
							
						}
					}
					
				}
			
		}
		
		private void textFieldAction(String command, String value){
			
			if(value.contains(",")){
				String[] arraySet = value.split(",");
				
				if(arraySet.length == 7){
					
					int[] arr = new int[arraySet.length];
					
					for(int i = 0;i<arraySet.length;i++){
						arr[i] = Integer.parseInt(arraySet[i]);
					}
					
					
					switch(command){
					case"mark":
						mark = arr;
						break;
					case "knowledge":
						knowledge = arr;
						break;
					case "examSkill":
						examSkill = arr;
						break;
					}
				}
				
				
			}else if(!value.equals("")){
				int v = Integer.parseInt(value);
				
				switch(command){
				case "day":
					day = v;
					System.out.print("day!");
					break;
				case "iniValue":
					iniValue = v;
					break;
				case "moneyValue":
					moneyValue = v;
					break;
				case "energyValue":
					energyValue = v;
					break;
				case "energyUseupDay":
					energyUseupDay = v;
					break;
				}
			}
			
		}
		
	}

	public class buttonHandler implements ActionListener {
	
	frame.game game;
	
	public buttonHandler(frame.game g){
		
		game = g;
		
	}
	
	public void actionPerformed(ActionEvent event){
		System.out.print("action");
		
		String action = event.getActionCommand();
		
		if(action.contains("\b")){
			String[] command = action.split("\b");
			
			for(int i = valueNum; i<boolNum+valueNum;i++){
				if(command[0].equals(label[i])){
					
					if(command[1].equals("true")){
						buttonAction(label[i], true);
						commandSet.setText(label[i] + ": True");
					}else{
						buttonAction(label[i], false);
						commandSet.setText(label[i] + ": False");
					}
				}
			}
		}
		
		switch(action) {
		case "submit":
			submit();
			break;
		}
		
	}
	
	private void buttonAction(String command, boolean action){
		switch(command){
		case "exhaust":
			initial.exhaust = action;
			break;
		case"energyUseup":
			initial.energyUseup = action;
			break;
		case "tired":
			initial.tired = action;
			break;
		case "moneyUseup":
			initial.moneyUseup = action;
			break;
		case "closeWindow":
			initial.closeWindow = action;
			break;
		}
		
		game.dayReset();
	}
	
	
	
	private void submit(){
		initial.valueSetup(day, moneyValue, iniValue, mark, knowledge, examSkill);
		initial.energyValue = energyValue; 
		initial.energyUseupDay = energyUseupDay;
		
		game.valueSetup(day, initial.Chin, initial.Eng, initial.Math, initial.ls, initial.sub_1, initial.sub_2);
		
		game.dayReset();
	}
	
	
}


}
