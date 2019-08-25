package main;

public class daySchedule {
	
	Basic.initial ini = new Basic.initial();
	
	int[] sub = {0,0,0};
	int[] mark = {0,0,0};
	int[] choices = {0,0,0};
	
	public void getData(int[] getSub, int[] getMark, int[] getchoices) {
		
		sub = getSub;
		
		mark = getMark;
		
		choices = getchoices;
		
		setSchedule();
		
	}
	
	public void setSchedule() {
		
		for(int i = 0; i<sub.length; i++) {
			
			if (choices[i] == 0) {
				
				switch(i) {
				case 0: 
					System.out.println("Morning : Break");
					break;
				case 1: 
					System.out.println("Afternoon : Break");
					break;
				case 2: 
					System.out.println("Night : Break");
					break;
				}
				
			}else {
				
				switch(i) {
				case 0: 
					System.out.println("Morning :" + ini.subject[sub[i]]);
					
					switch(choices[i]) {
					case 1:
						System.out.println("Method : Revision");
						break;
					case 2:
						System.out.println("Method : Do Past Paper");
						break;
					case 3:
						System.out.println("Method : Tutorial");
						break;
					}
					
					System.out.println(ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					break;
				case 1: 
					System.out.println("Afternoon :" + ini.subject[sub[i]]);
					
					switch(choices[i]) {
					case 1:
						System.out.println("Method : Revision");
						break;
					case 2:
						System.out.println("Method : Do Past Paper");
						break;
					case 3:
						System.out.println("Method : Tutorial");
						break;
					}
					
					System.out.println(ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					break;
				case 2: 
					System.out.println("Night :" + ini.subject[sub[i]]);
					
					switch(choices[i]) {
					case 1:
						System.out.println("Method : Revision");
						break;
					case 2:
						System.out.println("Method : Do Past Paper");
						break;
					case 3:
						System.out.println("Method : Tutorial");
						break;
					}
					
					System.out.println(ini.subject[sub[i]] + " 's Mark: " + mark[sub[i]]);
					break;
				}
				
			}
			
		}
		
	}

}
