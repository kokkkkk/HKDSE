package frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class eventFrame {
	
	frame.title title;
	frame.game game;
		
	JPanel gameTextPanel,eventTextPanel,eventPhotoPanel, buttonPanel;
	JTextArea eventText;
	
	int event = 0;
	int count = 0;
	
	String[] text;
		
	public void setText(String[] text) {
		this.text = text;
	}

	public eventFrame(frame.title tit, frame.game g){
			
		title = tit;
		game = g;
			
		gameTextPanel = new JPanel();
		gameTextPanel.setLayout(null);
		gameTextPanel.setBounds(20,20,740,520);
		gameTextPanel.setBackground(Color.blue);
		gameTextPanel.addMouseListener(mouse);
	
		eventPhotoPanel = new JPanel();
		eventPhotoPanel.setBounds(0,0,740,380);
		eventPhotoPanel.setBackground(Color.red);
		eventPhotoPanel.addMouseListener(mouse);
		
		eventTextPanel = new JPanel();
		eventTextPanel.setBounds(0,380,740,140);
		eventTextPanel.setAutoscrolls(true);
		eventTextPanel.setLayout(new GridLayout(1,1));
		eventTextPanel.setBackground(Color.blue);
		eventTextPanel.addMouseListener(mouse);
		
		eventText = new JTextArea();
		eventText.setBounds(0,420,740,100);
		eventText.setBackground(Color.black);
		eventText.setForeground(Color.white);
		eventText.setFont(title.normalFont);
		eventText.setLineWrap(true);
		eventText.setEditable(false);
		eventText.addMouseListener(mouse);
			
		eventTextPanel.add(eventText);
		
		gameTextPanel.add(eventTextPanel);
		gameTextPanel.add(eventPhotoPanel);

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
		if(count == 3){
			eventText.setText("");
			count = 0;
		}
		
		if(event < text.length){
			eventText.append(text[event]+"\n");
			count++;
		}else{
			eventEnd();
		}

	}
	
	public void addButton(int a, String[] buttonText, ActionListener handler){
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0,380,740,40);
		
		buttonPanel.setLayout(new GridLayout(1,a));
		eventTextPanel.setLayout(new GridLayout(2,1));
		
		for(int i = 0;i<a;i++){
			JButton b = new JButton(buttonText[i]);
			b.setBackground(Color.black);
			b.setForeground(Color.white);
			b.setFocusPainted(false);
			b.setActionCommand(buttonText[i]);
			b.addActionListener(handler);
			buttonPanel.add(b);
		}
	
		eventTextPanel.add(buttonPanel);
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
