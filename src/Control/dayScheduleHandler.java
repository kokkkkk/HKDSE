package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dayScheduleHandler implements ActionListener {
	
	frame.game game;
	
	public dayScheduleHandler(frame.game g) {
		
		game = g;
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String action = event.getActionCommand();
			
		switch(action) {
		case "exit":
			game.addday(1);
			game.clearDaySchedule();
			break;
		
		}
		
		
	}

}
