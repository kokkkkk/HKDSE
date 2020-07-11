package frame;

import main.saveLoad;

import java.awt.Color;
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
	Basic.addUI addUI = new Basic.addUI();
	
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
		
		titleName = new JLabel("DSE Life");
		titleName.setFont(titleFont);
		titleName.setForeground(Color.BLACK);
		titleName.setOpaque(true);
		
		newGameButton = new JButton();
		newGameButton.setBorderPainted(false);
		newGameButton.setMargin(new Insets(0,0,0,0));
		newGameButton.setContentAreaFilled(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setActionCommand("new");
		newGameButton.addActionListener(titleHandler);

		
		continueButton = new JButton();
		continueButton.setBorderPainted(false);
		continueButton.setMargin(new Insets(0,0,0,0));
		continueButton.setContentAreaFilled(false);
		continueButton.setFocusPainted(false);
		continueButton.setContentAreaFilled(false);
		continueButton.setActionCommand("continue");
		continueButton.addActionListener(titleHandler);
		
		exitButton = new JButton();
		exitButton.setBorderPainted(false);
		exitButton.setMargin(new Insets(0,0,0,0));
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setActionCommand("exit");
		exitButton.addActionListener(titleHandler);
		
		titleImagePanel.add(titleImageLabel);
	
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
		
		addUI.addUI_button(newGameButton,"New Game",choices.getWidth()-5,100,normalFont);
		addUI.addUI_button(continueButton,"Continue",choices.getWidth()-5,100,normalFont);
		addUI.addUI_button(exitButton,"Exit",choices.getWidth()-5,100,normalFont);
		addUI.addUI_label(titleName, title.getWidth(), title.getHeight());
		
		title.add(titleName);
		
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
