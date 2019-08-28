package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuHandler implements ActionListener {
	
	frame.Main main;
	
	public menuHandler(frame.Main m) {
		
		main = m;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();
		
		switch(action) {
		case "openMenu":
			main.setMenu();
			break;
		case "save":
			break;
		case "backToTitle":
			main.window.dispose();
			frame.Main m = new frame.Main();
			break;
		case "back":
			main.clearMenu();
			break;
			
		}
		
	}

}
