package frame;

import main.saveLoad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Basic.o_jLabel;
import Basic.o_jbutton;

public class title{
	
	
	public JFrame window;
	
	public JLayeredPane con;
	
	Font normalFont = new Font("Times New Roman", Font.PLAIN,21);
	Font smallFont = new Font("Times New Roman", Font.PLAIN,17);
	Font VerysmallFont = new Font("Times New Roman", Font.PLAIN,9);
	
	JPanel title, choices, titleImagePanel;
	JLabel titleName,titleImageLabel;
	JButton newGameButton,continueButton,exitButton;
	
	ImageIcon titleImage;
	
	main.saveLoad saveLoad = new saveLoad();
	
	Control.titleHandler titleHandler;
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN,30);
	
	public title(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null); //customize layout not use default layout
		window.setFocusable(true);
		
		con = window.getLayeredPane();
		
		titleImage = new ImageIcon(getClass().getClassLoader().getResource("background.png"));
		
		titleImagePanel = new JPanel();
		titleImagePanel.setBounds(0,0,800,600);
		
		titleImageLabel = new JLabel();
		titleImageLabel.setIcon(titleImage);
		
		titleHandler = new Control.titleHandler(this);
		
		title = new JPanel();
		title.setBounds(100,30,600,100);
		title.setOpaque(false);
		
		choices = new JPanel();
		choices.setLayout(new GridLayout(3,1));
		choices.setBounds(160,160,500,300);
		choices.setOpaque(false);
		
		titleName = new o_jLabel("DSE Life");
		titleName.setFont(titleFont);
		titleName.setPreferredSize(new Dimension(600,100));
		titleName.setForeground(Color.BLACK);
		
		newGameButton = new o_jbutton("New Game");
		newGameButton.setFont(normalFont);
		newGameButton.setBorderPainted(false);
		newGameButton.setForeground(Color.BLACK);
		newGameButton.setFocusPainted(false);
		newGameButton.setActionCommand("new");
		newGameButton.addActionListener(titleHandler);

		
		continueButton = new o_jbutton("Continue");
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
