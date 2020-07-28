package Event.events.understory;

import Event.eventInterface;
import Event.events.generalEvent;

public class understory5 implements eventInterface{
	
	substory1 substory1 = new substory1();
	substory2 substory2 = new substory2();
	
	Event.eventHandler eventHandler;
	
	@Override
	public String getname() {
		
		return "understory5";
	}

	@Override
	public String pictureName() {
		
		return "understory5.png";
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	public void result(int i) {
		switch(i){
		case 0:
			eventHandler.execute(new generalEvent(substory1));
			break;
		case 1:
			eventHandler.execute(new generalEvent(substory2));
			break;
		}
	}

	@Override
	public void newEvent(Event.eventHandler e) {
		eventHandler = e;
		
	}
}
