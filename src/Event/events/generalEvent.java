package Event.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import Basic.language;
import Event.eventInterface;
import frame.eventFrame;

public class generalEvent{
	
	Object eventExecute;
	
	BufferedReader br;
	
	buttonHandler buttonHandler = new buttonHandler();
	eventFrame eventFrame;
	
	Vector<Integer> eventQueue = new Vector<>(); // text = 1, button = 2
	Vector<String[]> text = new Vector<>();
	Vector<String[]> buttonText = new Vector<>();
	
	int event = 0;
	int eventExe = 0;
	
	boolean eventText = false;
	
	String eventName = "";
	String pictureName ="";

	public generalEvent(Object event){
		eventExecute = event;
		
		eventName = ((eventInterface) event).getname();
		pictureName = ((eventInterface) event).pictureName();
	}
	
	public void execution(eventFrame eventFrame) {
		
		this.eventFrame = eventFrame;
		
		eventFrame.eventSetup(mouse,pictureName);
		
		readText(eventFrame);
			
		evaluateText();
		
	}

	public void result(int i) {
		
		((eventInterface) eventExecute).result(i);
	}
	
	public void evaluateText(){
		
		
		if(eventQueue.get(eventExe) == 1){
					
				eventFrame.setText(text.get(eventExe));
				eventExe ++;
				eventText = true;
					
		}else if(eventQueue.get(eventExe) == 2){
					
				eventFrame.addButton(text.get(eventExe).length, text.get(eventExe), buttonHandler);
				eventExe ++;
				
		}
		
	}
	
	/*
	 * Read Text System
	 * tag: [Text],[Button],[ButtonText]
	 * 
	 * [Text]: enclosed between text
	 * [Button]: insert before add button
	 * 			line 1 : number of button
	 * 			line 2-...: Text of the button
	 * [ButtonText]: insert after each buttonText 
	 *				*buttonText refers to the text that will be shown after clicking the buttons
	 * 
	 */

	public void readText(eventFrame eventFrame) {
		String t ="";
		
		InputStream fileName = this.getClass().getResourceAsStream("/"+eventName+language.lang[language.lang_choose]+".txt");
		
		try {
			
			br = new BufferedReader(new InputStreamReader(fileName));
			
			String line = br.readLine();
			
			while(!line.equals("end")){
				
				if(line.equals("[Text]")){
					
					String temp = br.readLine();
					
					while(!temp.equals("[Text]")){
						
						t += temp+"\n";
						temp = br.readLine();
						
					}
					
					String[] text = t.split("\n");
					
					eventQueue.add(1);
					this.text.add(text);
					
				}else{
					if(line.equals("[Button]")){
						int num = Integer.parseInt(br.readLine());
						
						String[] button = new String[num];
						String[] buttonText = new String[num];
						
						for(int i = 0;i<num;i++){
							button[i] = br.readLine();
						}
						
						int buttonNum = 0;
						
						while(buttonNum<num){
							
							String temp = br.readLine();
							t = "";
							
							while(!temp.equals("[ButtonText]")){
								t+= temp+"\n";
								temp = br.readLine();
							}
								
							buttonNum++;	
							buttonText = t.split("\n");
							this.buttonText.add(buttonText);
						}
						
						
						
						eventQueue.add(2);
						this.text.add(button);
					}
				}
				line = br.readLine();
				t ="";
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public class buttonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String action = e.getActionCommand();
			
			for(int i = 0;i<buttonText.size();i++){
				
				if(action.equals(text.get(eventExe-1)[i])){
					eventFrame.clearButton();
					result(i);
					
					eventFrame.setText(buttonText.get(i));
					eventText = true;
					
				}
			}
			
		}
		
		
	}
	
	private void executeAll(){
		if(eventExe < eventQueue.size()){
			eventFrame.setEventEnd(false);
			evaluateText();
		}else{
			result(-1);
			text.clear();
			buttonText.clear();
			eventQueue.clear();
			eventExe = 0;
			eventFrame.eventEnd();
			
		}
		
		
	}
	
	MouseListener mouse =  new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(eventText){
				
				eventFrame.showEvent(event);
				
				if(eventFrame.isEventEnd()){
					
					event = 0;
					eventText = false;
					executeAll();
					
				}else{
					event++;
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
