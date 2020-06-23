package frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class eventFrame {
	
	frame.title title;
	frame.game game;
		
	JPanel gameTextPanel;
	JTextArea eventText;
	
	int event = 0;
	
	String[] text;
		
	public void setText(String[] text) {
		this.text = text;
	}

	public eventFrame(frame.title tit, frame.game g){
			
		title = tit;
		game = g;
			
		gameTextPanel = new JPanel();
		gameTextPanel.setBounds(100,50,590,400);
		gameTextPanel.setBackground(Color.blue);
		gameTextPanel.addMouseListener(mouse);
	
		eventText = new JTextArea();
		eventText.setBounds(100,50,590,400);
		eventText.setBackground(Color.black);
		eventText.setForeground(Color.white);
		eventText.setFont(title.normalFont);
		eventText.setLineWrap(true);
		eventText.setEditable(false);
		eventText.addMouseListener(mouse);
			
		gameTextPanel.add(eventText);

		gameTextPanel.setVisible(false);
		
	}
		
	public void eventSetup(){
		
		game.clearFrame();
			
		title.con.add(gameTextPanel);
			
		gameTextPanel.setVisible(true);
	}
	
	private void clearFrame(){
		gameTextPanel.setVisible(false);	
	}
	
	private void showEvent(int event){
		
		if(event < text.length){
			eventText.append(text[event]+"\n");
			
		}else{
			eventEnd();
		}

	}
	
	public void eventEnd(){
		clearFrame();
		game.dayReset();
	}
	
	MouseListener mouse =  new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			showEvent(event);
			event++;
			// TODO Auto-generated method stub
				
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
