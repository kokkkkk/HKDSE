package main;

public class result {
	int[] mark;
	
	int[] grade = {0,0,0,0,0,0};
	
	main.study study = new main.study();
	
	public result(){
		
		for(int i=0; i<grade.length; i++){
			grade[i] = 0;
		}
	}

	public int[] gradeCalculate(int[] markResult){
		
		mark = markResult;
		
		for(int i=0;i<grade.length;i++){
			
			if(mark[i+1]>90){
				grade[i] = 7;
			}else if(mark[i+1]>85){
				grade[i] = 6;
			}else if(mark[i+1]>80){
				grade[i] = 5;
			}else if(mark[i+1]>60){
				grade[i] = 4;
			}else if(mark[i+1]>30){
				grade[i] = 3;
			}else if(mark[i+1]>20){
				grade[i] = 2;
			}else if(mark[i+1]>10){
				grade[i] = 1;
			}else{
				grade[i] = 0;
			}
			
		}
		
		return grade;
		
	}
	
}
