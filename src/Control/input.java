package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class input implements ActionListener{
	
	Time._control time = new Time._control();
	frame.Game game;
	main.study study = new main.study();
	main.energy energy = new main.energy();
	main.money money = new main.money();
	main.daySchedule daySchedule = new main.daySchedule();
	
	int day,chin,eng,math,ls,sub1,sub2,energyValue,moneyValue;
	int[] mark, studySubject, choices;
	boolean timeup, energyUseup,moneyUseup,sameSubTired;
	
	public input(frame.Game g){
		
		game = g;
		
	}
	
	
	public void actionPerformed(ActionEvent event){
		
		game.addday(0);
		
		timeup = time.getTimeup();
		
		if( timeup == false){
			time.increase();
			day = time.getDay();
			
			studySubject = game.getStudySubject();
			
			choices = game.getChoices();
			
			energyValue = energy.energyUse(studySubject);
			
			energyUseup = energy.checkEnergyUseup();
			
			for(int i=0; i<game.getStudySubject().length; i++){
				
				study.mark_cal(studySubject[i],choices[i],energy.checkExhaust());
			}
			
			mark = study.getMark();
			chin = mark[1];
			eng = mark[2];
			math = mark[3];
			ls = mark[4];
			sub1 = mark[5];
			sub2 = mark[6];
			
			money.addMoney();
			
			money.lostMoney(study.gettutorial());
			
			moneyValue = money.getMoney();
			
			moneyUseup = money.getMoneyuseup();
			
			game.valueSetup(day,chin,eng,math,ls,sub1,sub2,moneyValue);
			
			game.changeEnergyBar(energyValue);
			
			study.settutorial(0);
			
			sameSubTired = study.getTired();
			
			if(moneyUseup){
				
				
				game.moneyUseup(true);
				
			}else{
				
				game.moneyUseup(false);
			}
			
			daySchedule.getData(studySubject, mark, choices, moneyUseup ,energy.checkExhaust(),sameSubTired);
			
			game.dayScheduleSetup(daySchedule.getSchedule());
			daySchedule.resetSchedule();
			
			game.dayReset();
			
			game.energyUseup(energyUseup,energy.checkExhaust(),sameSubTired);
			
		}else{
			
			game.endGame(study.getKnowledge(),study.getExamSkill());
		}
	}
}
