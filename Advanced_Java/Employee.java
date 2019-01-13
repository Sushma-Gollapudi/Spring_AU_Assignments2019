package Employees_Companies;


public class Employee {
	
	private int id;
	private String name;
	private int age;

	Employee(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
		
	}
	
	void setID(int id) {
		this.id=id;
	}
	
	void setName(String name) {
		this.name=name;
	}
	
	void setAge(int age) {
		this.age=age;
	}
	
	int getID() {
		return this.id;
	}
	
	String getName() {
		return this.name;
	}
	
	int getAge() {
		return this.age;
	}
	
}
