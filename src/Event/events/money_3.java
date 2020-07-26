package Event.events;

import Basic.initial;
import Event.eventHandler;
import Event.eventInterface;

public class money_3 implements eventInterface {

	@Override
	public String getname() {
		
		return "money_3";
	}

	@Override
	public int getid() {
		
		return 9;
	}

	@Override
	public void result(int i) {
		initial.day ++;
		
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
