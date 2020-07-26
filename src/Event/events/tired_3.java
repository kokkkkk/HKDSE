package Event.events;

import Event.eventHandler;
import Event.eventInterface;

public class tired_3 implements eventInterface{

	@Override
	public String getname() {
		return "tired_3";
	}

	@Override
	public int getid() {

		return 3;
	}

	@Override
	public void result(int i) {
		// TODO Auto-generated method stub
		
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
