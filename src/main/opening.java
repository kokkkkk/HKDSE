package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;

import Basic.initial;
import frame.openingFrame;

public class opening {
	
	frame.openingFrame openingFrame;
	
	buttonHandler buttonHandler = new buttonHandler();
	
	int opening = 0;
	int eventQueue = 0;
	
	int iniValue = initial.iniValue;
	int moneyValue = initial.moneyValue;
	
	boolean rich = false;
	boolean smart = false;
	boolean textDisplay = false;
	
	String[] electives;
	
	String text[];
	
	public opening(frame.title tit, int i){
		
		openingFrame = new openingFrame(tit,0,mouse);
		
		displayText();
	}
	
	private void displayText(){
		
		evaluate();
		
		String t = "";
		
		t += readText("introduction");
		
		if(rich){
			t+= readText("background_rich");
		}else{
			t+= readText("background_poor");
		}
		
		if(smart){
			t += readText("background_smart");
		}else{
			t += readText("background_stupid");
		}
		
		text = t.split("\n");
		
		openingFrame.setText(text);
		
		textDisplay = true;
		
		eventQueue++;

	}
	
	private void evaluate(){
		if(moneyValue>=140){
			rich = true;
		}
		if(iniValue >= 7){
			smart = true;
		}
	}
	
	private void addButton(){
		
		String t = readText("electives_choices");
		
		electives = t.split("\n");
		
		openingFrame.addButton(electives.length, electives, buttonHandler);
		
		eventQueue++;
	}
	
	private String readText(String name) {
		
		String t = "";
		
		String fileName = "./script/openingText/" + name + ".txt";
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line = br.readLine();
			
			while(!line.equals("end")){
				
				t += line + "\n";
				line = br.readLine();
				
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return t;
	}
	
	private void executeAll(){
		
		switch(eventQueue){
		case 1:
			addButton();
			break;
		case 2:
			openingFrame.endOpening();
			break;
		}
		
	}
	
	public class buttonHandler implements ActionListener{
		
		int buttonNum = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String action = e.getActionCommand();
			
			switch(action){
			case "submit":
				
				executeAll();
				break;
			default:
				if(buttonNum < 2){
					buttonNum++;
					((JButton) e.getSource()).setForeground(Color.orange);
				}else{
				
				}
				break;
				
			}
			
		}
		
		
	}
	
	MouseListener mouse =  new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(textDisplay){
				openingFrame.showOpening(opening);
				
				if(openingFrame.isTextEnd()){
					
					opening = 0;
					textDisplay = false;
					executeAll();
					
				}else{
					opening++;
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}
	};
}
