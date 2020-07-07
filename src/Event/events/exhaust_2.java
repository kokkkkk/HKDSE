package Event.events;

import Basic.initial;
import Event.eventInterface;

public class exhaust_2 implements eventInterface{

	@Override
	public String getname() {
		
		return "exhaust_2";
	}

	@Override
	public int getid() {
		
		return 5;
	}

	@Override
	public void result(int i) {
		switch(i){
		case 0:
			initial.exhaust = false;
			initial.energyUseupDay = 0;
			break;
		case 1:
			initial.closeWindow = true;
			break;
		}
		
	}

	@Override
	public String pictureName() {
		return "event_1.png";
	}

}
