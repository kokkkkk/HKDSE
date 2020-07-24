package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;

import Basic.initial;
import Basic.language;
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
	String[] electives_select = new String[2];
	String[] buttonCommand = {"Chist","Econ","E&RS","Geog","Hist","Bio","Chem","Phy","BAFS","ICT","T&L","Music","VA","PE"};
	
	String text[];
	
	public opening(frame.title tit, int i){
		
		openingFrame = new openingFrame(tit,0,mouse,"opening.png");
		
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
	
	private void intro_end(){
		String t = language.getV("introEnd")+" "+ initial.subject[5] +" "+ language.getV("introEnd1") + " " + initial.subject[6] + "\n"; 
		
		t += readText("inroduction_end");
		
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
		
		openingFrame.addButton(electives.length, electives,buttonCommand, buttonHandler,smart);
		
		eventQueue++;
	}
	
	private String readText(String name) {
		
		String t = "";
		
		InputStream fileName = this.getClass().getResourceAsStream("/" +name +language.lang[language.lang_choose]+ ".txt");
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fileName));
			
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
			intro_end();
			break;
		case 3:
			openingFrame.endOpening();
			break;
		}
		
	}
	
	private void submitElective(){
		initial.setElective(electives_select);
		
		executeAll();
	}
	
	public class buttonHandler implements ActionListener{
		
		int buttonNum = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String action = e.getActionCommand();
			
			switch(action){
			case "submit":
				openingFrame.clearButton();
				submitElective();
				break;
				
			case "reset":
				openingFrame.buttonReset();
				buttonNum = 0;
				
				for(int i = 0;i<electives_select.length;i++){
					electives_select[i] = "";
				}
				
				break;
				
			default:
				if(buttonNum < 2){
					if(buttonNum == 0 || electives_select[buttonNum-1] != action){
						electives_select[buttonNum] = action;
						buttonNum++;
						((JButton) e.getSource()).setForeground(Color.MAGENTA);
						
						if(buttonNum == 2){
							openingFrame.enableSubmit(true);
						}
					}
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
					openingFrame.setTextEnd(false);
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
