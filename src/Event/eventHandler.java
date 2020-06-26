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
	
	Vector<Integer> triggeredEvent = new Vector<>();
	
	/*Instantiate event class*/
	generalEvent generalEvent;
	tired_1 tired_1 = new tired_1();
	tired_2 tired_2 = new tired_2();
	tired_3 tired_3 = new tired_3();
	
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
		
		dispatcher();
	}
	
	private void dispatcher(){
		exe = false;
		
		if(sameSubtired){
			
				if(!triggeredEvent.contains(tired_3.getid())){
				
				triggeredEvent.add(tired_3.getid());
				execute(new generalEvent(tired_3));
				
				}
				
		}else if(energyUseup){
			
			if(!triggeredEvent.contains(tired_2.getid())){
				
				triggeredEvent.add(tired_2.getid());
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
