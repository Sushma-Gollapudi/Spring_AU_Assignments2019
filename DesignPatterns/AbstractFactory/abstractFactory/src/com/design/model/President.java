package com.design.model;

public abstract class President {
	public abstract String getName();
    public abstract int getTenure();
    public abstract int noOfBIllsPassed();
     
    @Override
    public String toString(){
        return "NAME= "+this.getName()+", TENURE="+this.getTenure()+", PARTY NAME="+this.noOfBIllsPassed();
    }
}
