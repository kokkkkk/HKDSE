package Event;

import java.util.Random;

import Basic.initial;
import Event.events.*;
import frame.eventFrame;

public class eventHandler {
	
	eventFrame eventFrame;
	
	Random rand = new Random();
	
	int day;
	int moneyValue;
	
	int[] study;
	int[] knowledge;
	int[] examSkill;

	//Used by main.energy class
	int energyValue;
	int energyUseupDay;
	boolean exhaust;
	
	//Used by main.study class
	boolean tired;
	
	//Used by main.money class
	boolean moneyUseup;
	
	/*Instantiate event class*/
	tired_1 tired_1 = new tired_1();
	tired_2 tired_2 = new tired_2();
	
	public eventHandler(eventFrame eventFrame){
		this.eventFrame = eventFrame;
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
		
		//Used by main.study class
		tired = initial.tired;
		
		//Used by main.money class
		moneyUseup = initial.moneyUseup;
		
		dispatcher();
	}
	
	private void dispatcher(){
		
		if(tired){
			if(!tired_2.trigger()){
				execute(tired_2);
			}
		}
		
	}
	
	private void execute(Object o){
		eventFrame.eventSetup();
		((eventInterface) o).execution(eventFrame);
	}
	
	private boolean random(int ranValue){
		
		if(rand.nextInt(ranValue)+1 == 5){
			return true;
		}else{
			return false;
		}
		
	}
}
