package com.design.model;

public class PresidentFactory {

	public static President getPresident(PresidentAbstractFactory factory){
		return factory.setPresident();
	}
}
