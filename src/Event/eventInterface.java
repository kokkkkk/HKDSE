package Event;

public abstract interface eventInterface {
	
	String getname();
	String pictureName();
	int getid();
	void result(int i);
	void newEvent(eventHandler e);
}
