package Event.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Event.eventInterface;
import frame.eventFrame;

public class tired_2 implements eventInterface{
	
	buttonHandler buttonHandler  = new buttonHandler();
	
	boolean trig = false;
	String text[] = null;

	@Override
	public boolean trigger() {
		
		return trig;
	}

	@Override
	public void execution(eventFrame eventFrame) {
		
		String t ="";
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("./EventText/tired_2.txt"));
			
			int i;
			
			while((i=br.read())!=-1){
				
				t += (char)i;
				
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		text = t.split("\n");
		
		eventFrame.setText(text);
		
	}

	@Override
	public void result() {
		
		
	}
	
	public class buttonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}

}
