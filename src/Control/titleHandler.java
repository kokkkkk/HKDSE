package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Basic.initial;
import frame.game;
import main.opening;

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
			
			 initial.valueReset();	
        
			new opening(title,0);

			break;
			
		case "continue":
			title.clearFrame();

			new game(title,1);

			break;
			
		case "exit":
			System.exit(0);
			break;
		}

	}
}

