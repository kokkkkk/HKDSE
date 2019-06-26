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
	
	public void mark_cal(int sub, int choice){
		
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
		
		getMark()[sub] = (knowledge[sub]+examSkill[sub])/2;
		
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
}
