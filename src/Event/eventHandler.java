package Event;

import java.util.Random;
import java.util.Vector;

import Basic.initial;
import Event.events.*;
import frame.eventFrame;
import frame.game;
import frame.title;

public class eventHandler {
	
	game game;
	title title;
	
	Random rand = new Random();
	
	boolean exe = false;
	
	int day;
	int moneyValue;
	
	int[] study;
	int[] knowledge;
	int[] examSkill;

	//Used by main.energy class
	int energyValue;
	int energyUseupDay;
	boolean exhaust;
	boolean energyUseup;
	
	//Used by main.study class
	boolean sameSubtired;
	
	//Used by main.money class
	boolean moneyUseup;
	
	int eventNum = 0;
	
	Vector<Integer> triggeredEvent = initial.triggeredEvent;
	
	/*Instantiate event class*/
	generalEvent generalEvent;
	
	//Energy Class
	tired_1 tired_1 = new tired_1();
	tired_2 tired_2 = new tired_2();
	tired_3 tired_3 = new tired_3();
	exhaust_1 exhaust_1 = new exhaust_1();
	exhaust_2 exhaust_2 = new exhaust_2();
	energy_1 energy_1 = new energy_1();
	
	//Money Class
	money_1 money_1 = new money_1();
	money_2 money_2 = new money_2();
	money_3 money_3 = new money_3();
	money_4 money_4 = new money_4();
	
	/*Instantiate event class*/
	
	public eventHandler(game g, title tit){
		title = tit;
		game = g;
		
	}
	
	public void update(){
		day = initial.day;
		moneyValue = initial.moneyValue;
		
		study = initial.study;
		knowledge = initial.knowledge;
		examSkill = initial.examSkill;

		//Used by main.energy class
		energyValue = initial.energyValue;
		energyUseupDay = initial.energyUseupDay;
		exhaust = initial.exhaust;
		energyUseup = initial.energyUseup;
		
		//Used by main.study class
		sameSubtired = initial.tired;
		
		//Used by main.money class
		moneyUseup = initial.moneyUseup;
		
		eventNum = 0;
		
		dispatcher();
	}
	
	private void dispatcher(){
		exe = false;
	
		checkEnergy();
		checkMoney();
		
		if(!exe){
			game.dayReset();
		}
		
	}
	
	private void execute(generalEvent o){
		exe = true;
		eventNum++;
		initial.eventNum++;
		o.execution(new eventFrame(title,game,eventNum));
	}
	
	private boolean random(int ranValue){
		
		if(rand.nextInt(ranValue)+1 == 1){
			return true;
		}else{
			return false;
		}
		
	}
	
	private void checkEnergy(){
		
		if(exhaust){
			if(day == 30){
				execute(new generalEvent(exhaust_2));
				
			}else if(random(10)){
				execute(new generalEvent(exhaust_1));
			}	
				
		}else if(sameSubtired && !triggeredEvent.contains(tired_3.getid())){
			
			triggeredEvent.add(tired_3.getid());
			execute(new generalEvent(tired_3));
			
		}else if(energyUseup){
			
			if(!triggeredEvent.contains(tired_2.getid())){
				
				triggeredEvent.add(tired_2.getid());
				execute(new generalEvent(tired_2));
				
			}else{
				if(random(10)){
					execute(new generalEvent(tired_1));
				}
			}
		}else if(energyValue < 30  && !triggeredEvent.contains(energy_1.getid())){
			triggeredEvent.add(energy_1.getid());
			execute(new generalEvent(energy_1));
		}
	}
	
	private void checkMoney(){
		if(moneyUseup){
			
			execute(new generalEvent(money_1));
			
		}else if(moneyValue < 100){
			
			if(!triggeredEvent.contains(money_2.getid())){
				
				triggeredEvent.add(money_2.getid());
				execute(new generalEvent(money_2));
				
			}else if(random(50)){
				
				execute(new generalEvent(money_3));
			}
			
		}else if(moneyValue > 1000){
			
			if(random(5)){
				execute(new generalEvent(money_4));
				
			}
			
		}
	}
}
