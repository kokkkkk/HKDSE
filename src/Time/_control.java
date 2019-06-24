package Time;

public class _control {
	
	Basic.initial initial = new Basic.initial();
	
	private boolean timeup = false;
	
	int day = initial.day;
	
	public void increase(){
			day++;
			
			if(day>=30){
				timeup = true;
			}
	}
	
	public int getDay(){
		
		return day;
	}
	
	public boolean getTimeup(){

		return timeup;
		
		
	}
	
	public void restart(){
		
		timeup = false;
		
	}
	
	public void setDay(int dayValue){
		day = dayValue;
		System.out.println("restart: "+day);
	}
	
}
