package frame;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Basic.initial;

public class endGame{

	frame.title title;
	JPanel gameTextPanel,resultPanel,restartPanel,universityPanel;
	JLabel chinName,engName,mathName,lsName,sub1Name,sub2Name,chinResult,engResult,mathResult,lsResult,sub1Result,
	sub2Result,universityLabel,universityResult;
	JButton restartButton;
	
	main.result result = new main.result();
	Control.restartHandler restartHandler;
	
	public endGame(frame.title tit){
		
		title = tit;
		
		restartHandler = new Control.restartHandler(title,this);
		
		gameTextPanel = new JPanel();
		gameTextPanel.setBounds(100,30,590,400);
		gameTextPanel.setBackground(Color.red);
		
		resultPanel = new JPanel();
		resultPanel.setBounds(100,30,590,400);
		resultPanel.setLayout(new GridLayout(2,6));
		resultPanel.setBackground(Color.blue);
		resultPanel.setBorder(BorderFactory.createLineBorder(Color.green));
		
		universityPanel = new JPanel();
		universityPanel.setBounds(100,450,590,50);
		universityPanel.setBackground(Color.blue);
		
		restartPanel = new JPanel();
		restartPanel.setBounds(350,500,120,50);
		restartPanel.setBackground(Color.blue);
		
		chinName = new JLabel("Chin",SwingConstants.CENTER);
		chinName.setFont(title.normalFont);
		chinName.setForeground(Color.white);
		chinName.setBorder(BorderFactory.createLineBorder(Color.green));
		
		engName = new JLabel("Eng",SwingConstants.CENTER);
		engName.setFont(title.normalFont);
		engName.setForeground(Color.white);
		engName.setBorder(BorderFactory.createLineBorder(Color.green));
		
		mathName = new JLabel("Math",SwingConstants.CENTER);
		mathName.setFont(title.normalFont);
		mathName.setForeground(Color.white);
		mathName.setBorder(BorderFactory.createLineBorder(Color.green));
		
		lsName = new JLabel("LS",SwingConstants.CENTER);
		lsName.setFont(title.normalFont);
		lsName.setForeground(Color.white);
		lsName.setBorder(BorderFactory.createLineBorder(Color.green));
		
		sub1Name = new JLabel(initial.subject[5],SwingConstants.CENTER);
		sub1Name.setFont(title.normalFont);
		sub1Name.setForeground(Color.white);
		sub1Name.setBorder(BorderFactory.createLineBorder(Color.green));
		
		sub2Name = new JLabel(initial.subject[6],SwingConstants.CENTER);
		sub2Name.setFont(title.normalFont);
		sub2Name.setForeground(Color.white);
		sub2Name.setBorder(BorderFactory.createLineBorder(Color.green));
		
		chinResult = new JLabel("",SwingConstants.CENTER);
		chinResult.setFont(title.normalFont);
		chinResult.setForeground(Color.white);
		chinResult.setBorder(BorderFactory.createLineBorder(Color.green));
		
		engResult = new JLabel("",SwingConstants.CENTER);
		engResult.setFont(title.normalFont);
		engResult.setForeground(Color.white);
		engResult.setBorder(BorderFactory.createLineBorder(Color.green));
		
		mathResult = new JLabel("",SwingConstants.CENTER);
		mathResult.setFont(title.normalFont);
		mathResult.setForeground(Color.white);
		mathResult.setBorder(BorderFactory.createLineBorder(Color.green));
		
		lsResult = new JLabel("",SwingConstants.CENTER);
		lsResult.setFont(title.normalFont);
		lsResult.setForeground(Color.white);
		lsResult.setBorder(BorderFactory.createLineBorder(Color.green));
		
		sub1Result = new JLabel("",SwingConstants.CENTER);
		sub1Result.setFont(title.normalFont);
		sub1Result.setForeground(Color.white);
		sub1Result.setBorder(BorderFactory.createLineBorder(Color.green));
		
		sub2Result = new JLabel("",SwingConstants.CENTER);
		sub2Result.setFont(title.normalFont);
		sub2Result.setForeground(Color.white);
		sub2Result.setBorder(BorderFactory.createLineBorder(Color.green));
		
		universityLabel = new JLabel("Chance to university :");
		universityLabel.setFont(title.normalFont);
		universityLabel.setForeground(Color.white);
		
		universityResult = new JLabel("");
		universityResult.setFont(title.normalFont);
		universityResult.setForeground(Color.white);
		
		restartButton = new JButton("restart");
		restartButton.setBackground(Color.black);
		restartButton.setForeground(Color.white);
		restartButton.setFont(title.normalFont);
		restartButton.setFocusPainted(false);
		restartButton.addActionListener(restartHandler); //when click, call the class
		
		resultPanel.add(chinName);
		resultPanel.add(engName);
		resultPanel.add(mathName);
		resultPanel.add(lsName);
		resultPanel.add(sub1Name);
		resultPanel.add(sub2Name);
		resultPanel.add(chinResult);
		resultPanel.add(engResult);
		resultPanel.add(mathResult);
		resultPanel.add(lsResult);
		resultPanel.add(sub1Result);
		resultPanel.add(sub2Result);
		
		universityPanel.add(universityLabel);
		universityPanel.add(universityResult);
		
		restartPanel.add(restartButton);

		resultPanel.setVisible(false);
		gameTextPanel.setVisible(false);
		restartPanel.setVisible(false);
		universityPanel.setVisible(false);
	
	}
	
	public void resultSetup(int[] knowledge,int[] examSkill){
		
		title.con.add(resultPanel);
		title.con.add(gameTextPanel);
		title.con.add(restartPanel);
		title.con.add(universityPanel);
		
		resultPanel.setVisible(true);
		gameTextPanel.setVisible(true);
		restartPanel.setVisible(true);
		universityPanel.setVisible(true);
		
		displayGrade(result.gradeCalculate(knowledge,examSkill),result.universityChance());
	}
	
	public void displayGrade(String[] grade, boolean universityChance){
		
		chinResult.setText(grade[0]);
		engResult.setText(grade[1]);
		mathResult.setText(grade[2]);
		lsResult.setText(grade[3]);
		sub1Result.setText(grade[4]);
		sub2Result.setText(grade[5]);
		
		if(universityChance){
			universityResult.setText("Yes");
			
		}else{
			universityResult.setText("No");
			
		}
		
	}
	
	
}
