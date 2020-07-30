package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class endGameHandler implements ActionListener{
	frame.title title;
	frame.endGame endGame;

	public endGameHandler(frame.title tit,frame.endGame e){
		
		title = tit;
		endGame = e;
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		endGame.clearFrame();
		new main.ending(title);
		
	}
}

