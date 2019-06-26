package main;

public class result {
	int[] knowledge,examSkill;
	
	String[] grade = {"0","0","0","0","0","0"};
	
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
			
			if(knowledge[i+1]>=90 && examSkill[i+1]>90){
				grade[i] = "5**";
			}else if(knowledge[i+1]>=85 && examSkill[i+1]>=85){
				grade[i] = "5*";
			}else if(knowledge[i+1]>=80 && examSkill[i+1]>=70){
				grade[i] = "5";
			}else if(knowledge[i+1]>=60 && examSkill[i+1]>=60){
				grade[i] = "4";
			}else if(knowledge[i+1]>=30){
				grade[i] = "3";
			}else if(knowledge[i+1]>=20){
				grade[i] = "2";
			}else if(knowledge[i+1]>=10){
				grade[i] = "1";
			}else{
				grade[i] = "U";
			}
			
		}
		
		return grade;
		
	}
	
}
