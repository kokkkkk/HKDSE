package Event.events.understory;

import Basic.initial;
import Event.eventHandler;
import Event.eventInterface;

public class substory5 implements eventInterface{
	
	@Override
	public String getname() {
		
		return "substory5";
	}

	@Override
	public String pictureName() {
		
		return "system.png";
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public void result(int i) {
		initial.closeWindow = true;
		
	}

	@Override
	public void newEvent(eventHandler e) {
		// TODO Auto-generated method stub
		
	}
}
