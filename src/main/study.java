package main;

import java.util.Random;

public class study {
	Basic.initial initial = new Basic.initial();
	Random rand = new Random();
	private int mark[] = initial.study;
	int iniValue = initial.iniValue;
	
	public void mark_cal(int sub){
		getMark()[sub] = getMark()[sub]+ iniValue*rand.nextInt(4);
		
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
