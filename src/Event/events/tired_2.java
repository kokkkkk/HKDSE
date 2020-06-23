package Event.events;

import Event.eventInterface;
import frame.eventFrame;

public class tired_2 implements eventInterface{
	boolean trig = false;
	String text[] = {"Tired_2"};

	@Override
	public boolean trigger() {
		
		return trig;
	}

	@Override
	public void execution(eventFrame eventFrame) {
		eventFrame.setText(text);
	}

	@Override
	public void result() {
		
		
	}

}
