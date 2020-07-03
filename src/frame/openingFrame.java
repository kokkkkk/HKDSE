package frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class openingFrame {
	frame.title title;
		
	JPanel gameTextPanel, openingPhotoPanel, openingTextPanel;
	JTextArea openingText;
	
	int i;
	
	String[] text = {"opening"};
		
	public openingFrame(frame.title tit, int i,MouseListener mouse){
			
		title = tit;
		this.i = i;
		
		gameTextPanel = new JPanel();
		gameTextPanel.setLayout(null);
		gameTextPanel.setBounds(20,20,740,520);
		gameTextPanel.setBackground(Color.blue);
		gameTextPanel.addMouseListener(mouse);
	
		openingPhotoPanel = new JPanel();
		openingPhotoPanel.setBounds(0,0,740,380);
		openingPhotoPanel.setBackground(Color.red);
		openingPhotoPanel.addMouseListener(mouse);
		
		openingTextPanel = new JPanel();
		openingTextPanel.setBounds(0,380,740,140);
		openingTextPanel.setAutoscrolls(true);
		openingTextPanel.setLayout(new GridLayout(1,1));
		openingTextPanel.setBackground(Color.blue);
		openingTextPanel.addMouseListener(mouse);
		
		openingText = new JTextArea();
		openingText.setBounds(0,420,740,100);
		openingText.setBackground(Color.black);
		openingText.setForeground(Color.white);
		openingText.setFont(title.normalFont);
		openingText.setLineWrap(true);
		openingText.setEditable(false);
		openingText.addMouseListener(mouse);
			
		openingTextPanel.add(openingText);
		
		gameTextPanel.add(openingTextPanel);
		gameTextPanel.add(openingPhotoPanel);

		gameTextPanel.setVisible(true);
		
		openingSetup();
	}
		
	public void openingSetup(){
			
		title.con.add(gameTextPanel);
			
		gameTextPanel.setVisible(true);
	}
	
	private void clearFrame(){
		gameTextPanel.setVisible(false);
	}
	
	public void showOpening(int event){
		
		if(event < text.length){
			openingText.append(text[event]+"\n");
			
		}else{
			endOpening();
		}

	}
	
	private void endOpening()
	{
		clearFrame();
		new game(title,i);
	}


}