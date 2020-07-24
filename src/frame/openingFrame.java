package frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Basic.language;
import Basic.o_jbutton;
import Basic.o_textArea;


public class openingFrame {
	frame.title title;
		
	JPanel gameTextPanel, openingPhotoPanel, openingTextPanel, buttonPanel;
	JLabel openingPhotoLabel;
	JTextArea openingText;
	JButton submit;
	ImageIcon imageIcon;
	
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

	public openingFrame(frame.title tit, int i,MouseListener mouse,String image){
			
		title = tit;
		this.i = i;
		
		gameTextPanel = new JPanel();
		gameTextPanel.setLayout(null);
		gameTextPanel.setBounds(20,20,740,520);
		gameTextPanel.setBackground(Color.blue);
		gameTextPanel.addMouseListener(mouse);
	
		openingPhotoPanel = new JPanel();
		openingPhotoPanel.setBounds(0,0,740,380);
		openingPhotoPanel.setBackground(Color.black);
		openingPhotoPanel.addMouseListener(mouse);
		
		openingPhotoLabel = new JLabel();
		imageIcon = new ImageIcon(this.getClass().getClassLoader().getResource(image));
		openingPhotoLabel.setIcon(imageIcon);
		
		openingTextPanel = new JPanel();
		openingTextPanel.setBounds(0,380,740,140);
		openingTextPanel.setAutoscrolls(true);
		openingTextPanel.setLayout(new GridLayout(1,1));
		openingTextPanel.setBackground(Color.blue);
		openingTextPanel.addMouseListener(mouse);
		
		openingText = new o_textArea();
		openingText.setBounds(0,420,740,100);
		openingText.setForeground(Color.white);
		openingText.setFont(title.normalFont);
		openingText.setLineWrap(true);
		openingText.setEditable(false);
		openingText.addMouseListener(mouse);
			
		openingTextPanel.add(openingText);
		openingPhotoPanel.add(openingPhotoLabel);
		
		gameTextPanel.add(openingTextPanel);
		gameTextPanel.add(openingPhotoPanel);

		gameTextPanel.setVisible(true);
		
		openingSetup();
	}
		
	public void openingSetup(){
			
		title.con.add(gameTextPanel);
		
		gameTextPanel.setVisible(true);
	}
	
	
	public void addButton(int a, String[] buttonText,String[] buttonCommand, ActionListener handler, boolean smart){
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0,380,740,40);
		buttonPanel.setBackground(new Color(88,26,10));
		
		int col = 1+(a+2)/5;
		
		buttonPanel.setLayout(new GridLayout(col,5));
		openingTextPanel.setLayout(new GridLayout(2,1));
		
		for(int i = 0;i<a;i++){
			JButton b = new o_jbutton(buttonText[i]);
			b.setForeground(Color.black);
			b.setName(buttonText[i]);
			b.setBorderPainted(false);
			b.setFocusPainted(false);
			b.setActionCommand(buttonCommand[i]);
			b.addActionListener(handler);
			
			if(!smart){
				if(buttonCommand[i].equals("Bio")||buttonCommand[i].equals("Chem")||buttonCommand[i].equals("Phy")){
					b.setEnabled(false);
				}
			}
			
			buttonPanel.add(b);
			button.add(b);
		}
		
		JButton reset = new o_jbutton(language.getV("dayReset"));
		reset.setForeground(Color.BLACK);
		reset.setFocusPainted(false);
		reset.setBorderPainted(false);
		reset.setActionCommand("reset");
		reset.addActionListener(handler);
		buttonPanel.add(reset);
		
		submit = new o_jbutton(language.getV("submit"));
		submit.setForeground(Color.magenta);
		submit.setBorderPainted(false);
		submit.setFocusPainted(false);
		submit.setActionCommand("submit");
		submit.addActionListener(handler);
		submit.setEnabled(false);
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
			button.get(i).setForeground(Color.BLACK);
		}
		
		enableSubmit(false);
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
	
	public void enableSubmit(boolean enable){
		submit.setEnabled(enable);
	}
	
	public void endOpening()
	{
		clearFrame();
		new game(title,i);
	}


}