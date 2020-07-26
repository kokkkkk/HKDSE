package Event.events.understory;

import Event.eventHandler;
import Event.eventInterface;

public class substory1 implements eventInterface{
	
	@Override
	public String getname() {
		
		return "substory1";
	}

	@Override
	public String pictureName() {
		
		return "system.png";
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 21;
	}

	@Override
	public void result(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newEvent(eventHandler e) {
		// TODO Auto-generated method stub
		
	}
}
