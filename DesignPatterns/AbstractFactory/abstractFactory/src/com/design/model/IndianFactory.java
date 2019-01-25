package com.design.model;

;

public class IndianFactory implements PresidentAbstractFactory {

	private String name;
	private int tenure;
	private int noOfBillsPassed;
	
	public IndianFactory(String name, int tenure, int noOfBillsPassed) {
		this.name = name;
		this.tenure = tenure;
		this.noOfBillsPassed = noOfBillsPassed;
	}
	
	
	@Override
	public President setPresident() {
		return new IndianPresident(name, tenure, noOfBillsPassed);
	}

}
