package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingWorker;

import Basic.initial;
import frame.game;
import frame.languageFrame;
import frame.splashScreen;
import main.opening;

public class titleHandler implements ActionListener {
	
	frame.title title;
	splashScreen splash;

	public titleHandler(frame.title tit){
		
		title = tit;
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		
		String action = event.getActionCommand();
		
		switch(action) {
		case "new":
			title.clearFrame();
			
			 initial.valueReset();	
        
			new opening(title,0);

			break;
			
		case "continue":
			
			
		SwingWorker<Void,Void> load = new SwingWorker<Void,Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				title.clearFrame();
				new game(title,1);
				return null;
			}
			
			@Override
			protected void done() {
				splash.hide();
			}
			
		};
			load.execute();
			splash = new frame.splashScreen(title);
			splash.show();
			

			break;
			
		case "exit":
			System.exit(0);
			break;
			
		case "lang":
			title.clearFrame();

			new languageFrame(title);
			break;
		}

	}
}

