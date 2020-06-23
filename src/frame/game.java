package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Basic.initial;
import main.saveLoad;

public class game {
	
	JPanel dayPanel, mainTextPanel,dataPanel,adddayPanel,m_choicePanel,a_choicePanel,n_choicePanel,mPanel,aPanel,
	nPanel,mSubjectPanel,aSubjectPanel,nSubjectPanel,energyLevelPanel,dayResetPanel,moneyPanel,energyStatusPanel,
	daySchedulePanel,menuButtonPanel,menuPanel;
	
	JLabel dayLabel, dayNumber,dataName1,dataName2,dataName3,dataName4,dataName5,dataName6,dataNum1,dataNum2,
	dataNum3,dataNum4,dataNum5,dataNum6,mLabel,aLabel,nLabel,energyLevelLabel,moneyLabel,moneyValueLabel,
	energyStatusLabel,moneyStatusLabel,dayScheduleTitle;
	
	JTextArea daySchedule;
	
	JButton dayAdd, m_chin,m_eng,m_math,m_ls,m_sub1,m_sub2,a_chin,a_eng,a_math,a_ls,a_sub1,a_sub2,n_chin,n_eng,
	n_math,n_ls,n_sub1,n_sub2,dayReset,m_revisionButton,m_doPaperButton,m_tutorialButton,m_breakButton,
	a_revisionButton,a_doPaperButton,a_tutorialButton,a_breakButton,n_revisionButton,n_doPaperButton,
	n_tutorialButton,n_breakButton,dayScheduleExitButton,menuButton,menuSaveButton,menuBackToTitleButton,
	menuBackButton;
	
	JProgressBar energyBar;
	
	int day, chin, eng, math, ls, sub1, sub2, money, showSchedule;
	private int[] studySubject = {0,0,0};
	private int[] choices = {0,0,0};
	boolean moneyUseup,showAllSchedule;
	Timer tmr;
	
	frame.endGame endGame; 

	frame.title title;
	
	Control.choiceHandler choiceHandler;
	Control.input input;
	Control.dayResetHandler dayResetHandler;
	Control.dayScheduleHandler dayScheduleHandler;
	Control.menuHandler menuHandler;
	
	main.saveLoad saveLoad  = new saveLoad();
	
	public game(frame.title tit, int i){
		
		title = tit;
		
		start(i);
		
		endGame = new endGame(title);
		menuHandler = new Control.menuHandler(this,title);
		choiceHandler = new Control.choiceHandler(this);
		input = new Control.input(this,title);

		dayResetHandler = new Control.dayResetHandler(this);
		dayScheduleHandler = new Control.dayScheduleHandler(this);
		
		//Main Pane---------------------------------------------------------->
		
		dayPanel = new JPanel();
		dayPanel.setBounds(650,20,100,40);
		dayPanel.setBackground(Color.red);
		
		energyLevelPanel = new JPanel();
		energyLevelPanel.setBounds(400,20,200,50);
		energyLevelPanel.setBackground(Color.red);
		
		energyStatusPanel = new JPanel();
		energyStatusPanel.setBounds(330,20,70,50);
		energyStatusPanel.setBackground(Color.blue);
		
		moneyPanel = new JPanel();
		moneyPanel.setBounds(10,20,250,40);
		moneyPanel.setBackground(Color.red);
		
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
		
		mSubjectPanel = new JPanel();
		mSubjectPanel.setBounds(160,130,590,100);
		mSubjectPanel.setLayout(new GridLayout(1,6));
		mSubjectPanel.setBackground(Color.blue);
		
		aSubjectPanel = new JPanel();
		aSubjectPanel.setBounds(160,260,590,100);
		aSubjectPanel.setLayout(new GridLayout(1,6));
		aSubjectPanel.setBackground(Color.blue);
		
		nSubjectPanel = new JPanel();
		nSubjectPanel.setBounds(160,390,590,100);
		nSubjectPanel.setLayout(new GridLayout(1,6));
		nSubjectPanel.setBackground(Color.blue);
		
		adddayPanel = new JPanel();
		adddayPanel.setBounds(350,500,120,50);
		adddayPanel.setBackground(Color.blue);
		
		dayResetPanel = new JPanel();
		dayResetPanel.setBounds(500,500,120,50);
		dayResetPanel.setBackground(Color.blue);
		
		mPanel = new JPanel();
		mPanel.setBounds(160,100,590,30);
		mPanel.setBackground(Color.green);
		
		aPanel = new JPanel();
		aPanel.setBounds(160,230,590,30);
		aPanel.setBackground(Color.green);
		
		nPanel = new JPanel();
		nPanel.setBounds(160,360,590,30);
		nPanel.setBackground(Color.green);
		
		menuButtonPanel = new JPanel();
		menuButtonPanel.setBounds(700,520,60,40);
		menuButtonPanel.setLayout(new GridLayout(1,6));
		menuButtonPanel.setBackground(Color.blue);
		
		dayLabel = new JLabel("Day: ");
		dayLabel.setFont(title.normalFont);
		dayLabel.setForeground(Color.white);
		
		moneyLabel = new JLabel("Money: ");
		moneyLabel.setFont(title.normalFont);
		moneyLabel.setForeground(Color.white);
		
		moneyStatusLabel = new JLabel();
		moneyStatusLabel.setFont(title.normalFont);
		moneyStatusLabel.setForeground(Color.black);
		
		energyLevelLabel = new JLabel("Energy",SwingConstants.CENTER);
		energyLevelLabel.setFont(title.normalFont);
		energyLevelLabel.setForeground(Color.white);
		
		energyStatusLabel = new JLabel();
		energyStatusLabel.setFont(title.normalFont);
		energyStatusLabel.setForeground(Color.white);
		
		dayNumber = new JLabel();
		dayNumber.setFont(title.normalFont);
		dayNumber.setForeground(Color.white);
		
		moneyValueLabel = new JLabel("0");
		moneyValueLabel.setFont(title.normalFont);
		moneyValueLabel.setForeground(Color.white);
		
		dataName1 = new JLabel("Chin: ");
		dataName1.setFont(title.normalFont);
		dataName1.setForeground(Color.white);
		
		dataName2 = new JLabel("Eng: ");
		dataName2.setFont(title.normalFont);
		dataName2.setForeground(Color.white);
		
		dataName3 = new JLabel("Math: ");
		dataName3.setFont(title.normalFont);
		dataName3.setForeground(Color.white);
		
		dataName4 = new JLabel("LS: ");
		dataName4.setFont(title.normalFont);
		dataName4.setForeground(Color.white);
		
		dataName5 = new JLabel("Sub1: ");
		dataName5.setFont(title.normalFont);
		dataName5.setForeground(Color.white);
		
		dataName6 = new JLabel("Sub2: ");
		dataName6.setFont(title.normalFont);
		dataName6.setForeground(Color.white);
		
		dataNum1 = new JLabel();
		dataNum1.setFont(title.normalFont);
		dataNum1.setForeground(Color.white);
		
		dataNum2 = new JLabel();
		dataNum2.setFont(title.normalFont);
		dataNum2.setForeground(Color.white);
		
		dataNum3 = new JLabel();
		dataNum3.setFont(title.normalFont);
		dataNum3.setForeground(Color.white);
		
		dataNum4 = new JLabel();
		dataNum4.setFont(title.normalFont);
		dataNum4.setForeground(Color.white);
		
		dataNum5 = new JLabel();
		dataNum5.setFont(title.normalFont);
		dataNum5.setForeground(Color.white);
		
		dataNum6 = new JLabel();
		dataNum6.setFont(title.normalFont);
		dataNum6.setForeground(Color.white);
		
		mLabel = new JLabel("Morning");
		mLabel.setFont(title.normalFont);
		mLabel.setForeground(Color.white);
		
		aLabel = new JLabel("Afternoon");
		aLabel.setFont(title.normalFont);
		aLabel.setForeground(Color.white);
		
		nLabel = new JLabel("Night");
		nLabel.setFont(title.normalFont);
		nLabel.setForeground(Color.white);
		
		dayAdd = new JButton("Add day");
		dayAdd.setBackground(Color.black);
		dayAdd.setForeground(Color.white);
		dayAdd.setFont(title.normalFont);
		dayAdd.setFocusPainted(false);
		dayAdd.addActionListener(input); //when click, call the class
		
		dayReset = new JButton("Reset");
		dayReset.setBackground(Color.black);
		dayReset.setForeground(Color.white);
		dayReset.setFont(title.normalFont);
		dayReset.setFocusPainted(false);
		dayReset.addActionListener(dayResetHandler); //when click, call the class
		
		m_revisionButton = new JButton("Revision");
		m_revisionButton.setBackground(Color.black);
		m_revisionButton.setForeground(Color.white);
		m_revisionButton.setFont(title.normalFont);
		m_revisionButton.setFocusPainted(false);
		m_revisionButton.setActionCommand("m_revision");
		m_revisionButton.addActionListener(choiceHandler); //when click, call the class
		
		m_doPaperButton = new JButton("Do Past Paper");
		m_doPaperButton.setBackground(Color.black);
		m_doPaperButton.setForeground(Color.white);
		m_doPaperButton.setFont(title.smallFont);
		m_doPaperButton.setFocusPainted(false);
		m_doPaperButton.setActionCommand("m_doPaper");
		m_doPaperButton.addActionListener(choiceHandler); //when click, call the class
		
		m_tutorialButton = new JButton("Go tutorial");
		m_tutorialButton.setBackground(Color.black);
		m_tutorialButton.setForeground(Color.white);
		m_tutorialButton.setFont(title.normalFont);
		m_tutorialButton.setFocusPainted(false);
		m_tutorialButton.setActionCommand("m_tutorial");
		m_tutorialButton.addActionListener(choiceHandler); //when click, call the class
		
		m_breakButton = new JButton("Break");
		m_breakButton.setBackground(Color.black);
		m_breakButton.setForeground(Color.white);
		m_breakButton.setFont(title.normalFont);
		m_breakButton.setFocusPainted(false);
		m_breakButton.setActionCommand("m_break");
		m_breakButton.addActionListener(choiceHandler); //when click, call the class
		
		a_revisionButton = new JButton("Revision");
		a_revisionButton.setBackground(Color.black);
		a_revisionButton.setForeground(Color.white);
		a_revisionButton.setFont(title.normalFont);
		a_revisionButton.setFocusPainted(false);
		a_revisionButton.setActionCommand("a_revision");
		a_revisionButton.addActionListener(choiceHandler); //when click, call the class
		
		a_doPaperButton = new JButton("Do Past Paper");
		a_doPaperButton.setBackground(Color.black);
		a_doPaperButton.setForeground(Color.white);
		a_doPaperButton.setFont(title.smallFont);
		a_doPaperButton.setFocusPainted(false);
		a_doPaperButton.setActionCommand("a_doPaper");
		a_doPaperButton.addActionListener(choiceHandler); //when click, call the class
		
		a_tutorialButton = new JButton("Go tutorial");
		a_tutorialButton.setBackground(Color.black);
		a_tutorialButton.setForeground(Color.white);
		a_tutorialButton.setFont(title.normalFont);
		a_tutorialButton.setFocusPainted(false);
		a_tutorialButton.setActionCommand("a_tutorial");
		a_tutorialButton.addActionListener(choiceHandler); //when click, call the class
		
		a_breakButton = new JButton("Break");
		a_breakButton.setBackground(Color.black);
		a_breakButton.setForeground(Color.white);
		a_breakButton.setFont(title.normalFont);
		a_breakButton.setFocusPainted(false);
		a_breakButton.setActionCommand("a_break");
		a_breakButton.addActionListener(choiceHandler); //when click, call the class
		
		n_revisionButton = new JButton("Revision");
		n_revisionButton.setBackground(Color.black);
		n_revisionButton.setForeground(Color.white);
		n_revisionButton.setFont(title.normalFont);
		n_revisionButton.setFocusPainted(false);
		n_revisionButton.setActionCommand("n_revision");
		n_revisionButton.addActionListener(choiceHandler); //when click, call the class
		
		n_doPaperButton = new JButton("Do Past Paper");
		n_doPaperButton.setBackground(Color.black);
		n_doPaperButton.setForeground(Color.white);
		n_doPaperButton.setFont(title.smallFont);
		n_doPaperButton.setFocusPainted(false);
		n_doPaperButton.setActionCommand("n_doPaper");
		n_doPaperButton.addActionListener(choiceHandler); //when click, call the class
		
		n_tutorialButton = new JButton("Go tutorial");
		n_tutorialButton.setBackground(Color.black);
		n_tutorialButton.setForeground(Color.white);
		n_tutorialButton.setFont(title.normalFont);
		n_tutorialButton.setFocusPainted(false);
		n_tutorialButton.setActionCommand("n_tutorial");
		n_tutorialButton.addActionListener(choiceHandler); //when click, call the class
		
		n_breakButton = new JButton("Break");
		n_breakButton.setBackground(Color.black);
		n_breakButton.setForeground(Color.white);
		n_breakButton.setFont(title.normalFont);
		n_breakButton.setFocusPainted(false);
		n_breakButton.setActionCommand("n_break");
		n_breakButton.addActionListener(choiceHandler); //when click, call the class
		
		m_chin = new JButton("Chin");
		m_chin.setBackground(Color.black);
		m_chin.setForeground(Color.white);
		m_chin.setFont(title.normalFont);
		m_chin.setFocusPainted(false);
		m_chin.setActionCommand("m_chin");
		m_chin.addActionListener(choiceHandler); //when click, call the class
		
		m_eng = new JButton("Eng");
		m_eng.setBackground(Color.black);
		m_eng.setForeground(Color.white);
		m_eng.setFont(title.normalFont);
		m_eng.setFocusPainted(false);
		m_eng.setActionCommand("m_eng");
		m_eng.addActionListener(choiceHandler); //when click, call the class
		
		m_math = new JButton("Math");
		m_math.setBackground(Color.black);
		m_math.setForeground(Color.white);
		m_math.setFont(title.normalFont);
		m_math.setFocusPainted(false);
		m_math.setActionCommand("m_math");
		m_math.addActionListener(choiceHandler); //when click, call the class
		
		m_ls = new JButton("LS");
		m_ls.setBackground(Color.black);
		m_ls.setForeground(Color.white);
		m_ls.setFont(title.normalFont);
		m_ls.setFocusPainted(false);
		m_ls.setActionCommand("m_ls");
		m_ls.addActionListener(choiceHandler); //when click, call the class
		
		m_sub1 = new JButton("Sub1");
		m_sub1.setBackground(Color.black);
		m_sub1.setForeground(Color.white);
		m_sub1.setFont(title.normalFont);
		m_sub1.setFocusPainted(false);
		m_sub1.setActionCommand("m_sub1");
		m_sub1.addActionListener(choiceHandler); //when click, call the class
		
		m_sub2 = new JButton("Sub2");
		m_sub2.setBackground(Color.black);
		m_sub2.setForeground(Color.white);
		m_sub2.setFont(title.normalFont);
		m_sub2.setFocusPainted(false);
		m_sub2.setActionCommand("m_sub2");
		m_sub2.addActionListener(choiceHandler); //when click, call the class
		
		a_chin = new JButton("Chin");
		a_chin.setBackground(Color.black);
		a_chin.setForeground(Color.white);
		a_chin.setFont(title.normalFont);
		a_chin.setFocusPainted(false);
		a_chin.setActionCommand("a_chin");
		a_chin.addActionListener(choiceHandler); //when click, call the class
		
		a_eng = new JButton("Eng");
		a_eng.setBackground(Color.black);
		a_eng.setForeground(Color.white);
		a_eng.setFont(title.normalFont);
		a_eng.setFocusPainted(false);
		a_eng.setActionCommand("a_eng");
		a_eng.addActionListener(choiceHandler); //when click, call the class
		
		a_math = new JButton("Math");
		a_math.setBackground(Color.black);
		a_math.setForeground(Color.white);
		a_math.setFont(title.normalFont);
		a_math.setFocusPainted(false);
		a_math.setActionCommand("a_math");
		a_math.addActionListener(choiceHandler); //when click, call the class
		
		a_ls = new JButton("LS");
		a_ls.setBackground(Color.black);
		a_ls.setForeground(Color.white);
		a_ls.setFont(title.normalFont);
		a_ls.setFocusPainted(false);
		a_ls.setActionCommand("a_ls");
		a_ls.addActionListener(choiceHandler); //when click, call the class
		
		a_sub1 = new JButton("Sub1");
		a_sub1.setBackground(Color.black);
		a_sub1.setForeground(Color.white);
		a_sub1.setFont(title.normalFont);
		a_sub1.setFocusPainted(false);
		a_sub1.setActionCommand("a_sub1");
		a_sub1.addActionListener(choiceHandler); //when click, call the class
		
		a_sub2 = new JButton("Sub2");
		a_sub2.setBackground(Color.black);
		a_sub2.setForeground(Color.white);
		a_sub2.setFont(title.normalFont);
		a_sub2.setFocusPainted(false);
		a_sub2.setActionCommand("a_sub2");
		a_sub2.addActionListener(choiceHandler); //when click, call the class
		
		n_chin = new JButton("Chin");
		n_chin.setBackground(Color.black);
		n_chin.setForeground(Color.white);
		n_chin.setFont(title.normalFont);
		n_chin.setFocusPainted(false);
		n_chin.setActionCommand("n_chin");
		n_chin.addActionListener(choiceHandler); //when click, call the class
		
		n_eng = new JButton("Eng");
		n_eng.setBackground(Color.black);
		n_eng.setForeground(Color.white);
		n_eng.setFont(title.normalFont);
		n_eng.setFocusPainted(false);
		n_eng.setActionCommand("n_eng");
		n_eng.addActionListener(choiceHandler); //when click, call the class
		
		n_math = new JButton("Math");
		n_math.setBackground(Color.black);
		n_math.setForeground(Color.white);
		n_math.setFont(title.normalFont);
		n_math.setFocusPainted(false);
		n_math.setActionCommand("n_math");
		n_math.addActionListener(choiceHandler); //when click, call the class
		
		n_ls = new JButton("LS");
		n_ls.setBackground(Color.black);
		n_ls.setForeground(Color.white);
		n_ls.setFont(title.normalFont);
		n_ls.setFocusPainted(false);
		n_ls.setActionCommand("n_ls");
		n_ls.addActionListener(choiceHandler); //when click, call the class
		
		n_sub1 = new JButton("Sub1");
		n_sub1.setBackground(Color.black);
		n_sub1.setForeground(Color.white);
		n_sub1.setFont(title.normalFont);
		n_sub1.setFocusPainted(false);
		n_sub1.setActionCommand("n_sub1");
		n_sub1.addActionListener(choiceHandler); //when click, call the class
		
		n_sub2 = new JButton("Sub2");
		n_sub2.setBackground(Color.black);
		n_sub2.setForeground(Color.white);
		n_sub2.setFont(title.normalFont);
		n_sub2.setFocusPainted(false);
		n_sub2.setActionCommand("n_sub2");
		n_sub2.addActionListener(choiceHandler); //when click, call the class
		
		menuButton = new JButton("Menu");
		menuButton.setBackground(Color.white);
		menuButton.setForeground(Color.black);
		menuButton.setFont(title.VerysmallFont);
		menuButton.setFocusPainted(false);
		menuButton.setActionCommand("openMenu");
		menuButton.addActionListener(menuHandler);
		
		energyBar = new JProgressBar();
		energyBar.setPreferredSize(new Dimension(200,50));
		energyBar.setValue(100);
		
		dayPanel.add(dayLabel);
		dayPanel.add(dayNumber);
		
		moneyPanel.add(moneyLabel);
		moneyPanel.add(moneyValueLabel);
		moneyPanel.add(moneyStatusLabel);
		
		energyStatusPanel.add(energyStatusLabel);
		
		energyLevelPanel.add(energyLevelLabel);
		energyLevelPanel.add(energyBar);
		
		adddayPanel.add(dayAdd);
		
		dayResetPanel.add(dayReset);

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
		
		m_choicePanel.add(m_revisionButton);
		m_choicePanel.add(m_doPaperButton);
		m_choicePanel.add(m_tutorialButton);
		m_choicePanel.add(m_breakButton);
		
		a_choicePanel.add(a_revisionButton);
		a_choicePanel.add(a_doPaperButton);
		a_choicePanel.add(a_tutorialButton);
		a_choicePanel.add(a_breakButton);
		
		n_choicePanel.add(n_revisionButton);
		n_choicePanel.add(n_doPaperButton);
		n_choicePanel.add(n_tutorialButton);
		n_choicePanel.add(n_breakButton);
		
		mSubjectPanel.add(m_chin);
		mSubjectPanel.add(m_eng);
		mSubjectPanel.add(m_math);
		mSubjectPanel.add(m_ls);
		mSubjectPanel.add(m_sub1);
		mSubjectPanel.add(m_sub2);
		
		aSubjectPanel.add(a_chin);
		aSubjectPanel.add(a_eng);
		aSubjectPanel.add(a_math);
		aSubjectPanel.add(a_ls);
		aSubjectPanel.add(a_sub1);
		aSubjectPanel.add(a_sub2);
		
		nSubjectPanel.add(n_chin);
		nSubjectPanel.add(n_eng);
		nSubjectPanel.add(n_math);
		nSubjectPanel.add(n_ls);
		nSubjectPanel.add(n_sub1);
		nSubjectPanel.add(n_sub2);
		
		menuButtonPanel.add(menuButton);
		
		//Main Pane<---------------------------------------------------------
		
		//Day Schedule Pane------------------------------------------------->
		
		daySchedulePanel = new JPanel();
		daySchedulePanel.setBounds(100,100,590,400);
		daySchedulePanel.setBackground(Color.red);
		daySchedulePanel.setForeground(Color.white);
		daySchedulePanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		daySchedulePanel.setLayout(new BorderLayout());
		
		dayScheduleTitle = new JLabel("Day Schedule", SwingConstants.CENTER );
		dayScheduleTitle.setFont(title.normalFont);
		dayScheduleTitle.setForeground(Color.white);
		
		daySchedule = new JTextArea("");
		daySchedule.setBackground(Color.black);
		daySchedule.setForeground(Color.white);
		daySchedule.setFont(title.normalFont);
		daySchedule.setLineWrap(true);
		daySchedule.setEditable(false);
		daySchedule.addMouseListener(mouse);
		
		dayScheduleExitButton = new JButton("Exit");
		dayScheduleExitButton.setBackground(Color.black);
		dayScheduleExitButton.setForeground(Color.white);
		dayScheduleExitButton.setFont(title.normalFont);
		dayScheduleExitButton.setFocusPainted(false);
		dayScheduleExitButton.setActionCommand("exit");
		dayScheduleExitButton.addActionListener(dayScheduleHandler); 
		
		daySchedulePanel.add(dayScheduleTitle, BorderLayout.NORTH);
		daySchedulePanel.add(daySchedule, BorderLayout.CENTER);
		daySchedulePanel.add(dayScheduleExitButton, BorderLayout.PAGE_END);
		
		//Day Schedule Pane<------------------------------------------------
		
		title.con.add(daySchedulePanel,new Integer(1));
		
		//Menu Pane--------------------------------------------------------->
		
		menuPanel = new JPanel();
		menuPanel.setBounds(100,100,590,400);
		menuPanel.setLayout(new GridLayout(3,1));
		menuPanel.setBackground(Color.blue);
		
		menuSaveButton = new JButton("Save");
		menuSaveButton.setBackground(Color.black);
		menuSaveButton.setForeground(Color.white);
		menuSaveButton.setFont(title.normalFont);
		menuSaveButton.setFocusPainted(false);
		menuSaveButton.setActionCommand("save");
		menuSaveButton.addActionListener(menuHandler);
		
		menuBackToTitleButton = new JButton("Back to title");
		menuBackToTitleButton.setBackground(Color.black);
		menuBackToTitleButton.setForeground(Color.white);
		menuBackToTitleButton.setFont(title.normalFont);
		menuBackToTitleButton.setFocusPainted(false);
		menuBackToTitleButton.setActionCommand("backToTitle");
		menuBackToTitleButton.addActionListener(menuHandler);
		
		menuBackButton = new JButton("Back");
		menuBackButton.setBackground(Color.black);
		menuBackButton.setForeground(Color.white);
		menuBackButton.setFont(title.normalFont);
		menuBackButton.setFocusPainted(false);
		menuBackButton.setActionCommand("back");
		menuBackButton.addActionListener(menuHandler);
		
		menuPanel.add(menuSaveButton);
		menuPanel.add(menuBackToTitleButton);
		menuPanel.add(menuBackButton);
		
		//Menu Pane<---------------------------------------------------------
		title.con.add(menuPanel);
		
		title.con.add(dayPanel);
		title.con.add(moneyPanel);
		title.con.add(mPanel);
		title.con.add(m_choicePanel);
		title.con.add(a_choicePanel);
		title.con.add(n_choicePanel);
		title.con.add(mSubjectPanel);
		title.con.add(aSubjectPanel);
		title.con.add(nSubjectPanel);
		title.con.add(aPanel);
		title.con.add(nPanel);
		title.con.add(mainTextPanel);
		title.con.add(dataPanel);
		title.con.add(adddayPanel);
		title.con.add(dayResetPanel);
		title.con.add(energyLevelPanel);
		title.con.add(energyStatusPanel);
		title.con.add(menuButtonPanel);
		
		mSubjectPanel.setVisible(false);
		aSubjectPanel.setVisible(false);
		nSubjectPanel.setVisible(false);
		
		m_tutorialButton.setEnabled(false);
		a_tutorialButton.setEnabled(false);
		n_tutorialButton.setEnabled(false);
		
		daySchedulePanel.setVisible(false);
		menuPanel.setVisible(false);
		

		clearFrame();
		frameSetup();

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
	
	public void valueSetup(int dayValue, int chinValue, int engValue, int mathValue, int lsValue, int sub1Value, int sub2Value, int moneyValue){
		day = dayValue;
		chin = chinValue;
		eng = engValue;
		math = mathValue;
		ls = lsValue;
		sub1 = sub1Value;
		sub2 = sub2Value;
		money = moneyValue;
		
		dayNumber.setText(""+day);
		dataNum1.setText(""+chin);
		dataNum2.setText(""+eng);
		dataNum3.setText(""+math);
		dataNum4.setText(""+ls);
		dataNum5.setText(""+sub1);
		dataNum6.setText(""+sub2);
		moneyValueLabel.setText(""+moneyValue);
	}
	
	public void morningChoice(int choice){
		
		switch(choice){
		
		case 1:
		case 2:
		case 3:
			
			subChoose(choice,0);
			break;
			
		case 4:
			m_revisionButton.setEnabled(false);
			m_doPaperButton.setEnabled(false);
			m_tutorialButton.setEnabled(false);
			
		}
	}
	
	public void afternoonChoice(int choice){
		switch(choice){
		
		case 1:
		case 2:
		case 3:
			
			subChoose(choice,1);
			break;
			
		case 4:
			a_revisionButton.setEnabled(false);
			a_doPaperButton.setEnabled(false);
			a_tutorialButton.setEnabled(false);
			
		}
	}
	
	public void nightChoice(int choice){
		
		switch(choice){
		
		case 1:
		case 2:
		case 3:
			
			subChoose(choice,2);
			break;
			
		case 4:
			n_revisionButton.setEnabled(false);
			n_doPaperButton.setEnabled(false);
			n_tutorialButton.setEnabled(false);
			
		}
		
	}
	
	public void subChoose(int choice, int timeSlot){
		
		choices[timeSlot] = choice ;
		
		switch(timeSlot){
		case 0:
			m_choicePanel.setVisible(false);
			mSubjectPanel.setVisible(true);
			break;
			
		case 1:
			a_choicePanel.setVisible(false);
			aSubjectPanel.setVisible(true);
			break;
			
		case 2:
			n_choicePanel.setVisible(false);
			nSubjectPanel.setVisible(true);
			break;
			
		}
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
		
		frameSetup();
		
		for(int i=0; i<studySubject.length;i++){
			studySubject[i] = 0;
			
			choices[i] = 0;
		}
		
		m_choicePanel.setVisible(true);
		a_choicePanel.setVisible(true);
		n_choicePanel.setVisible(true);
		
		if(energyBar.getValue() <= 0){
			
			m_breakButton.setEnabled(true);
			a_breakButton.setEnabled(true);
			n_breakButton.setEnabled(true);
			
		}
		
		if(moneyUseup && day != 1) {
			
			moneyStatusLabel.setText("Money Use up");
			
		}
		
		if(moneyUseup || day == 1){
			
				
				
				m_tutorialButton.setEnabled(false);
				a_tutorialButton.setEnabled(false);
				n_tutorialButton.setEnabled(false);
				
		}else{	
				
				moneyStatusLabel.setText("");
				
				m_tutorialButton.setEnabled(true);
				a_tutorialButton.setEnabled(true);
				n_tutorialButton.setEnabled(true);
		}
			
			m_revisionButton.setEnabled(true);
			m_doPaperButton.setEnabled(true);
			m_breakButton.setEnabled(true);
			
			a_revisionButton.setEnabled(true);
			a_doPaperButton.setEnabled(true);
			a_breakButton.setEnabled(true);
			
			n_revisionButton.setEnabled(true);
			n_doPaperButton.setEnabled(true);
			n_breakButton.setEnabled(true);
			
			mSubjectPanel.setVisible(false);
			aSubjectPanel.setVisible(false);
			nSubjectPanel.setVisible(false);
			
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
	
	public void energyUseup(boolean tired, boolean exhaust, boolean sameSubTired){
		
		if(exhaust) {
			
			energyStatusLabel.setText("Exhaust");
			
			if(tired) {
				
				m_revisionButton.setEnabled(false);
				m_doPaperButton.setEnabled(false);
				m_tutorialButton.setEnabled(false);
				a_revisionButton.setEnabled(false);
				a_doPaperButton.setEnabled(false);
				a_tutorialButton.setEnabled(false);
				n_revisionButton.setEnabled(false);
				n_doPaperButton.setEnabled(false);
				n_tutorialButton.setEnabled(false);
				
			}
			
		}else if(sameSubTired) {
			
			energyStatusLabel.setText("Tired");
			
			if(tired) {
				
				m_revisionButton.setEnabled(false);
				m_doPaperButton.setEnabled(false);
				m_tutorialButton.setEnabled(false);
				a_revisionButton.setEnabled(false);
				a_doPaperButton.setEnabled(false);
				a_tutorialButton.setEnabled(false);
				n_revisionButton.setEnabled(false);
				n_doPaperButton.setEnabled(false);
				n_tutorialButton.setEnabled(false);
				
			}
			
		}else if(tired) {
			
			energyStatusLabel.setText("Tired");
			
			m_revisionButton.setEnabled(false);
			m_doPaperButton.setEnabled(false);
			m_tutorialButton.setEnabled(false);
			a_revisionButton.setEnabled(false);
			a_doPaperButton.setEnabled(false);
			a_tutorialButton.setEnabled(false);
			n_revisionButton.setEnabled(false);
			n_doPaperButton.setEnabled(false);
			n_tutorialButton.setEnabled(false);
			
		}else {
			
			energyStatusLabel.setText("");
		}
	
	}
	

	public void endGame(int[] knowledge,int[] examSkill){
		
		clearFrame();
		
		endGame.resultSetup(knowledge,examSkill);
		
	}
	
	public void clearFrame(){
		
		dayPanel.setVisible(false);
		mainTextPanel.setVisible(false);
		dataPanel.setVisible(false);
		adddayPanel.setVisible(false);
		m_choicePanel.setVisible(false);
		a_choicePanel.setVisible(false);
		n_choicePanel.setVisible(false);
		mSubjectPanel.setVisible(false);
		aSubjectPanel.setVisible(false);
		nSubjectPanel.setVisible(false);
		mPanel.setVisible(false);
		aPanel.setVisible(false);
		nPanel.setVisible(false);
		energyStatusPanel.setVisible(false);
		energyLevelPanel.setVisible(false);
		dayResetPanel.setVisible(false);
		moneyPanel.setVisible(false);
		menuButtonPanel.setVisible(false);
		daySchedulePanel.setVisible(false);
		menuPanel.setVisible(false);
		
	}
	
	public void start(int i) { //i stand for new or continue
		
		if(i == 1){
			saveLoad.loadData();
		}else{
			 initial.valueReset();	
		}
		
		day = initial.day;
		chin = initial.Chin;
		eng = initial.Eng;
		math = initial.Math;
		ls = initial.ls;
		sub1 = initial.sub_1;
		sub2 = initial.sub_2;
		money = initial.moneyValue;
	}
	
	
	private void frameSetup()
	{
		dayPanel.setVisible(true);
		mainTextPanel.setVisible(true);
		dataPanel.setVisible(true);
		adddayPanel.setVisible(true);
		m_choicePanel.setVisible(true);
		a_choicePanel.setVisible(true);
		n_choicePanel.setVisible(true);
		mSubjectPanel.setVisible(true);
		aSubjectPanel.setVisible(true);
		nSubjectPanel.setVisible(true);
		mPanel.setVisible(true);
		aPanel.setVisible(true);
		nPanel.setVisible(true);
		energyStatusPanel.setVisible(true);
		energyLevelPanel.setVisible(true);
		dayResetPanel.setVisible(true);
		moneyPanel.setVisible(true);
		menuButtonPanel.setVisible(true);
		
		dayNumber.setText(""+day);
		dataNum1.setText(""+chin);
		dataNum2.setText(""+eng);
		dataNum3.setText(""+math);
		dataNum4.setText(""+ls);
		dataNum5.setText(""+sub1);
		dataNum6.setText(""+sub2);
		moneyValueLabel.setText(""+money);

	}
	
	
	public void dayScheduleSetup(String[] schedule) {
		
		daySchedule.setText("");
		
		dayScheduleExitButton.setEnabled(false);
		
		daySchedulePanel.setVisible(true);
		
		showAllSchedule = false;
		
		showSchedule = 0;
		
		
		tmr = new Timer(1000, (ActionListener) new ActionListener() {
		    @Override
		    
		    public void actionPerformed(ActionEvent e) {
		    	if(showSchedule<schedule.length && showAllSchedule != true) {
		    		
		    		daySchedule.append(schedule[showSchedule]+"\n");
		    		
		    	}else if(showAllSchedule == true) {
		    		
		    		for(int i = showSchedule; i<schedule.length; i++) {
		    		
		    			daySchedule.append(schedule[i]+"\n");
		    		
		    		}
		    		
		    		tmr.stop();
		    		
		    		dayScheduleExitButton.setEnabled(true);
		    		
		    	}else {
		    		
		    		tmr.stop();
		    		dayScheduleExitButton.setEnabled(true);

		    	}
		    	
		    	showSchedule++;
		    	
		    }
		
		});
		
		tmr.start();
			
	}
	
	public void menuSave(int i){
		if(i==0){
			menuSaveButton.setText("Saved");
			menuSaveButton.setEnabled(false);
		}else{
			menuSaveButton.setText("Save");
			menuSaveButton.setEnabled(true);
		}
	}
	
	public void clearDaySchedule() {
		
		daySchedulePanel.setVisible(false);
		
	}
	
	public void setMenu() {
		
		menuPanel.setVisible(true);
	}
	
	public void clearMenu() {
		
		menuPanel.setVisible(false);
		
	}

	public int[] getStudySubject() {
		return studySubject;
	}
	
	public int[] getChoices() {
		return choices;
	}

	public void setStudySubject(int[] studySubject) {
		this.studySubject = studySubject;
	}
	
	public void moneyUseup(boolean useup){
		
		moneyUseup = useup;
		
	}
	
	public void addday(int i){
		if(i==0){
			dayAdd.setEnabled(false);
			//dayScheduleExitButton.setEnabled(false);
		}else{
			dayAdd.setEnabled(true);
			input.eventCheck();
		}
	}
	
	MouseListener mouse =  new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			showAllSchedule = true;
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	    };
}