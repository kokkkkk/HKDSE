package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import frame.adminFrame;
import frame.game;

public class keyHandler implements KeyListener {
	
	game game;
	
	public keyHandler(game g){
		game = g;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A){
			
			new adminFrame(game);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
