package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Basic.initial;
import frame.openingFrame;

public class opening {
	
	frame.openingFrame openingFrame;
	
	int event = 0;
	
	int iniValue = initial.iniValue;
	int moneyValue = initial.moneyValue;
	
	boolean rich = false;
	boolean smart = false;
	
	String[] electives;
	
	String text[];
	
	public opening(frame.title tit, int i){
		
		openingFrame = new openingFrame(tit,0,mouse);
	}
	
	MouseListener mouse =  new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			openingFrame.showOpening(event);
			event++;
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}
	};
}
