package main;

import java.util.Random;

public class study {
	Basic.initial initial = new Basic.initial();
	main.money money = new main.money();
	
	Random rand = new Random();
	private int mark[] = initial.study;
	int[] knowledge = initial.knowledge;
	int[] examSkill = initial.examSkill;
	int iniValue = initial.iniValue;
	int moneyValue = 0;
	int exhaustConstant = iniValue;
	int tempSub = 0;
	int studySameSub = 0;
	boolean tired;
	
	public void mark_cal(int sub, int choice, boolean exhaust){
		
		checkSameSub(sub);
		
		if(exhaust || tired){
			
			if(exhaustConstant != 0){
				
				exhaustConstant --;
			}
			
			switch(choice){
			
			case 1:
				knowledge[sub] +=  exhaustConstant;
				break;
				
			case 2:
				examSkill[sub] += exhaustConstant;
				break;
				
			case 3:
				moneyValue ++;
				knowledge[sub] += exhaustConstant;
				examSkill[sub] += exhaustConstant;
				break;
				
			}
			
		}else{
			
			switch(choice){
			
			case 1:
				knowledge[sub] += iniValue*rand.nextInt(4);
				break;
				
			case 2:
				examSkill[sub] += iniValue*rand.nextInt(4);
				break;
				
			case 3:
				moneyValue ++;
				knowledge[sub] += iniValue*rand.nextInt(4);
				examSkill[sub] += iniValue*rand.nextInt(4);
				break;
				
			}
		}
	
		
		getMark()[sub] = (knowledge[sub]+examSkill[sub])/2;
		
		if(getMark()[sub]<= 0){
			
			getMark()[sub] = 0;
		}
		
	}
	
	public void mark_show(){
		for(int i=1;i<getMark().length;i++){
			System.out.println(initial.subject[i]+ ": "+ getMark()[i]);
		}
	}

	public int[] getMark() {
		return mark;
	}
	
	public int[]getKnowledge(){
		
		return knowledge;
	}
	
	public int[]getExamSkill(){
		
		return examSkill;
	}
	
	public int getMoneyValue(){
		
		return moneyValue;
	}
	
	public void setMark(int mark[]) {
		this.mark = mark;
	}
	
	public void setMoneyValue(int value){
		
		moneyValue = value;
		
	}
	
	public void checkSameSub(int sub){
		
		if (tempSub == 0 ){
			
			tempSub = sub;
			
		}else if(tempSub == sub){
			
			studySameSub++;
			
			if(studySameSub >= 2){
				System.out.println("tired");
				tired = true;
			}
			
		}else{
			
			tempSub = sub;
			studySameSub = 0;
			
			tired = false;
		
		}
		
	}
	
	public boolean getTired() {
		
		return tired;
		
	}
}
