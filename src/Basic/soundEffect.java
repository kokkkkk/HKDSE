package Basic;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class soundEffect {

	Clip clip;
	
	public void setFile(String fileName){
		
		try{
			
			URL url = this.getClass().getClassLoader().getResource(fileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(sound);
			
		}catch(Exception e){
			
		}
		
	}
	
	public void play(){
		
		clip.setFramePosition(0);
		clip.start();
	}
	
}
