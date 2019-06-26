package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dayResetHandler implements ActionListener {
	
	frame.Main main;

	public dayResetHandler(frame.Main m){
		
		main = m;
		
	}
	
	public void actionPerformed(ActionEvent event){
		
		main.dayReset();
		
	}
}
