package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Basic.language;
import frame.languageFrame;

public class languageHandler implements ActionListener{
	
	languageFrame langFrame;
	frame.title title;
	
	public languageHandler(languageFrame lang,frame.title t){
		langFrame = lang;
		title = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch(command){
		case "back":
			title.window.dispose();
			new frame.title();
			break;
		case "submit":
			
			int i = langFrame.getSelection();
			language.lang_choose = i;
			title.window.dispose();
			new frame.title();
			
			break;
		}
		
	}

}
