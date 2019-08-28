package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class titleHandler implements ActionListener {
	
	frame.Main main;
	frame.title title;

	public titleHandler(frame.Main m, frame.title tit){
		
		main = m;
		
		title = tit;
		
	}
	
	public void actionPerformed(ActionEvent event){
		
		String action = event.getActionCommand();
		
		switch(action) {
		case "new":
			title.clearFrame();
			main.frameSetup();
			break;
			
		case "continue":
			break;
			
		case "exit":
			System.exit(0);
			break;
		}

	}
}

