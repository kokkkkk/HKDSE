package main;

import java.util.Random;

import Basic.initial;

public class money {
	Random rand = new Random();
	
	int moneyValue = initial.moneyValue;
	int addAmount;
	boolean moneyUseup = initial.moneyUseup;

	public money(){
		
		addAmount = moneyValue;
		initial.moneyValue = moneyValue;
		
	}
	
	public void addMoney(){
		
		moneyValue = initial.moneyValue;
		
		moneyValue = moneyValue + addAmount;
		
		initial.moneyValue = moneyValue;
	}
	
	public void lostMoney(int times){
		
		moneyValue = initial.moneyValue;
				
		for(int i = 0;i<times;i++){
			
			moneyValue -= 100;
		}
		
		initial.moneyValue = moneyValue;
	}
	
	public int getMoney(){
		
		moneyValue = initial.moneyValue;
		return moneyValue;
		
	}
	
	public boolean getMoneyuseup(){
		
		moneyUseup = initial.moneyUseup;
		
		if(moneyValue<=0){
			
			moneyUseup = true;
		}else{
			
			moneyUseup = false;
		}
		
		initial.moneyUseup = moneyUseup;
		
		return moneyUseup;
	}
}
