package frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Basic.language;
import Basic.o_jbutton;
import Basic.o_textArea;

public class endingFrame {
	frame.title title;
	
	JPanel gameTextPanel, endingPhotoPanel, endingTextPanel, restartPanel;
	JLabel endingPhotoLabel;
	JTextArea endingText;
	JButton restartButton;
	ImageIcon imageIcon;
	
	int count = 0;
	int event = 0;
	
	String[] text;
	
	Control.restartHandler restartHandler;

	public endingFrame(frame.title tit, String image){
			
		title = tit;
		
		restartHandler = new Control.restartHandler(tit);
		
		gameTextPanel = new JPanel();
		gameTextPanel.setLayout(null);
		gameTextPanel.setBounds(20,20,740,520);
		gameTextPanel.setBackground(Color.blue);
		gameTextPanel.addMouseListener(mouse);
	
		endingPhotoPanel = new JPanel();
		endingPhotoPanel.setBounds(0,0,740,380);
		endingPhotoPanel.setBackground(Color.black);
		endingPhotoPanel.addMouseListener(mouse);
		
		endingPhotoLabel = new JLabel();
		imageIcon = new ImageIcon(this.getClass().getClassLoader().getResource(image));
		endingPhotoLabel.setIcon(imageIcon);
		
		endingTextPanel = new JPanel();
		endingTextPanel.setBounds(0,380,740,140);
		endingTextPanel.setAutoscrolls(true);
		endingTextPanel.setLayout(new GridLayout(1,1));
		endingTextPanel.setBackground(Color.blue);
		endingTextPanel.addMouseListener(mouse);
		
		restartPanel = new JPanel();
		restartPanel.setBounds(350,500,120,50);
		restartPanel.setOpaque(false);
		
		endingText = new o_textArea();
		endingText.setBounds(0,420,740,100);
		endingText.setForeground(Color.white);
		endingText.setFont(title.normalFont);
		endingText.setLineWrap(true);
		endingText.setEditable(false);
		endingText.addMouseListener(mouse);
			
		endingTextPanel.add(endingText);
		endingPhotoPanel.add(endingPhotoLabel);
		
		restartButton = new o_jbutton(language.getV("restartButton"));
		restartButton.setForeground(Color.BLACK);
		restartButton.setFont(title.normalFont);
		restartButton.setFocusPainted(false);
		restartButton.addActionListener(restartHandler); //when click, call the class
		
		gameTextPanel.add(endingTextPanel);
		gameTextPanel.add(endingPhotoPanel);
		restartPanel.add(restartButton);

		restartPanel.setVisible(false);
		
		endingSetup();
	}
		
	public void endingSetup(){
			
		title.con.add(gameTextPanel);
		title.con.add(restartPanel);
		
		gameTextPanel.setVisible(true);
	}
	
	public void showEnding(int event){
		
		if(count == 3){
			endingText.setText("");
			count = 0;
		}
		
		if(event < text.length){
			endingText.append(text[event]+"\n");
			count++;
		}else{
			end();
		}

	}
	
	public void setText(String[] t){
		text = t;
	}
	
	public void end()
	{
		gameTextPanel.setVisible(false);
		restartPanel.setVisible(true);
	}
	
	MouseListener mouse =  new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			showEnding(event);
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
