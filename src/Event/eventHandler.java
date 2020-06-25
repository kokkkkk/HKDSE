package Event;

import java.util.Random;

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
	
	//Used by main.study class
	boolean tired;
	
	//Used by main.money class
	boolean moneyUseup;
	
	/*Instantiate event class*/
	generalEvent generalEvent;
	tired_1 tired_1 = new tired_1();
	tired_2 tired_2 = new tired_2();
	
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
		
		//Used by main.study class
		tired = initial.tired;
		
		//Used by main.money class
		moneyUseup = initial.moneyUseup;
		
		dispatcher();
	}
	
	private void dispatcher(){
		exe = false;
		
		if(tired){
			if(true){
				execute(new generalEvent(tired_2));
			}else{
				if(random(10)){
					execute(new generalEvent(tired_1));
				}
			}
			
		}
		
		if(!exe){
			game.dayReset();
		}
		
	}
	
	private void execute(generalEvent o){
		exe = true;
		o.execution(new eventFrame(title,game));
	}
	
	private boolean random(int ranValue){
		
		if(rand.nextInt(ranValue)+1 == 5){
			return true;
		}else{
			return false;
		}
		
	}
}
