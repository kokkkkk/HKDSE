package frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Basic.initial;
import Basic.o_jbutton;
import Basic.o_textArea;

public class eventFrame{
	
	frame.title title;
	frame.game game;
		
	JPanel gameTextPanel,eventTextPanel,eventPhotoPanel, buttonPanel;
	JLabel eventPhotoLabel;
	JTextArea eventText;
	ImageIcon imageIcon;
	
	int event = 0;
	int count = 0;
	
	int eventNum = 0;
	
	boolean eventEnd = false;
	
	public boolean isEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(boolean eventEnd) {
		this.eventEnd = eventEnd;
	}

	String[] text;
		
	public void setText(String[] text) {
		this.text = text;
	}

	public eventFrame(frame.title tit, frame.game g, int eventNum){
			
		title = tit;
		game = g;
		
		this.eventNum = eventNum;
			
		gameTextPanel = new JPanel();
		gameTextPanel.setLayout(null);
		gameTextPanel.setBounds(20,20,740,520);
		gameTextPanel.setBackground(Color.blue);
	
		eventPhotoPanel = new JPanel();
		eventPhotoPanel.setBounds(0,0,740,380);
		eventPhotoPanel.setBackground(Color.BLACK);
		
		eventPhotoLabel = new JLabel();
		
		eventTextPanel = new JPanel();
		eventTextPanel.setBounds(0,380,740,140);
		eventTextPanel.setAutoscrolls(true);
		eventTextPanel.setLayout(new GridLayout(1,1));
		eventTextPanel.setBackground(Color.blue);
		
		eventText = new o_textArea();
		eventText.setBounds(0,420,740,100);
		eventText.setBackground(Color.black);
		eventText.setForeground(Color.white);
		eventText.setFont(title.normalFont);
		eventText.setLineWrap(true);
		eventText.setEditable(false);
					
		eventTextPanel.add(eventText);
		eventPhotoPanel.add(eventPhotoLabel);
		
		gameTextPanel.add(eventTextPanel);
		gameTextPanel.add(eventPhotoPanel);

		gameTextPanel.setVisible(false);
		
	}
		
	public void eventSetup(MouseListener mouse, String image){
		
		game.clearFrame();
		game.event();
			
		title.con.add(gameTextPanel);
		
		gameTextPanel.addMouseListener(mouse);
		eventPhotoPanel.addMouseListener(mouse);
		eventText.addMouseListener(mouse);
		eventTextPanel.addMouseListener(mouse);
		
		imageIcon = new ImageIcon(this.getClass().getClassLoader().getResource(image));
		eventPhotoLabel.setIcon(imageIcon);
			
		gameTextPanel.setVisible(true);
		
	}
	
	private void clearFrame(){
		gameTextPanel.setVisible(false);	
	}
	
	public void showEvent(int event){
		if(count == 3){
			eventText.setText("");
			count = 0;
		}
		
		if(event < text.length){
			eventText.append(text[event]+"\n");
			count++;
		}else{
			eventEnd = true;
			
		}

	}
	
	public void addButton(int a, String[] buttonText, ActionListener handler){
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0,380,740,40);
		buttonPanel.setBackground(new Color(88,26,10));
		
		buttonPanel.setLayout(new GridLayout(1,a));
		eventTextPanel.setLayout(new GridLayout(2,1));
		
		for(int i = 0;i<a;i++){
			JButton b = new o_jbutton(buttonText[i]);
			b.setForeground(Color.black);
			b.setFocusPainted(false);
			b.setActionCommand(buttonText[i]);
			b.addActionListener(handler);
			buttonPanel.add(b);
		}
	
		eventTextPanel.add(buttonPanel);
		eventTextPanel.revalidate();
		eventTextPanel.repaint();
	}
	
	public void clearButton(){
		buttonPanel.setVisible(false);
		eventTextPanel.remove(buttonPanel);
		eventTextPanel.setLayout(new GridLayout(1,1));
	}
	
	public void eventEnd(){
		
		if(eventNum == initial.eventNum){
			clearFrame();
			initial.eventNum = 0;
			game.dayReset();
		}else{
			clearFrame();
		}
		
	}
	
	
}
