package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class restartHandler implements ActionListener {
	
	frame.title title;

	public restartHandler(frame.title tit){
		
		title = tit;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		title.window.dispose();
		new frame.title();
		
	}
}
