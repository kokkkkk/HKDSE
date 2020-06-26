package main;

import Basic.initial;

public class energy {
	
	int energyValue = Basic.initial.energyValue;
	int energyUseupDay = Basic.initial.energyUseupDay;
	boolean exhaust = Basic.initial.exhaust;

	public int energyUse(int[] studySub){
		
		valueUpdate();
		
		if (energyValue >= 0 && energyValue <= 100){
			
			for(int i = 0;i<studySub.length;i++){
				
				if (studySub[i] != 0){
					
					energyValue -= 5;
					
					if(energyValue <= 0){
						
						energyValue = 0;
						energyUseupDay++;
						System.out.println(energyUseupDay);
						
					}
						
					if(energyUseupDay == 3){
							
						System.out.println("exhaust");
						exhaust = true;
							
					}
					
				}else{
					
					energyValue += 30;
					
					if(energyValue > 100){
						
						energyValue = 100;
						
					}
					
				}
			}
		}
		
		initial.energy_update(energyValue, energyUseupDay, exhaust, energyValue <= 0);
		return energyValue;
		
	}
	
	public void valueUpdate(){

		energyValue = Basic.initial.energyValue;
		energyUseupDay = Basic.initial.energyUseupDay;
		exhaust = Basic.initial.exhaust;
	}
	
	public boolean checkEnergyUseup(){
		
		valueUpdate();

		if (energyValue > 0){
			
			return false;
			
		}else{
			
			return true;
		}
	
	}
	
	public boolean checkExhaust(){
		
		return exhaust;
	}
	
	public int getEnergyValue(){
		
		return energyValue;
		
	}
}
