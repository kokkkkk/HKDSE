package Event;

import frame.eventFrame;

public abstract interface eventInterface {
	
	boolean trigger();
	public void execution(eventFrame eventFrame);
	abstract void result();
	

}
