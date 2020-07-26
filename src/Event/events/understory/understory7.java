package Event.events.understory;

import Event.eventHandler;
import Event.eventInterface;
import Event.events.generalEvent;

public class understory7 implements eventInterface{
	
	substory3 substory3 = new substory3();
	substory4 substory4 = new substory4();
	
	Event.eventHandler eventHandler;
	
	@Override
	public String getname() {
		
		return "understory7";
	}

	@Override
	public String pictureName() {
		
		return "system.png";
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 17;
	}

	@Override
	public void result(int i) {
		
		switch(i){
		case 0:
			eventHandler.execute(new generalEvent(substory3));
			break;
		case 1:
			eventHandler.execute(new generalEvent(substory4));
			break;
		}
		
	}

	@Override
	public void newEvent(eventHandler e) {
		eventHandler = e;
		
	}
}
