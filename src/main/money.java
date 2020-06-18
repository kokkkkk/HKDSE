package main;

import java.util.Random;

import Basic.initial;

public class money {
	Random rand = new Random();
	
	int moneyValue = rand.nextInt(200)+1;
	int addAmount;
	boolean moneyUseup = initial.moneyUseup;

	public money(){
		
		addAmount = moneyValue;
		
	}
	
	public void addMoney(){
		
		moneyValue = moneyValue + addAmount;
		
		initial.moneyValue = moneyValue;
	}
	
	public void lostMoney(int times){
		
		for(int i = 0;i<times;i++){
			
			moneyValue -= 100;
		}
		
		initial.moneyValue = moneyValue;
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
		
		initial.moneyUseup = moneyUseup;
		
		return moneyUseup;
	}
}
