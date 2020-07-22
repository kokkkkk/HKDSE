package Time;

import Basic.initial;

public class _control {
	
	private boolean timeup = false;
	

	public void increase(){
			initial.day++;
			
			if(initial.day>=30){
				timeup = true;
			}
	}
	
	public int getDay(){
		
		return initial.day;
	}
	
	public boolean getTimeup(){

		return timeup;
		
		
	}
	
	public void restart(){
		
		timeup = false;
		
	}
	
	public void setDay(int dayValue){
		initial.day = dayValue;
		System.out.println("restart: "+initial.day);
	}
	
}
