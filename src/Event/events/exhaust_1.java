package Event.events;

import Basic.initial;
import Event.eventHandler;
import Event.eventInterface;

public class exhaust_1 implements eventInterface{

	@Override
	public String getname() {

		return "exhaust_1";
	}

	@Override
	public int getid() {
		
		return 4;
	}

	@Override
	public void result(int i) {
		switch(i){
		case 0:
			initial.exhaust = false;
			initial.energyUseupDay = 0;
			break;
		case 1:
			break;
		}
		
	}

	@Override
	public String pictureName() {
		return "event_1.png";
	}

	@Override
	public void newEvent(eventHandler e) {
		// TODO Auto-generated method stub
		
	}

}
