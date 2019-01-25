package com.design.adaptor;

public class BaseCalAdaptorImpl extends BaseCal implements BaseCalAdaptor{


	@Override
	public Calories get100Calories() {
		return getCalories();
	}

	@Override
	public Calories get80Calories() {
		Calories cal=getCalories();
		return updateCal(cal,10);
	}

	@Override
	public Calories get50Calories() {
		Calories cal=getCalories();
		return updateCal(cal,5);
	}
	
	private Calories updateCal(Calories v, int i) {
		return new Calories(v.getCalories()+i);
	}

}
