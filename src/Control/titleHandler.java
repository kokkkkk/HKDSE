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
		
		title.clearFrame();

		main.frameSetup();
		
	}
}

