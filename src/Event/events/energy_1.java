package Event.events;

import Event.eventHandler;
import Event.eventInterface;

public class energy_1 implements eventInterface {

	@Override
	public String getname() {
		
		return "energy_1";
	}

	@Override
	public int getid() {
		
		return 6;
	}

	@Override
	public void result(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pictureName() {
		return "event_2.png";
	}

	@Override
	public void newEvent(eventHandler e) {
		// TODO Auto-generated method stub
		
	}

}
