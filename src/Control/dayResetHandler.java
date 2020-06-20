package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dayResetHandler implements ActionListener {
	
	frame.game game;
	
	public dayResetHandler(frame.game g){
		
		game = g;
		
	}
	
	public void actionPerformed(ActionEvent event){
		
		game.dayReset();
		
	}
	
	
}
