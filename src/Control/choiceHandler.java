package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choiceHandler implements ActionListener{
	frame.Game game;
	
	public choiceHandler(frame.Game g){
		game = g;
	}
	
	public void actionPerformed(ActionEvent event){
		String Choice = event.getActionCommand();
		
		switch(Choice){
		 case "m_revision":
			 game.morningChoice(1);
			 break;
		 case "m_doPaper":
			 game.morningChoice(2);
			 break;
		 case "m_tutorial":
			 game.morningChoice(3);
			 break;
		 case "m_break":
			 game.morningChoice(4);
			 break;
		 case "a_revision":
			 game.afternoonChoice(1);
			 break;
		 case "a_doPaper":
			 game.afternoonChoice(2);
			 break;
		 case "a_tutorial":
			 game.afternoonChoice(3);
			 break;
		 case "a_break":
			 game.afternoonChoice(4);
			 break;
		 case "n_revision":
			 game.nightChoice(1);
			 break;
		 case "n_doPaper":
			 game.nightChoice(2);
			 break;
		 case "n_tutorial":
			 game.nightChoice(3);
			 break;
		 case "n_break":
			 game.nightChoice(4);
			 break;
		 case "m_chin": 
			 game.morningAction(1);
			 break;
		 case "m_eng":
			 game.morningAction(2);
			 break;
		 case "m_math":
			 game.morningAction(3);
			 break;
		 case "m_ls":
			 game.morningAction(4);
			 break;
		 case "m_sub1":
			 game.morningAction(5);
			 break;
		 case "m_sub2":
			 game.morningAction(6);
			 break;
		 case "a_chin":
			 game.afternoonAction(1);
			 break;
		 case "a_eng":
			 game.afternoonAction(2);
			 break;
		 case "a_math":
			 game.afternoonAction(3);
			 break;
		 case "a_ls":
			 game.afternoonAction(4);
			 break;
		 case "a_sub1":
			 game.afternoonAction(5);
			 break;
		 case "a_sub2":
			 game.afternoonAction(6);
			 break;
		 case "n_chin":
			 game.nightAction(1);
			 break;
		 case "n_eng":
			 game.nightAction(2);
			 break;
		 case "n_math":
			 game.nightAction(3);
			 break;
		 case "n_ls":
			 game.nightAction(4);
			 break;
		 case "n_sub1":
			 game.nightAction(5);
			 break;
		 case "n_sub2":
			 game.nightAction(6);
			 break;
		}
	}
}
