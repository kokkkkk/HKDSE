package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dayScheduleHandler implements ActionListener {
	
	frame.Game game;
	
	public dayScheduleHandler(frame.Game g) {
		
		game = g;
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String action = event.getActionCommand();
			
		switch(action) {
		case "exit":
			game.clearDaySchedule();
			break;
		
		}
		
		
	}

}
