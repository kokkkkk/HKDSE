package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class endGameHandler implements ActionListener{
	frame.title title;
	frame.endGame endGame;
	
	boolean r;

	public endGameHandler(frame.title tit,frame.endGame e, boolean result){
		
		title = tit;
		endGame = e;
		
		r = result;
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		endGame.clearFrame();
		
		if(r){
			new main.ending(title,1);
		}else{
			new main.ending(title,2);
		}
		
	}
}

