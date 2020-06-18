package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frame.Game;

public class titleHandler implements ActionListener {
	
	frame.title title;

	public titleHandler(frame.title tit){
		
		title = tit;
		
	}
	
	public void actionPerformed(ActionEvent event){
		
		String action = event.getActionCommand();
		
		switch(action) {
		case "new":
			title.clearFrame();
			new frame.Game(title,0);
			break;
			
		case "continue":
			title.clearFrame();
			new frame.Game(title,1);
			break;
			
		case "exit":
			System.exit(0);
			break;
		}

	}
}

