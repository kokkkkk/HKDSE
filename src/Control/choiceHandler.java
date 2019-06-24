package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choiceHandler implements ActionListener{
	frame.Main Main;
	
	public choiceHandler(frame.Main m){
		Main = m;
	}
	
	public void actionPerformed(ActionEvent event){
		String Choice = event.getActionCommand();
		
		switch(Choice){
		 case "m_chin": 
			 Main.morningAction(1);
			 break;
		 case "m_eng":
			 Main.morningAction(2);
			 break;
		 case "m_math":
			 Main.morningAction(3);
			 break;
		 case "m_ls":
			 Main.morningAction(4);
			 break;
		 case "m_sub1":
			 Main.morningAction(5);
			 break;
		 case "m_sub2":
			 Main.morningAction(6);
			 break;
		 case "a_chin":
			 Main.afternoonAction(1);
			 break;
		 case "a_eng":
			 Main.afternoonAction(2);
			 break;
		 case "a_math":
			 Main.afternoonAction(3);
			 break;
		 case "a_ls":
			 Main.afternoonAction(4);
			 break;
		 case "a_sub1":
			 Main.afternoonAction(5);
			 break;
		 case "a_sub2":
			 Main.afternoonAction(6);
			 break;
		 case "n_chin":
			 Main.nightAction(1);
			 break;
		 case "n_eng":
			 Main.nightAction(2);
			 break;
		 case "n_math":
			 Main.nightAction(3);
			 break;
		 case "n_ls":
			 Main.nightAction(4);
			 break;
		 case "n_sub1":
			 Main.nightAction(5);
			 break;
		 case "n_sub2":
			 Main.nightAction(6);
			 break;
		}
	}
}
