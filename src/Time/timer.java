package Time;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class timer {
	Timer timer;
	Basic.soundEffect se = new Basic.soundEffect();
	
	ScheduledExecutorService ses = null;
	
	public void run(long delay,long time,int i){
	    ses = Executors.newSingleThreadScheduledExecutor();
		
		ses.scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {
				switch(i){
				case 1:
					se.setFile("bgm.wav");
					se.play();		
					break;
				}
				
			}
			
		},delay,time,TimeUnit.MINUTES);
	}
	
	public void shutdown(){
		ses.shutdownNow();
	}
	
}
