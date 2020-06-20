package main;

import Basic.initial;

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
					System.out.println("Morning : Break");
					scheduleText += "Morning : Break\n";
					break;
				case 1: 
					System.out.println("Afternoon : Break");
					scheduleText += "Afternoon : Break\n";
					break;
				case 2: 
					System.out.println("Night : Break");
					scheduleText += "Night : Break\n";
					break;
				}
				
			}else {
				
				switch(i) {
				case 0: 
					System.out.println("Morning :" + initial.subject[sub[i]]);
					scheduleText += "Morning :" + initial.subject[sub[i]]+"\n";
					
					switch(choices[i]) {
					case 1:
						System.out.println("Method : Revision");
						scheduleText += "Method : Revision\n";
						break;
					case 2:
						System.out.println("Method : Do Past Paper");
						scheduleText += "Method : Do Past Paper\n";
						break;
					case 3:
						System.out.println("Method : Tutorial");
						scheduleText += "Method : Tutorial\n";
						break;
					}
					
					System.out.println(initial.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					scheduleText += initial.subject[sub[i]] + " 's Mark: " + mark[sub[i]] + "\n";
					break;
				case 1: 
					System.out.println("Afternoon :" + initial.subject[sub[i]]);
					scheduleText += "Afternoon :" + initial.subject[sub[i]] + "\n";
					
					switch(choices[i]) {
					case 1:
						System.out.println("Method : Revision");
						scheduleText += "Method : Revision\n";
						break;
					case 2:
						System.out.println("Method : Do Past Paper");
						scheduleText += "Method : Do Past Paper\n";
						break;
					case 3:
						System.out.println("Method : Tutorial");
						scheduleText += "Method : Tutorial\n";
						break;
					}
					
					System.out.println(initial.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					scheduleText += initial.subject[sub[i]] + " 's Mark: " + mark[sub[i]] + "\n";
					break;
				case 2: 
					System.out.println("Night :" + initial.subject[sub[i]]);
					scheduleText += "Night :" + initial.subject[sub[i]] + "\n";
					
					switch(choices[i]) {
					case 1:
						System.out.println("Method : Revision");
						scheduleText += "Method : Revision\n";
						break;
					case 2:
						System.out.println("Method : Do Past Paper");
						scheduleText += "Method : Do Past Paper\n";
						break;
					case 3:
						System.out.println("Method : Tutorial");
						scheduleText += "Method : Tutorial\n";
						break;
					}
					
					System.out.println(initial.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					scheduleText += initial.subject[sub[i]] + " 's Mark: " + mark[sub[i]] + "\n";
					break;
				}
				
			}
			
		}
		
		if(moneyUseup) {
			
			System.out.println("Borrowed Money");
			scheduleText += "Borrowed money from others.\n";
			
		}
		
		if(exhaust) {
			
			System.out.println("Exhaust");
			scheduleText += "Exhaust. Life is no hope.\n";
			
		}
		
		if(sameSubTired) {
			
			System.out.println("SameSubTired");
			scheduleText += "Tired because study the same subject.\n";
			
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

}
