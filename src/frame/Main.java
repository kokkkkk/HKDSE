package frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Main {
	
	public JFrame window;
	public Container con;
	JPanel dayPanel, mainTextPanel,dataPanel,adddayPanel,m_choicePanel,a_choicePanel,n_choicePanel,mPanel,aPanel,
	nPanel,energyLevelPanel;
	JLabel dayLabel, dayNumber,dataName1,dataName2,dataName3,dataName4,dataName5,dataName6,dataNum1,dataNum2,
	dataNum3,dataNum4,dataNum5,dataNum6,mLabel,aLabel,nLabel,energyLevelLabel;
	JButton dayAdd, m_chin,m_eng,m_math,m_ls,m_sub1,m_sub2,a_chin,a_eng,a_math,a_ls,a_sub1,a_sub2,n_chin,n_eng,
	n_math,n_ls,n_sub1,n_sub2;
	JProgressBar energyBar;
	Font normalFont = new Font("Times New Roman", Font.PLAIN,21);
	int day, chin, eng, math, ls, sub1, sub2;
	private int[] studySubject = {0,0,0};
	
	Basic.initial initial = new Basic.initial();
	Control.choiceHandler choiceHandler = new Control.choiceHandler(this);
	Control.input input = new Control.input(this);
	main.study study = new main.study();
	main.result result = new main.result();
	frame.endGame endGame = new endGame(this);
	
	public static void main(String[] args) {
		new Main();

	}
	
	public Main(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null); //customize layout not use default layout
		
		con = window.getContentPane();
		
		dayPanel = new JPanel();
		dayPanel.setBounds(650,20,100,40);
		dayPanel.setBackground(Color.red);
		
		energyLevelPanel = new JPanel();
		energyLevelPanel.setBounds(400,20,200,50);
		energyLevelPanel.setBackground(Color.red);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(160,100,590,400);
		mainTextPanel.setBackground(Color.red);
		
		dataPanel = new JPanel();
		dataPanel.setBounds(10,100,150,400);
		dataPanel.setLayout(new GridLayout(6,2));
		dataPanel.setBackground(Color.blue);
		
		m_choicePanel = new JPanel();
		m_choicePanel.setBounds(160,130,590,100);
		m_choicePanel.setLayout(new GridLayout(1,6));
		m_choicePanel.setBackground(Color.blue);
		
		a_choicePanel = new JPanel();
		a_choicePanel.setBounds(160,260,590,100);
		a_choicePanel.setLayout(new GridLayout(1,6));
		a_choicePanel.setBackground(Color.blue);
		
		n_choicePanel = new JPanel();
		n_choicePanel.setBounds(160,390,590,100);
		n_choicePanel.setLayout(new GridLayout(1,6));
		n_choicePanel.setBackground(Color.blue);
		
		adddayPanel = new JPanel();
		adddayPanel.setBounds(350,500,200,50);
		adddayPanel.setBackground(Color.blue);
		
		mPanel = new JPanel();
		mPanel.setBounds(160,100,590,30);
		mPanel.setBackground(Color.green);
		
		aPanel = new JPanel();
		aPanel.setBounds(160,230,590,30);
		aPanel.setBackground(Color.green);
		
		nPanel = new JPanel();
		nPanel.setBounds(160,360,590,30);
		nPanel.setBackground(Color.green);
		
		dayLabel = new JLabel("Day: ");
		dayLabel.setFont(normalFont);
		dayLabel.setForeground(Color.white);
		
		energyLevelLabel = new JLabel("Energy",SwingConstants.CENTER);
		energyLevelLabel.setFont(normalFont);
		energyLevelLabel.setForeground(Color.white);
		
		dayNumber = new JLabel();
		dayNumber.setFont(normalFont);
		dayNumber.setForeground(Color.white);
		
		dataName1 = new JLabel("Chin: ");
		dataName1.setFont(normalFont);
		dataName1.setForeground(Color.white);
		
		dataName2 = new JLabel("Eng: ");
		dataName2.setFont(normalFont);
		dataName2.setForeground(Color.white);
		
		dataName3 = new JLabel("Math: ");
		dataName3.setFont(normalFont);
		dataName3.setForeground(Color.white);
		
		dataName4 = new JLabel("LS: ");
		dataName4.setFont(normalFont);
		dataName4.setForeground(Color.white);
		
		dataName5 = new JLabel("Sub1: ");
		dataName5.setFont(normalFont);
		dataName5.setForeground(Color.white);
		
		dataName6 = new JLabel("Sub2: ");
		dataName6.setFont(normalFont);
		dataName6.setForeground(Color.white);
		
		dataNum1 = new JLabel();
		dataNum1.setFont(normalFont);
		dataNum1.setForeground(Color.white);
		
		dataNum2 = new JLabel();
		dataNum2.setFont(normalFont);
		dataNum2.setForeground(Color.white);
		
		dataNum3 = new JLabel();
		dataNum3.setFont(normalFont);
		dataNum3.setForeground(Color.white);
		
		dataNum4 = new JLabel();
		dataNum4.setFont(normalFont);
		dataNum4.setForeground(Color.white);
		
		dataNum5 = new JLabel();
		dataNum5.setFont(normalFont);
		dataNum5.setForeground(Color.white);
		
		dataNum6 = new JLabel();
		dataNum6.setFont(normalFont);
		dataNum6.setForeground(Color.white);
		
		mLabel = new JLabel("Morning");
		mLabel.setFont(normalFont);
		mLabel.setForeground(Color.white);
		
		aLabel = new JLabel("Afternoon");
		aLabel.setFont(normalFont);
		aLabel.setForeground(Color.white);
		
		nLabel = new JLabel("Night");
		nLabel.setFont(normalFont);
		nLabel.setForeground(Color.white);
		
		dayAdd = new JButton("Add day");
		dayAdd.setBackground(Color.black);
		dayAdd.setForeground(Color.white);
		dayAdd.setFont(normalFont);
		dayAdd.setFocusPainted(false);
		dayAdd.addActionListener(input); //when click, call the class
		
		m_chin = new JButton("Chin");
		m_chin.setBackground(Color.black);
		m_chin.setForeground(Color.white);
		m_chin.setFont(normalFont);
		m_chin.setFocusPainted(false);
		m_chin.setActionCommand("m_chin");
		m_chin.addActionListener(choiceHandler); //when click, call the class
		
		m_eng = new JButton("Eng");
		m_eng.setBackground(Color.black);
		m_eng.setForeground(Color.white);
		m_eng.setFont(normalFont);
		m_eng.setFocusPainted(false);
		m_eng.setActionCommand("m_eng");
		m_eng.addActionListener(choiceHandler); //when click, call the class
		
		m_math = new JButton("Math");
		m_math.setBackground(Color.black);
		m_math.setForeground(Color.white);
		m_math.setFont(normalFont);
		m_math.setFocusPainted(false);
		m_math.setActionCommand("m_math");
		m_math.addActionListener(choiceHandler); //when click, call the class
		
		m_ls = new JButton("LS");
		m_ls.setBackground(Color.black);
		m_ls.setForeground(Color.white);
		m_ls.setFont(normalFont);
		m_ls.setFocusPainted(false);
		m_ls.setActionCommand("m_ls");
		m_ls.addActionListener(choiceHandler); //when click, call the class
		
		m_sub1 = new JButton("Sub1");
		m_sub1.setBackground(Color.black);
		m_sub1.setForeground(Color.white);
		m_sub1.setFont(normalFont);
		m_sub1.setFocusPainted(false);
		m_sub1.setActionCommand("m_sub1");
		m_sub1.addActionListener(choiceHandler); //when click, call the class
		
		m_sub2 = new JButton("Sub2");
		m_sub2.setBackground(Color.black);
		m_sub2.setForeground(Color.white);
		m_sub2.setFont(normalFont);
		m_sub2.setFocusPainted(false);
		m_sub2.setActionCommand("m_sub2");
		m_sub2.addActionListener(choiceHandler); //when click, call the class
		
		a_chin = new JButton("Chin");
		a_chin.setBackground(Color.black);
		a_chin.setForeground(Color.white);
		a_chin.setFont(normalFont);
		a_chin.setFocusPainted(false);
		a_chin.setActionCommand("a_chin");
		a_chin.addActionListener(choiceHandler); //when click, call the class
		
		a_eng = new JButton("Eng");
		a_eng.setBackground(Color.black);
		a_eng.setForeground(Color.white);
		a_eng.setFont(normalFont);
		a_eng.setFocusPainted(false);
		a_eng.setActionCommand("a_eng");
		a_eng.addActionListener(choiceHandler); //when click, call the class
		
		a_math = new JButton("Math");
		a_math.setBackground(Color.black);
		a_math.setForeground(Color.white);
		a_math.setFont(normalFont);
		a_math.setFocusPainted(false);
		a_math.setActionCommand("a_math");
		a_math.addActionListener(choiceHandler); //when click, call the class
		
		a_ls = new JButton("LS");
		a_ls.setBackground(Color.black);
		a_ls.setForeground(Color.white);
		a_ls.setFont(normalFont);
		a_ls.setFocusPainted(false);
		a_ls.setActionCommand("a_ls");
		a_ls.addActionListener(choiceHandler); //when click, call the class
		
		a_sub1 = new JButton("Sub1");
		a_sub1.setBackground(Color.black);
		a_sub1.setForeground(Color.white);
		a_sub1.setFont(normalFont);
		a_sub1.setFocusPainted(false);
		a_sub1.setActionCommand("a_sub1");
		a_sub1.addActionListener(choiceHandler); //when click, call the class
		
		a_sub2 = new JButton("Sub2");
		a_sub2.setBackground(Color.black);
		a_sub2.setForeground(Color.white);
		a_sub2.setFont(normalFont);
		a_sub2.setFocusPainted(false);
		a_sub2.setActionCommand("a_sub2");
		a_sub2.addActionListener(choiceHandler); //when click, call the class
		
		n_chin = new JButton("Chin");
		n_chin.setBackground(Color.black);
		n_chin.setForeground(Color.white);
		n_chin.setFont(normalFont);
		n_chin.setFocusPainted(false);
		n_chin.setActionCommand("n_chin");
		n_chin.addActionListener(choiceHandler); //when click, call the class
		
		n_eng = new JButton("Eng");
		n_eng.setBackground(Color.black);
		n_eng.setForeground(Color.white);
		n_eng.setFont(normalFont);
		n_eng.setFocusPainted(false);
		n_eng.setActionCommand("n_eng");
		n_eng.addActionListener(choiceHandler); //when click, call the class
		
		n_math = new JButton("Math");
		n_math.setBackground(Color.black);
		n_math.setForeground(Color.white);
		n_math.setFont(normalFont);
		n_math.setFocusPainted(false);
		n_math.setActionCommand("n_math");
		n_math.addActionListener(choiceHandler); //when click, call the class
		
		n_ls = new JButton("LS");
		n_ls.setBackground(Color.black);
		n_ls.setForeground(Color.white);
		n_ls.setFont(normalFont);
		n_ls.setFocusPainted(false);
		n_ls.setActionCommand("n_ls");
		n_ls.addActionListener(choiceHandler); //when click, call the class
		
		n_sub1 = new JButton("Sub1");
		n_sub1.setBackground(Color.black);
		n_sub1.setForeground(Color.white);
		n_sub1.setFont(normalFont);
		n_sub1.setFocusPainted(false);
		n_sub1.setActionCommand("n_sub1");
		n_sub1.addActionListener(choiceHandler); //when click, call the class
		
		n_sub2 = new JButton("Sub2");
		n_sub2.setBackground(Color.black);
		n_sub2.setForeground(Color.white);
		n_sub2.setFont(normalFont);
		n_sub2.setFocusPainted(false);
		n_sub2.setActionCommand("n_sub2");
		n_sub2.addActionListener(choiceHandler); //when click, call the class
		
		energyBar = new JProgressBar();
		energyBar.setPreferredSize(new Dimension(200,50));
		energyBar.setValue(100);
		
		dayPanel.add(dayLabel);
		dayPanel.add(dayNumber);
		
		energyLevelPanel.add(energyLevelLabel);
		energyLevelPanel.add(energyBar);
		
		adddayPanel.add(dayAdd);

		dataPanel.add(dataName1);
		dataPanel.add(dataNum1);
		dataPanel.add(dataName2);
		dataPanel.add(dataNum2);
		dataPanel.add(dataName3);
		dataPanel.add(dataNum3);
		dataPanel.add(dataName4);
		dataPanel.add(dataNum4);
		dataPanel.add(dataName5);
		dataPanel.add(dataNum5);
		dataPanel.add(dataName6);
		dataPanel.add(dataNum6);
		
		mPanel.add(mLabel);
		aPanel.add(aLabel);
		nPanel.add(nLabel);
		
		m_choicePanel.add(m_chin);
		m_choicePanel.add(m_eng);
		m_choicePanel.add(m_math);
		m_choicePanel.add(m_ls);
		m_choicePanel.add(m_sub1);
		m_choicePanel.add(m_sub2);
		
		a_choicePanel.add(a_chin);
		a_choicePanel.add(a_eng);
		a_choicePanel.add(a_math);
		a_choicePanel.add(a_ls);
		a_choicePanel.add(a_sub1);
		a_choicePanel.add(a_sub2);
		
		n_choicePanel.add(n_chin);
		n_choicePanel.add(n_eng);
		n_choicePanel.add(n_math);
		n_choicePanel.add(n_ls);
		n_choicePanel.add(n_sub1);
		n_choicePanel.add(n_sub2);
		
		con.add(dayPanel);
		con.add(mPanel);
		con.add(m_choicePanel);
		con.add(a_choicePanel);
		con.add(n_choicePanel);
		con.add(aPanel);
		con.add(nPanel);
		con.add(mainTextPanel);
		con.add(dataPanel);
		con.add(adddayPanel);
		con.add(energyLevelPanel);
		
		window.setVisible(true);
		
		valueSetup(initial.day, initial.Chin, initial.Eng, initial.Math, initial.ls, initial.sub_1 , initial.sub_2);
	}
	
	public void valueSetup(int dayValue, int chinValue, int engValue, int mathValue, int lsValue, int sub1Value, int sub2Value){
		day = dayValue;
		chin = chinValue;
		eng = engValue;
		math = mathValue;
		ls = lsValue;
		sub1 = sub1Value;
		sub2 = sub2Value;
		
		dayNumber.setText(""+day);
		dataNum1.setText(""+chin);
		dataNum2.setText(""+eng);
		dataNum3.setText(""+math);
		dataNum4.setText(""+ls);
		dataNum5.setText(""+sub1);
		dataNum6.setText(""+sub2);
	}
	
	public void morningAction(int sub){
		getStudySubject()[0] = sub;
		switch(sub){
		case 1 :
			m_eng.setEnabled(false);
			m_math.setEnabled(false);
			m_ls.setEnabled(false);
			m_sub1.setEnabled(false);
			m_sub2.setEnabled(false);
			break;
		case 2:
			m_chin.setEnabled(false);
			m_math.setEnabled(false);
			m_ls.setEnabled(false);
			m_sub1.setEnabled(false);
			m_sub2.setEnabled(false);
			break;
		case 3:
			m_chin.setEnabled(false);
			m_eng.setEnabled(false);
			m_ls.setEnabled(false);
			m_sub1.setEnabled(false);
			m_sub2.setEnabled(false);
			break;
		case 4:
			m_chin.setEnabled(false);
			m_math.setEnabled(false);
			m_eng.setEnabled(false);
			m_sub1.setEnabled(false);
			m_sub2.setEnabled(false);
			break;
		case 5:
			m_chin.setEnabled(false);
			m_math.setEnabled(false);
			m_ls.setEnabled(false);
			m_eng.setEnabled(false);
			m_sub2.setEnabled(false);
			break;
		case 6:
			m_chin.setEnabled(false);
			m_math.setEnabled(false);
			m_ls.setEnabled(false);
			m_sub1.setEnabled(false);
			m_eng.setEnabled(false);
			break;
		}
	}
	
	public void afternoonAction(int sub){
		getStudySubject()[1] = sub;
		switch(sub){
		case 1 :
			a_eng.setEnabled(false);
			a_math.setEnabled(false);
			a_ls.setEnabled(false);
			a_sub1.setEnabled(false);
			a_sub2.setEnabled(false);
			break;
		case 2:
			a_chin.setEnabled(false);
			a_math.setEnabled(false);
			a_ls.setEnabled(false);
			a_sub1.setEnabled(false);
			a_sub2.setEnabled(false);
			break;
		case 3:
			a_chin.setEnabled(false);
			a_eng.setEnabled(false);
			a_ls.setEnabled(false);
			a_sub1.setEnabled(false);
			a_sub2.setEnabled(false);
			break;
		case 4:
			a_chin.setEnabled(false);
			a_math.setEnabled(false);
			a_eng.setEnabled(false);
			a_sub1.setEnabled(false);
			a_sub2.setEnabled(false);
			break;
		case 5:
			a_chin.setEnabled(false);
			a_math.setEnabled(false);
			a_ls.setEnabled(false);
			a_eng.setEnabled(false);
			a_sub2.setEnabled(false);
			break;
		case 6:
			a_chin.setEnabled(false);
			a_math.setEnabled(false);
			a_ls.setEnabled(false);
			a_sub1.setEnabled(false);
			a_eng.setEnabled(false);
			break;
		}
	}
	
	public void nightAction(int sub){
		getStudySubject()[2] = sub;
		switch(sub){
		case 1 :
			n_eng.setEnabled(false);
			n_math.setEnabled(false);
			n_ls.setEnabled(false);
			n_sub1.setEnabled(false);
			n_sub2.setEnabled(false);
			break;
		case 2:
			n_chin.setEnabled(false);
			n_math.setEnabled(false);
			n_ls.setEnabled(false);
			n_sub1.setEnabled(false);
			n_sub2.setEnabled(false);
			break;
		case 3:
			n_chin.setEnabled(false);
			n_eng.setEnabled(false);
			n_ls.setEnabled(false);
			n_sub1.setEnabled(false);
			n_sub2.setEnabled(false);
			break;
		case 4:
			n_chin.setEnabled(false);
			n_math.setEnabled(false);
			n_eng.setEnabled(false);
			n_sub1.setEnabled(false);
			n_sub2.setEnabled(false);
			break;
		case 5:
			n_chin.setEnabled(false);
			n_math.setEnabled(false);
			n_ls.setEnabled(false);
			n_eng.setEnabled(false);
			n_sub2.setEnabled(false);
			break;
		case 6:
			n_chin.setEnabled(false);
			n_math.setEnabled(false);
			n_ls.setEnabled(false);
			n_sub1.setEnabled(false);
			n_eng.setEnabled(false);
			break;
		}
	}
	
	public void dayReset(){
		
		for(int i=0; i<studySubject.length;i++){
			studySubject[i] = 0;
		}
		
		m_chin.setEnabled(true);
		m_eng.setEnabled(true);
		m_math.setEnabled(true);
		m_ls.setEnabled(true);
		m_sub1.setEnabled(true);
		m_sub2.setEnabled(true);
		
		a_chin.setEnabled(true);
		a_eng.setEnabled(true);
		a_math.setEnabled(true);
		a_ls.setEnabled(true);
		a_sub1.setEnabled(true);
		a_sub2.setEnabled(true);
		
		n_chin.setEnabled(true);
		n_eng.setEnabled(true);
		n_math.setEnabled(true);
		n_ls.setEnabled(true);
		n_sub1.setEnabled(true);
		n_sub2.setEnabled(true);
	}
	
	public void changeEnergyBar(int energyValue){
		
		energyBar.setValue(energyValue);
		
	}
	
	public void energyUseup(){
		
		m_chin.setEnabled(false);
		m_eng.setEnabled(false);
		m_math.setEnabled(false);
		m_ls.setEnabled(false);
		m_sub1.setEnabled(false);
		m_sub2.setEnabled(false);
		
		a_chin.setEnabled(false);
		a_eng.setEnabled(false);
		a_math.setEnabled(false);
		a_ls.setEnabled(false);
		a_sub1.setEnabled(false);
		a_sub2.setEnabled(false);
		
		n_chin.setEnabled(false);
		n_eng.setEnabled(false);
		n_math.setEnabled(false);
		n_ls.setEnabled(false);
		n_sub1.setEnabled(false);
		n_sub2.setEnabled(false);
		
	}
	
	public void endGame(int[] mark){
		dayPanel.setVisible(false);
		mainTextPanel.setVisible(false);
		dataPanel.setVisible(false);
		adddayPanel.setVisible(false);
		m_choicePanel.setVisible(false);
		a_choicePanel.setVisible(false);
		n_choicePanel.setVisible(false);
		mPanel.setVisible(false);
		aPanel.setVisible(false);
		nPanel.setVisible(false);
		
		endGame.resultSetup(mark);
	}

	public int[] getStudySubject() {
		return studySubject;
	}

	public void setStudySubject(int[] studySubject) {
		this.studySubject = studySubject;
	}
}