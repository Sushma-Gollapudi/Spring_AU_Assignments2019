package com.design.adaptor;

public class Test {
	public static void main(String[] args) {
		BaseCalAdaptor base = new BaseCalAdaptorImpl();
		Calories c100 = getCalories(base,100);
		Calories c80 = getCalories(base,80);
		Calories c50 = getCalories(base,50);
		System.out.println("c100 calories using Class Adapter="+c100.getCalories());
		System.out.println("c80 calories using Class Adapter="+c80.getCalories());
		System.out.println("c50 calories using Class Adapter="+c50.getCalories());
	}
	
	private static Calories getCalories(BaseCalAdaptor baseCal, int i) {
		switch (i){
		case 100: return baseCal.get100Calories();
		case 80: return baseCal.get80Calories();
		case 50: return baseCal.get50Calories();
		default: return baseCal.get100Calories();
		}
	}
}
