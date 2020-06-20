package main;

import java.util.Random;

import Basic.initial;

public class exam{
	
	Random rand = new Random();
	
	int[] difficulty = {0,0,0,0,0,0,0}; 
	int[] knowledge = {0,0,0,0,0,0,0}; 
	int[] examSkill = {0,0,0,0,0,0,0}; 
	
	String text = "";
	String[] examText;
	
	/**
	 * Difficulty: Very hard, hard, Normal, Easy, Very easy
	 */
	
	public int[] generateDiff(int[] knowledgeValue, int[] examSkillValue){
		
		knowledge = knowledgeValue;
		examSkill = examSkillValue;
		
		for(int i=1;i<difficulty.length;i++){
			difficulty[i] = rand.nextInt(5);
			
			text += initial.subject[i]+" is ";
			
			switch(difficulty[i]){
			
			case 0: //Very hard
				examSkill[i] -= 20;
				
				text += "very hard";
				text += "\nPerformance is affected";
				break;
				
			case 1: //Hard
				text += "hard";
				
				if(!(knowledge[i] > 90 && examSkill[i] > 90)){
					knowledge[i] -= 10;
					examSkill[i] -= 5;
					
					text += "\nPerformance is affected";
				}
				
				text += "\nBut Performance is not affected";
				
				break;
				
			case 2: //Normal
				text += "normal";
				text += "\nPerformance is not affected";
				break;
				
			case 3: //Easy
				
				examSkill[i]*= 1.5;
				
				text += "easy";
				text += "\nPerformance is better";
				
				break;
				
			case 4: //Very easy
				knowledge[i] *= 1.5;
				examSkill[i] += 20;
				
				text += "very easy";
				text += "\nPerformance is better";
				break;
			}
			
			text += "\n";
		}
		
		
		return difficulty;
	}
	
	public int[] getKnowledge(){
		return knowledge;
	}
	
	public int[] getExamSkill(){
		return examSkill;
	}
	
	public String[] getExamText(){
		System.out.print(text);
		examText = text.split("\n");
		
		return examText;
	}
}