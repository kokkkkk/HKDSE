package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class restartHandler implements ActionListener {
	
	frame.title title;
	frame.endGame endGame;
	Time._control time = new Time._control();
	main.study study = new main.study();
	main.result result = new main.result();

	public restartHandler(frame.title tit,frame.endGame end){
		
		title = tit;
		
		endGame = end;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		title.window.dispose();
		new frame.title();
		
	}
}
