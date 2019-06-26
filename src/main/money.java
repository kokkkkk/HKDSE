package main;

import java.util.Random;

public class money {
	Random rand = new Random();
	
	Basic.initial initial = new Basic.initial();
	
	int moneyValue = rand.nextInt(200)+1;
	int addAmount;
	boolean moneyUseup = false;

	public money(){
		
		addAmount = moneyValue;
		
	}
	
	public void addMoney(){
		
		moneyValue = moneyValue + addAmount;
		
	}
	
	public void lostMoney(int times){
		
		for(int i = 0;i<times;i++){
			
			moneyValue -= 100;
		}
		
	}
	
	public int getMoney(){
		
		return moneyValue;
		
	}
	
	public boolean getMoneyuseup(){
		
		if(moneyValue<=0){
			
			moneyUseup = true;
		}else{
			
			moneyUseup = false;
		}
		
		return moneyUseup;
	}
}
