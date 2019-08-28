package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frame.Main;

public class restartHandler implements ActionListener {
	
	frame.Main main;
	frame.endGame endGame;
	Time._control time = new Time._control();
	Basic.initial initial = new Basic.initial();
	main.study study = new main.study();
	main.result result = new main.result();

	public restartHandler(frame.Main m,frame.endGame end){
		
		main = m;
		
		endGame = end;
		
	}
	
	public void actionPerformed(ActionEvent event){
		
		frame.Main m = new frame.Main();
		main.window.dispose();
		
	}
}
