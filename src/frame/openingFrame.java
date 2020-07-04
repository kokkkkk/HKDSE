package frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class openingFrame {
	frame.title title;
		
	JPanel gameTextPanel, openingPhotoPanel, openingTextPanel, buttonPanel;
	JTextArea openingText;
	
	int i;
	int count = 0;
	
	String[] text;
	
	Vector<JButton> button = new Vector<>();
	
	boolean textEnd;
		
	public boolean isTextEnd() {
		return textEnd;
	}

	public void setTextEnd(boolean textEnd) {
		this.textEnd = textEnd;
	}

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
	
public void addButton(int a, String[] buttonText, ActionListener handler){
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0,380,740,40);
		buttonPanel.setBackground(Color.BLACK);
		
		int col = 1+(a+2)/5;
		
		buttonPanel.setLayout(new GridLayout(col,5));
		openingTextPanel.setLayout(new GridLayout(2,1));
		
		for(int i = 0;i<a;i++){
			JButton b = new JButton(buttonText[i]);
			b.setBackground(Color.BLACK);
			b.setForeground(Color.white);
			b.setFocusPainted(false);
			b.setActionCommand(buttonText[i]);
			b.addActionListener(handler);
			buttonPanel.add(b);
			button.add(b);
		}
		
		JButton reset = new JButton("Reset");
		reset.setBackground(Color.BLACK);
		reset.setForeground(Color.GREEN);
		reset.setFocusPainted(false);
		reset.setActionCommand("reset");
		reset.addActionListener(handler);
		buttonPanel.add(reset);
		
		JButton submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.GREEN);
		submit.setFocusPainted(false);
		submit.setActionCommand("submit");
		submit.addActionListener(handler);
		buttonPanel.add(submit);
	
		openingTextPanel.add(buttonPanel);
		openingTextPanel.revalidate();
		openingTextPanel.repaint();
	}
	
	public void clearButton(){
		buttonPanel.setVisible(false);
		openingTextPanel.remove(buttonPanel);
		openingTextPanel.setLayout(new GridLayout(1,1));
	}
	
	public void buttonReset(){
		for(int i = 0; i<button.size();i++){
			button.get(i).setEnabled(true);
		}
	}
	
	private void clearFrame(){
		gameTextPanel.setVisible(false);
	}
	
	public void showOpening(int event){
		
		if(count == 3){
			openingText.setText("");
			count = 0;
		}
		
		if(event < text.length){
			openingText.append(text[event]+"\n");
			count++;
		}else{
			textEnd = true;
		}

	}
	
	public void setText(String[] t){
		text = t;
	}
	
	public void endOpening()
	{
		clearFrame();
		new game(title,i);
	}


}