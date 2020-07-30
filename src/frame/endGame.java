package frame;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Basic.initial;
import Basic.language;
import Basic.o_jPanel;
import Basic.o_jbutton;

public class endGame {

	frame.title title;
	JPanel gameTextPanel, resultPanel, nextPanel, universityPanel;
	JLabel chinName, engName, mathName, lsName, sub1Name, sub2Name, chinResult, engResult, mathResult, lsResult,
			sub1Result, sub2Result, universityLabel, universityResult;
	JButton nextButton;

	main.result result = new main.result();
	Control.endGameHandler endGameHandler;

	public endGame(frame.title tit) {

		title = tit;

		gameTextPanel = new o_jPanel(1);
		gameTextPanel.setBounds(100, 30, 590, 400);

		resultPanel = new o_jPanel(2);
		resultPanel.setBounds(100, 30, 590, 400);
		resultPanel.setLayout(new GridLayout(2, 6));
		resultPanel.setBackground(Color.blue);
		resultPanel.setBorder(BorderFactory.createLineBorder(Color.green));

		universityPanel = new o_jPanel(2);
		universityPanel.setBounds(100, 450, 590, 50);

		nextPanel = new JPanel();
		nextPanel.setBounds(350, 500, 120, 50);
		nextPanel.setOpaque(false);

		chinName = new JLabel(initial.subject[1], SwingConstants.CENTER);
		chinName.setFont(title.normalFont);
		chinName.setForeground(Color.white);
		chinName.setBorder(BorderFactory.createLineBorder(Color.green));

		engName = new JLabel(initial.subject[2], SwingConstants.CENTER);
		engName.setFont(title.normalFont);
		engName.setForeground(Color.white);
		engName.setBorder(BorderFactory.createLineBorder(Color.green));

		mathName = new JLabel(initial.subject[3], SwingConstants.CENTER);
		mathName.setFont(title.normalFont);
		mathName.setForeground(Color.white);
		mathName.setBorder(BorderFactory.createLineBorder(Color.green));

		lsName = new JLabel(initial.subject[4], SwingConstants.CENTER);
		lsName.setFont(title.normalFont);
		lsName.setForeground(Color.white);
		lsName.setBorder(BorderFactory.createLineBorder(Color.green));

		sub1Name = new JLabel(initial.subject[5], SwingConstants.CENTER);
		sub1Name.setFont(title.normalFont);
		sub1Name.setForeground(Color.white);
		sub1Name.setBorder(BorderFactory.createLineBorder(Color.green));

		sub2Name = new JLabel(initial.subject[6], SwingConstants.CENTER);
		sub2Name.setFont(title.normalFont);
		sub2Name.setForeground(Color.white);
		sub2Name.setBorder(BorderFactory.createLineBorder(Color.green));

		chinResult = new JLabel("", SwingConstants.CENTER);
		chinResult.setFont(title.normalFont);
		chinResult.setForeground(Color.white);
		chinResult.setBorder(BorderFactory.createLineBorder(Color.green));

		engResult = new JLabel("", SwingConstants.CENTER);
		engResult.setFont(title.normalFont);
		engResult.setForeground(Color.white);
		engResult.setBorder(BorderFactory.createLineBorder(Color.green));

		mathResult = new JLabel("", SwingConstants.CENTER);
		mathResult.setFont(title.normalFont);
		mathResult.setForeground(Color.white);
		mathResult.setBorder(BorderFactory.createLineBorder(Color.green));

		lsResult = new JLabel("", SwingConstants.CENTER);
		lsResult.setFont(title.normalFont);
		lsResult.setForeground(Color.white);
		lsResult.setBorder(BorderFactory.createLineBorder(Color.green));

		sub1Result = new JLabel("", SwingConstants.CENTER);
		sub1Result.setFont(title.normalFont);
		sub1Result.setForeground(Color.white);
		sub1Result.setBorder(BorderFactory.createLineBorder(Color.green));

		sub2Result = new JLabel("", SwingConstants.CENTER);
		sub2Result.setFont(title.normalFont);
		sub2Result.setForeground(Color.white);
		sub2Result.setBorder(BorderFactory.createLineBorder(Color.green));

		universityLabel = new JLabel(language.getV("universityLabel"));
		universityLabel.setFont(title.normalFont);
		universityLabel.setForeground(Color.white);

		universityResult = new JLabel("");
		universityResult.setFont(title.normalFont);
		universityResult.setForeground(Color.white);

		nextButton = new o_jbutton(language.getV("next"));
		nextButton.setForeground(Color.BLACK);
		nextButton.setFont(title.normalFont);
		nextButton.setFocusPainted(false);								

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

		nextPanel.add(nextButton);

		resultPanel.setVisible(false);
		gameTextPanel.setVisible(false);
		nextPanel.setVisible(false);
		universityPanel.setVisible(false);

	}

	public void resultSetup(int[] knowledge, int[] examSkill) {

		title.con.add(resultPanel);
		title.con.add(gameTextPanel);
		title.con.add(nextPanel);
		title.con.add(universityPanel);

		chinName.setText(initial.subject[1]);
		engName.setText(initial.subject[2]);
		mathName.setText(initial.subject[3]);
		lsName.setText(initial.subject[4]);
		sub1Name.setText(initial.subject[5]);
		sub2Name.setText(initial.subject[6]);

		resultPanel.setVisible(true);
		gameTextPanel.setVisible(true);
		nextPanel.setVisible(true);
		universityPanel.setVisible(true);

		displayGrade(result.gradeCalculate(knowledge, examSkill), result.universityChance());
		
		endGameHandler = new Control.endGameHandler(title, this,result.universityChance());		
		nextButton.addActionListener(endGameHandler); 
	}

	public void displayGrade(String[] grade, boolean universityChance) {

		chinResult.setText(grade[0]);
		engResult.setText(grade[1]);
		mathResult.setText(grade[2]);
		lsResult.setText(grade[3]);
		sub1Result.setText(grade[4]);
		sub2Result.setText(grade[5]);

		if (universityChance) {
			universityResult.setText(language.getV("yes"));

		} else {
			universityResult.setText(language.getV("no"));

		}

	}

	public void clearFrame() {
		resultPanel.setVisible(false);
		gameTextPanel.setVisible(false);
		nextPanel.setVisible(false);
		universityPanel.setVisible(false);
	}
}
