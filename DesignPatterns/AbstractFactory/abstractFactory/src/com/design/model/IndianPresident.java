package com.design.model;

public class IndianPresident extends President{
	private String name;
	private int tenure;
	private int noOfBillsPassed;
	
	public IndianPresident(String name, int tenure, int noOfBillsPassed) {
		this.name = name;
		this.tenure = tenure;
		this.noOfBillsPassed = noOfBillsPassed;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getTenure() {
		return this.tenure;
	}

	@Override
	public int noOfBIllsPassed() {
		return this.noOfBillsPassed;
	}
	
	
	
}
