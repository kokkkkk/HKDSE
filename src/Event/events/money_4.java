package Event.events;

import Basic.initial;
import Event.eventInterface;

public class money_4 implements eventInterface {
	
	int[] mark = initial.study;
	int[] knowledge = initial.knowledge;
	int[] examSkill = initial.examSkill;

	@Override
	public String getname() {
		
		return "money_4";
	}

	@Override
	public int getid() {
		
		return 10;
	}

	@Override
	public void result(int i) {
		switch(i){
		case 0:
			initial.moneyValue -= 600;
			
			for(int a = 1; a<mark.length; a++){
				mark[a] += 20;
				
				knowledge[a] += 20;
				examSkill[a] += 20;
			}
			
			
			initial.valueSetup(initial.day, initial.moneyValue, initial.iniValue, mark, knowledge, examSkill);
			break;
			
		case 1:
			break;
			
		}
		
	}

	@Override
	public String pictureName() {
		return "event_1.png";
	}

}
