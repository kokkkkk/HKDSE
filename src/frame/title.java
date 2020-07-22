package frame;

import main.saveLoad;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Basic.language;
import Basic.o_jPanel;
import Basic.o_jbutton;

public class title{
	
	
	public JFrame window;
	
	public JLayeredPane con;
	
	Font titleFont,normalFont,smallFont,VerysmallFont;
	
	JPanel title, choices, titleImagePanel;
	JLabel titleName,titleImageLabel;
	JButton newGameButton,continueButton,exitButton;
	
	ImageIcon titleImage;
	
	main.saveLoad saveLoad = new saveLoad();
	
	Control.titleHandler titleHandler;
	
	public title(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null); //customize layout not use default layout
		window.setFocusable(true);
		
		con = window.getLayeredPane();
		
		language.languageSetup(0);
		
		titleFont = language.titleFont;
		normalFont = language.normalFont;
		smallFont = language.smallFont;
		VerysmallFont = language.VerysmallFont;
		
		titleImage = new ImageIcon(getClass().getClassLoader().getResource("background.png"));
		
		titleImagePanel = new JPanel();
		titleImagePanel.setBounds(0,0,800,600);
		
		titleImageLabel = new JLabel();
		titleImageLabel.setIcon(titleImage);
		
		titleHandler = new Control.titleHandler(this);
		
		title = new o_jPanel(1);
		title.setBounds(100,30,600,100);
		
		choices = new JPanel();
		choices.setLayout(new GridLayout(3,1));
		choices.setBounds(160,160,500,300);
		choices.setOpaque(false);
		
		titleName = new JLabel(language.getV("titleName"));
		titleName.setPreferredSize(title.getSize());
		titleName.setFont(titleFont);
		titleName.setForeground(Color.BLACK);
		titleName.setVerticalAlignment(SwingConstants.CENTER);
		titleName.setHorizontalAlignment(SwingConstants.CENTER);
		
		newGameButton = new o_jbutton(language.getV("newGameButton"));
		newGameButton.setFont(normalFont);
		newGameButton.setBorderPainted(false);
		newGameButton.setForeground(Color.BLACK);
		newGameButton.setFocusPainted(false);
		newGameButton.setActionCommand("new");
		newGameButton.addActionListener(titleHandler);

		
		continueButton = new o_jbutton(language.getV("continueButton"));
		continueButton.setFont(normalFont);
		continueButton.setForeground(Color.BLACK);
		continueButton.setBorderPainted(false);
		continueButton.setFocusPainted(false);
		continueButton.setActionCommand("continue");
		continueButton.addActionListener(titleHandler);
		
		exitButton = new o_jbutton("Exit");
		exitButton.setFont(normalFont);
		exitButton.setForeground(Color.BLACK);
		exitButton.setBorderPainted(false);
		exitButton.setFocusPainted(false);
		exitButton.setActionCommand("exit");
		exitButton.addActionListener(titleHandler);
		
		titleImagePanel.add(titleImageLabel);
		title.add(titleName);
		choices.add(newGameButton);
		choices.add(continueButton);
		choices.add(exitButton);
		
		titleSetup();
		
		window.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new title();
	}
	
	public void titleSetup(){
		
		con.add(title);
		con.add(choices);
		con.add(titleImagePanel);
		
		if(!saveLoad.checkFileExist()){
			continueButton.setEnabled(false);
		}
		
		title.setVisible(true);
		choices.setVisible(true);
		
	}
	
	public void clearFrame() {
		
		title.setVisible(false);
		choices.setVisible(false);
		titleImagePanel.setVisible(false);
	}
	
}
