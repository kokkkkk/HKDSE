package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dayResetHandler implements ActionListener {
	
	frame.Game game;
	
	public dayResetHandler(frame.Game g){
		
		game = g;
		
	}
	
	public void actionPerformed(ActionEvent event){
		
		game.dayReset();
		
	}
	
	
}
