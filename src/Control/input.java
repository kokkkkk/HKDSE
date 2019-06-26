package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class input implements ActionListener{
	
	Time._control time = new Time._control();
	frame.Main main;
	main.study study = new main.study();
	main.energy energy = new main.energy();
	
	int day,chin,eng,math,ls,sub1,sub2,energyValue;
	int[] mark, studySubject, choices;
	boolean timeup, energyUseup;
	
	public input(frame.Main m){
		
		main = m;
	}
	
	
	public void actionPerformed(ActionEvent event){
		timeup = time.getTimeup();
		
		if( timeup == false){
			time.increase();
			day = time.getDay();
			
			studySubject = main.getStudySubject();
			
			choices = main.getChoices();
			
			energyValue = energy.energyUse(studySubject);
			
			energyUseup = energy.checkEnergyUseup();
			
			for(int i=0; i<main.getStudySubject().length; i++){
				study.mark_cal(studySubject[i],choices[i]);
			}
			
			mark = study.getMark();
			chin = mark[1];
			eng = mark[2];
			math = mark[3];
			ls = mark[4];
			sub1 = mark[5];
			sub2 = mark[6];
			
			main.valueSetup(day,chin,eng,math,ls,sub1,sub2);
			
			main.changeEnergyBar(energyValue);
			
			main.dayReset();
			
			if(energyUseup){
				
				main.energyUseup();
			}
			
		}else{
			main.dayReset();
			main.endGame(study.getKnowledge(),study.getExamSkill());
		}
	}
}
