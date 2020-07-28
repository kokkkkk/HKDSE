package Event.events.understory;

import Event.eventHandler;
import Event.eventInterface;
import Event.events.generalEvent;

public class understory8 implements eventInterface{
	
	substory5 substory5 = new substory5();
	substory6 substory6 = new substory6();
	
	Event.eventHandler eventHandler;
	
	@Override
	public String getname() {
		
		return "understory8";
	}

	@Override
	public String pictureName() {
		
		return "understory8.png";
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 18;
	}

	@Override
	public void result(int i) {
		
		switch(i){
		case 0:
			eventHandler.execute(new generalEvent(substory5));
			break;
		case 1:
			eventHandler.execute(new generalEvent(substory6));
			break;
		}
		
	}

	@Override
	public void newEvent(eventHandler e) {
		eventHandler = e;
		
	}
}
