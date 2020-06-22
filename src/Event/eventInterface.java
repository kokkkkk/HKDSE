package Event;

import frame.eventFrame;

public abstract interface eventInterface {
	
	public void execution(eventFrame eventFrame);
	abstract void result();
}
