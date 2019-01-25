package com.design.model;

public class Test {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		President india = com.design.model.PresidentFactory.getPresident(new IndianFactory("Kovindh",5,67));
		President british = com.design.model.PresidentFactory.getPresident(new BritainFactory("ABC",5,78));
		President us = com.design.model.PresidentFactory.getPresident(new UsFactory("Trump",4,147));
		System.out.println("AbstractFactory Indian President::"+india);
		System.out.println("AbstractFactory Britain President::"+british);
		System.out.println("AbstractFactory US President::"+us);
	}
}
