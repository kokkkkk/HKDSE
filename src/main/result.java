package main;

import Basic.initial;

public class result {
	int[] knowledge,examSkill;
	boolean universityChance;
	
	String[] grade = {"0","0","0","0","0","0"};
	int[] gradeNum = {0,0,0,0,0,0};
	
	int learningVariable = initial.iniValue;
	
	main.study study = new main.study();
	
	public result(){
		
		for(int i=0; i<grade.length; i++){
			grade[i] = "0";
		}
	}

	public String[] gradeCalculate(int[] knowledgeValue,int[] examSkillValue){
		
		knowledge = knowledgeValue;
		examSkill = examSkillValue;
		
		for(int i=0;i<grade.length;i++){
			
			if(knowledge[i+1]>=90 && examSkill[i+1]>90 && learningVariable > 8){
				grade[i] = "5**";
				gradeNum[i] = 7;
			}else if(knowledge[i+1]>=85 && examSkill[i+1]>=85 && learningVariable > 6){
				grade[i] = "5*";
				gradeNum[i] = 6;
			}else if(knowledge[i+1]>=80 && examSkill[i+1]>=70){
				grade[i] = "5";
				gradeNum[i] = 5;
			}else if(knowledge[i+1]>=60 && examSkill[i+1]>=60){
				grade[i] = "4";
				gradeNum[i] = 4;
			}else if(knowledge[i+1]>=30){
				grade[i] = "3";
				gradeNum[i] = 3;
			}else if(knowledge[i+1]>=20){
				grade[i] = "2";
				gradeNum[i] = 2;
			}else if(knowledge[i+1]>=10){
				grade[i] = "1";
				gradeNum[i] = 1;
			}else{
				grade[i] = "U";
				gradeNum[i] = 0;
			}
			
		}
		
		return grade;
		
	}
	
	public boolean universityChance(){
		
		if(gradeNum[0] >= 3){
			universityChance = true;
			
			if(gradeNum[1] >=3){
				universityChance = true;
				
				if(gradeNum[2] >=3){
					
					universityChance = true;
					
					if(gradeNum[3]>=2){
						universityChance = true;
						
						if(gradeNum[4]>=2){
							universityChance = true;
							
							if(gradeNum[5]>=2){
								universityChance = true;
							}else{
								universityChance = false;
							}
						}else{
							universityChance = false;
						}
					}else{
						universityChance = false;
					}
				}else{
					universityChance = false;
				}
			}else{
				universityChance = false;
			}
		}else{
			universityChance = false;
		}
		
		return universityChance;
	}
	
}
