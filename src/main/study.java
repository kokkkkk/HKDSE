package main;

import java.util.Random;

public class study {
	Basic.initial initial = new Basic.initial();
	Random rand = new Random();
	private int mark[] = initial.study;
	int[] knowledge = initial.knowledge;
	int[] examSkill = initial.examSkill;
	int iniValue = initial.iniValue;
	
	public void mark_cal(int sub, int choice){
		
		switch(choice){
		
		case 1:
			knowledge[sub] += iniValue*rand.nextInt(4);
			break;
			
		case 2:
			examSkill[sub] += iniValue*rand.nextInt(4);
			
		case 3:
			knowledge[sub] += iniValue*rand.nextInt(4);
			examSkill[sub] += iniValue*rand.nextInt(4);
			
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

	public void setMark(int mark[]) {
		this.mark = mark;
	}
}
