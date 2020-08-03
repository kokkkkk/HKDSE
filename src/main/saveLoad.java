package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;
import java.util.Vector;

import javax.crypto.spec.SecretKeySpec;

import Basic.initial;

public class saveLoad {
	
	Basic.encryption encryption = new Basic.encryption();
	
	public void loadData(){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("saveFile.txt"));
			
			String key = br.readLine();

			byte[] decodedKey = Base64.getDecoder().decode(key);
			initial.key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			encryption.updateKey(initial.key);
			
			int day = Integer.parseInt(encryption.decrypt(br.readLine()));
			
			int money = Integer.parseInt(br.readLine());
			int addAmount = Integer.parseInt(br.readLine());
			
			int ini = Integer.parseInt(br.readLine());
			
			int energyValue = Integer.parseInt(br.readLine());
			int energyUseupDay = Integer.parseInt(br.readLine());
			boolean exhaust = Boolean.parseBoolean(br.readLine());
			boolean energyUseup = Boolean.parseBoolean(br.readLine());
			
			boolean tired = Boolean.parseBoolean(br.readLine());
			 
			String[] mark_s = br.readLine().split("/");
			String[] knowledge_s = br.readLine().split("/");
			String[] examSkill_s = br.readLine().split("/");
			String[] subject = br.readLine().split("/");
			
			String[] triggeredEvent_s = null;
			String temp = br.readLine();
			if(temp != null){
				triggeredEvent_s = temp.split("/");
			}
			
			br.close();
			
			int[] mark = {0,0,0,0,0,0,0};
			int[] knowledge = {0,0,0,0,0,0,0};
			int[] examSkill = {0,0,0,0,0,0,0};
			
			Vector<Integer> triggeredEvent = new Vector<Integer>();
		
			for(int i=0; i<mark_s.length;i++)
			{
				mark[i] = Integer.parseInt(String.valueOf(mark_s[i]));
				knowledge[i] = Integer.parseInt(String.valueOf(knowledge_s[i]));
				examSkill[i] = Integer.parseInt(String.valueOf(examSkill_s[i]));
			}
			
			if(triggeredEvent_s != null){
				
				for(int i=0; i<triggeredEvent_s.length;i++)
				{
					triggeredEvent.add(Integer.parseInt(String.valueOf(triggeredEvent_s[i])));
				}
			}
			
			initial.valueSetup(day,money,addAmount,ini,mark,knowledge,examSkill,subject,triggeredEvent);
			initial.energy_update(energyValue, energyUseupDay, exhaust, energyUseup);
			initial.study_update(tired);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveData()
	{
		try{
			int day = initial.day;
		
			int money = initial.moneyValue;
			int addAmount = initial.moneyaddAmount;
			int ini = initial.iniValue;
			
			int energyValue = initial.energyValue;
			int energyUseupDay = initial.energyUseupDay;
			boolean exhaust = initial.exhaust;
			boolean energyUseup = initial.energyUseup;
			
			boolean tired = initial.tired;
			 
			int[] mark = initial.study;
			int[] knowledge = initial.knowledge;
			int[] examSkill = initial.examSkill;
			 
			String[] subject = initial.o_subject;
			 
			Vector<Integer> triggeredEvent = initial.triggeredEvent;
			
			String key = Base64.getEncoder().encodeToString(initial.key.getEncoded());
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("SaveFile.txt"));
			
			bw.write(""+key);
			bw.newLine();
			bw.write(encryption.encrypt(""+day));
			bw.newLine();
			bw.write(""+money);
			bw.newLine();
			bw.write(""+addAmount);
			bw.newLine();
			bw.write(""+ini);
			bw.newLine();
			bw.write(""+energyValue);
			bw.newLine();
			bw.write(""+energyUseupDay);
			bw.newLine();
			bw.write(""+exhaust);
			bw.newLine();
			bw.write(""+energyUseup);
			bw.newLine();
			bw.write(""+tired);
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
			
			bw.newLine();
			
			for(int i=0;i<subject.length;i++){
				if(i==0){
					bw.write(""+subject[i]);
				}else{
					bw.write("/");
					bw.write(""+subject[i]);
				}
			}
			
			bw.newLine();
			
			for(int i=0;i<triggeredEvent.size();i++){
				if(i==0){
					bw.write(""+triggeredEvent.get(i));
				}else{
					bw.write("/");
					bw.write(""+triggeredEvent.get(i));
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
