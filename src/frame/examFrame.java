package frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Basic.language;
import Basic.o_jPanel;

public class examFrame {
		
	frame.title title;
	frame.endGame endGame;
	
	main.exam exam = new main.exam();
		
	JPanel gameTextPanel;
	JTextArea examText;
	
	int event = 0;
	
	int[] knowledge = {0,0,0,0,0,0,0};
	int[] examSkill = {0,0,0,0,0,0,0};
	int[] difficulty = {0,0,0,0,0,0,0};
	
	String[] text;
		
	public examFrame(frame.title tit){
			
		title = tit;
		endGame = new endGame(title);
			
		gameTextPanel = new o_jPanel(2);
		gameTextPanel.setBounds(100,50,590,400);
		gameTextPanel.addMouseListener(mouse);
	
		examText = new JTextArea(language.getV("examText")+" \n");
		examText.setBounds(100,50,590,400);
		examText.setForeground(Color.white);
		examText.setFont(title.normalFont);
		examText.setOpaque(false);
		examText.setLineWrap(true);
		examText.setEditable(false);
		examText.addMouseListener(mouse);
			
		gameTextPanel.add(examText);

		gameTextPanel.setVisible(false);
		
	}
		
	public void examSetup(int[] knowledge,int[] examSkill){
		
		difficulty = exam.generateDiff(knowledge, examSkill);
		
		this.knowledge = exam.getKnowledge();
		this.examSkill = exam.getExamSkill();
		
		text = exam.getExamText();
			
		title.con.add(gameTextPanel);
			
		gameTextPanel.setVisible(true);
	}
	
	private void clearFrame(){
		gameTextPanel.setVisible(false);	
	}
	
	private void showExam(int event){
		
		if(event < text.length){
			examText.append(text[event]+"\n");
			
		}else{
			endExam();
		}

	}
	
	private void endExam()
	{
		clearFrame();
		endGame.resultSetup(knowledge,examSkill);
	}
		
	MouseListener mouse =  new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			showExam(event);
			event++;
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		}
	};
}
