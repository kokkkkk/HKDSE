package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dayScheduleHandler implements ActionListener {
	
	frame.Main main;
	
	public dayScheduleHandler(frame.Main m) {
		
		main = m;
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String action = event.getActionCommand();
			
		switch(action) {
		case "exit":
			main.clearDaySchedule();
			break;
		
		}
		
		
	}

}
