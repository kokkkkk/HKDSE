package Event.events;

import Basic.initial;
import Event.eventHandler;
import Event.eventInterface;

public class money_1 implements eventInterface {

	@Override
	public String getname() {
		
		return "money_1";
	}

	@Override
	public int getid() {
		
		return 7;
	}

	@Override
	public void result(int i) {
		initial.moneyValue = 0;
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
