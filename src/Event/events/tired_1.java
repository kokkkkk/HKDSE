package Event.events;

import Basic.initial;

public class tired_1 implements Event.eventInterface{

	@Override
	public String getname() {

		return "tired_1";
	}

	@Override
	public int getid() {
		
		return 1;
	}

	@Override
	public void result(int i) {
		switch(i){
		case 0:
			initial.tired = false;
			initial.energyValue += 10;
			break;
		case 1:
			break;
		}
		
	}
	
	
}
