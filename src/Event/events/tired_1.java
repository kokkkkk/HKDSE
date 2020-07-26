package Event.events;

import Basic.initial;
import Event.eventHandler;

public class tired_1 implements Event.eventInterface{

	@Override
	public String getname() {

		return "tired_1";
	}

	@Override
	public int getid() {
		
		return 1;
	}

	@Override
	public void result(int i) {
		switch(i){
		case 0:
			initial.tired = false;
			initial.energyValue += 10;
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
