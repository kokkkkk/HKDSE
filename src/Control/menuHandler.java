package Control;

import main.saveLoad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuHandler implements ActionListener {
	
	frame.game game;
	frame.title title;
	
	saveLoad sL = new saveLoad();
	
	public menuHandler(frame.game g, frame.title tit) {
		
		game = g;
		title = tit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();
		
		switch(action) {
		case "openMenu":
			game.setMenu();
			break;
		case "save":
			sL.saveData();
			game.menuSave(0);
			break;
		case "backToTitle":
			title.window.dispose();
			new frame.title();
			break;
		case "back":
			game.clearMenu();
			game.menuSave(1);
			break;
			
		}
		
	}

}
