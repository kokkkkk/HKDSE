package Event.events.understory;

import Event.eventHandler;
import Event.eventInterface;

public class understory1 implements eventInterface{
	
	@Override
	public String getname() {
		
		return "understory1";
	}

	@Override
	public String pictureName() {
		
		return "understory1.png";
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 11;
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
