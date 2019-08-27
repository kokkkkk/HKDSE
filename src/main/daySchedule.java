package main;

public class daySchedule {
	
	Basic.initial ini = new Basic.initial();
	
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
			
			if (choices[i] == 0) {
				
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
					System.out.println("Morning :" + ini.subject[sub[i]]);
					scheduleText += "Morning :" + ini.subject[sub[i]]+"\n";
					
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
					
					System.out.println(ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					scheduleText += ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]] + "\n";
					break;
				case 1: 
					System.out.println("Afternoon :" + ini.subject[sub[i]]);
					scheduleText += "Afternoon :" + ini.subject[sub[i]] + "\n";
					
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
					
					System.out.println(ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					scheduleText += ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]] + "\n";
					break;
				case 2: 
					System.out.println("Night :" + ini.subject[sub[i]]);
					scheduleText += "Night :" + ini.subject[sub[i]] + "\n";
					
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
					
					System.out.println(ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					scheduleText += ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]] + "\n";
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
		
		fullSchedule = scheduleText.split("\n", -1);
		
		return fullSchedule;
		
	}
	

}
