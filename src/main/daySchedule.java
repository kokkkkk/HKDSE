package main;

import Basic.initial;
import Basic.language;

public class daySchedule {
	
	int[] sub = {0,0,0};
	int[] mark = {0,0,0};
	int[] choices = {0,0,0};
	
	Boolean moneyUseup, exhaust, sameSubTired;
	
	String scheduleText = "";
	String[] fullSchedule;
	
	public void getData(int[] getSub, int[] getMark, int[] getchoices, Boolean money, Boolean exh, Boolean sameSub) {
		
		sub = getSub;
		mark = getMark;
		choices = getchoices;
		moneyUseup = money;
		exhaust = exh;
		sameSubTired = sameSub;
		
		setSchedule();
		
	}
	
	public void setSchedule() {
		
		scheduleText = "";
		
		for(int i = 0; i<sub.length; i++) {
			
			if (choices[i] == 0 || sub[i] == 0) {
				
				switch(i) {
				case 0: 
					System.out.println(language.getV("mLabel")+" : " +language.getV("break"));
					scheduleText += language.getV("mLabel")+" : " +language.getV("break")+"\n";
					break;
				case 1: 
					System.out.println("Afternoon : Break");
					scheduleText += language.getV("aLabel")+" : " +language.getV("break")+"\n";
					break;
				case 2: 
					System.out.println("Night : Break");
					scheduleText += language.getV("nLabel")+" : " +language.getV("break")+"\n";
					break;
				}
				
			}else {
				
				switch(i) {
				case 0: 
					System.out.println(language.getV("mLabel")+" : " + initial.subject[sub[i]]);
					scheduleText += language.getV("mLabel")+" : "  + initial.subject[sub[i]]+"\n";
					
					methodText(i);
					
					System.out.println(initial.subject[sub[i]] + " "+language.getV("smark")+" " + mark[i]);
					scheduleText += initial.subject[sub[i]] + " "+language.getV("smark")+" " + mark[i] + "\n";
					break;
				case 1: 
					System.out.println(language.getV("aLabel")+" : "  + initial.subject[sub[i]]);
					scheduleText += language.getV("aLabel")+" : "  + initial.subject[sub[i]] + "\n";
					
					methodText(i);
					
					System.out.println(initial.subject[sub[i]] + " 's Mark: " + mark[i]);
					scheduleText += initial.subject[sub[i]] + " "+language.getV("smark")+" " + mark[i] + "\n";
					break;
				case 2: 
					System.out.println(language.getV("nLabel")+" : "  + initial.subject[sub[i]]);
					scheduleText += language.getV("nLabel")+" : "  + initial.subject[sub[i]] + "\n";
					
					methodText(i);
					
					System.out.println(initial.subject[sub[i]] + " 's Mark: " + mark[i]);
					scheduleText += initial.subject[sub[i]] + " "+language.getV("smark")+" " + mark[i] + "\n";
					break;
				}
				
			}
			
		}
		
		if(moneyUseup) {
			
			System.out.println("Borrowed Money");
			scheduleText += language.getV("borrowMoney")+"\n";
			
		}
		
		if(exhaust) {
			
			System.out.println("Exhaust");
			scheduleText += language.getV("schedule_exhaust")+"\n";
			
		}
		
		if(sameSubTired) {
			
			System.out.println("SameSubTired");
			scheduleText += language.getV("schedule_ssTired")+"\n";
			
		}
		
	}
	
	public String[] getSchedule() {
		
		fullSchedule = scheduleText.split("\n");
		
		return fullSchedule;
		
	}
	
	public void resetSchedule(){
		fullSchedule = new String[0];
		scheduleText = "";
	}
	
	private void methodText(int i){
		
		switch(choices[i]) {
		case 1:
			System.out.println(language.getV("method")+" : "+ "Revision");
			scheduleText += language.getV("method")+" : "+ language.getV("revision")+"\n";
			break;
		case 2:
			System.out.println("Method : Do Past Paper");
			scheduleText += language.getV("method")+" : "+ language.getV("doPastpaper")+"\n";
			break;
		case 3:
			System.out.println("Method : Tutorial");
			scheduleText += language.getV("method")+" : "+ language.getV("tutorial")+"\n";
			break;
		}
	}

}
