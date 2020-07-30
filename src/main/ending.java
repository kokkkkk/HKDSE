package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Basic.language;
import frame.endingFrame;

public class ending {
	
	frame.endingFrame endingFrame;
	
	String endVer;
	String text[];
	
	public ending(frame.title tit){
		
		int i = 1;
		
		endVer = "ending"+i;
		String picture = endVer +".png";
		
		endingFrame = new endingFrame(tit,picture);
		
		displayText();
	}
	
	private void displayText(){
		
		String t = "";
		
		t = readText(endVer);
		
		text = t.split("\n");
		
		endingFrame.setText(text);

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

}
