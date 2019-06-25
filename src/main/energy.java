package main;

public class energy {
	
	int energyValue = 100;

	public int energyUse(int[] studySub){
		
		if (energyValue > 0 || energyValue < 100){
			
			for(int i = 0;i<studySub.length;i++){
				
				if (studySub[i] != 0){
					
					energyValue -= 5;
					
				}else{
					
					energyValue += 5;
					
				}
			}
		}
		
		return energyValue;
		
	}
	
	public boolean checkEnergyUseup(){

		if (energyValue > 0){
			
			return false;
			
		}else{
			
			return true;
		}
	
	}
	
	public int getEnergyValue(){
		
		return energyValue;
		
	}
}
