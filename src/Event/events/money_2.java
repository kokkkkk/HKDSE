package Event.events;

import Event.eventInterface;

public class money_2 implements eventInterface {

	@Override
	public String getname() {
		
		return "money_2";
	}

	@Override
	public int getid() {
	
		return 8;
	}

	@Override
	public void result(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pictureName() {
		return "system.png";
	}

}
