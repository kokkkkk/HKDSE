package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import Basic.initial;

public class saveLoad {
	
	public void loadData(){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("saveFile.txt"));
			int day = Integer.parseInt(br.readLine());
			
			int money = Integer.parseInt(br.readLine());
			
			int ini = Integer.parseInt(br.readLine());
			 
			 String[] mark_s = br.readLine().split("/");
			 String[] knowledge_s = br.readLine().split("/");
			 String[] examSkill_s = br.readLine().split("/");
			
			br.close();
			
			int[] mark = {0,0,0,0,0,0,0};
			int[] knowledge = {0,0,0,0,0,0,0};
			int[] examSkill = {0,0,0,0,0,0,0};
		
			for(int i=0; i<mark_s.length;i++)
			{
				mark[i] = Integer.parseInt(String.valueOf(mark_s[i]));
				knowledge[i] = Integer.parseInt(String.valueOf(knowledge_s[i]));
				examSkill[i] = Integer.parseInt(String.valueOf(examSkill_s[i]));
			}
			
			initial.valueSetup(day,money,ini,mark,knowledge,examSkill);
			
		}catch(Exception e){
			
		}
	}
	
	public void saveData()
	{
		try{
			int day = initial.day;
		
			int money = initial.moneyValue;
			int ini = initial.iniValue;
			 
			 int[] mark = initial.study;
			 int[] knowledge = initial.knowledge;
			 int[] examSkill = initial.examSkill;
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("SaveFile.txt"));
			
			bw.write(""+day);
			bw.newLine();
			bw.write(""+money);
			bw.newLine();
			bw.write(""+ini);
			bw.newLine();
			
			for(int i=0;i<mark.length;i++){
				if(i==0){
					bw.write(""+mark[i]);
				}else{
					bw.write("/");
					bw.write(""+mark[i]);
				}
			}
			
			bw.newLine();
			
			for(int i=0;i<knowledge.length;i++){
				if(i==0){
					bw.write(""+knowledge[i]);
				}else{
					bw.write("/");
					bw.write(""+knowledge[i]);
				}
			}
			
			bw.newLine();
			
			for(int i=0;i<examSkill.length;i++){
				if(i==0){
					bw.write(""+examSkill[i]);
				}else{
					bw.write("/");
					bw.write(""+mark[i]);
				}
			}
			
			bw.close();
		}catch(Exception e){
			
		}
	}
	
	public boolean checkFileExist(){
		File saveFile = new File("SaveFile.txt");
		return saveFile.exists();
	}
}
