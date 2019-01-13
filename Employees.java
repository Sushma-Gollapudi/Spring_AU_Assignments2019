package employees;

import java.util.Scanner;


/* This is used to add and get employees basic details and 
 * the function in this throws the age_exception
 * 
 * THis demonstrates:
 * USage of static block
 * Declaration of static and final variables
 */

class Employee {
	
	int id;
	String name;
	int age;
	Address a;

	
	final double basesal=20000;
	static int employee_count;
	
	//Static block
	static {
		System.out.println("\nEmployees basic details added\n");
	}
	
	Employee(){
		System.out.println("\nAdding...");
	}
	
	Employee(int id,String name,int age,Address a) throws Age_exception{
		this.id=id;
		this.name=name;
		try {
			if(age<20)  
			      throw new Age_exception("\nAge not valid");  
			else  
			      this.age=age; 
		}catch(Exception m){System.out.println("Exception: "+m+"\n\n\n Run the program again"); System.exit(0); }  
		
		this.age=age;
		this.a=a;
		employee_count++;
	}
	
	double getsalary() {
		return this.basesal;
	}
	
}


/* This class is used as address template in Employee class
 * This demonstrates constructor overloading*/


class Address {
	private int hno;
	private String area;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pincode;
	
	//Constructor overloading
	
	//constructor with all properties as arguments
	Address(int hno,String area,String street,String city,String state,String country,int pincode) {
		this.hno=hno;
		this.area=area;
		this.street=street;
		this.city=city;
		this.state=state;
		this.country=country;
		this.pincode=pincode;
	}
	
	//constructor without pincode and house no
		Address(String area,String street,String city,String state,String country) {
			this.area=area;
			this.street=street;
			this.city=city;
			this.state=state;
			this.country=country;
		}
		
		int getHno()
		{
			return this.hno;
		}
		
		String getArea() {
			return this.area;
		}
		
		String getStreet() {
			return this.street;
		}
		
		String getCity() {
			return this.city;
		}
		
		String getState() {
			return this.state;
		}
		
		String getCountry() {
			return this.country;
		}
		
		int getPincode()
		{
			return this.pincode;
		}
		
}


/* Class demonstrating the use of custom exceptions
 * A custom exception is created to check for the validity of age*/


class Age_exception extends Exception{

	//parameterless constructor
	public Age_exception() {}
	//Constructor that accepts a message
	public Age_exception(String message)
    {
       super(message);
    }
}


//Demonstration of interfaces

interface Finance {
	
	abstract double salary();
}



/* Devoloper class extends employee class which all basic details 
 * \and it inherits finance interface which has method to calculate salary
 * 
 * This demonstrates:
 * Function Overriding
 */

class Devoloper extends Employee implements Finance{
	
	String project;
	int months_for_project;
	double calculated_salary;
	
	public Devoloper(String project,int no) {
		super();
		System.out.println("Devolopers details added\n");
		this.months_for_project=no;
		this.project=project;
	}
	
	public double salary()
	{
		return basesal*months_for_project;
	}
	
	
	//Function overriding
	@Override
	double getsalary(){
		return salary();
	}

}


/*Manager class extends employee class which all basic details 
 * \and it inherits finance interface which has method to calculate salary
 * 
 * This demonstrates:
 * Function Overriding
 * Function overloading
 */

class Manager extends Employee implements Finance {
	int no_of_employees;
	String project;
	boolean devoloper; // parameter to check if manager too develops code
	
	Manager(String project,int no,boolean dev){
		super();
		System.out.println("Managers details added\n");
		this.no_of_employees=no;
		this.project=project;
		this.devoloper=dev;
	}
	
	//Function overriding
	
	@Override
	double getsalary(){
		return salary();
	}
	public double salary()
	{
		if(devoloper==true) {
			if(no_of_employees>5) {
				return calsal(no_of_employees);
			}
			else {
				return calsal();
			}
		}
		else {
			return basesal*no_of_employees;
		}	
	}
	
	// function overloading

	double calsal() {
		return basesal*2;
	}
	
	double calsal(int no) {
		return basesal*no_of_employees*2;
	}
}




//The main class to input and output details

public class Main {

	public static void main(String[] args) throws Age_exception {
		Scanner in = new Scanner(System.in);
		int c;
		for(;;)
		{
			System.out.println("\nEnter 1 to enter details and 2 to exit:");
			c=in.nextInt();
			switch(c) {
				case 1: {
				int i;
				int id;
				String name;
				int age;
				
				int hno;
				String area;
				String street;
				String city;
				String state;
				String country;
				int pincode;
				
				String project;
				int months_for_project;
				
				int no_of_employees;
				String proj;
				boolean devoloper;
				String dump;
				
				System.out.println("\nEnter the basic details of the employee:");
				System.out.println("id:");
				id=in.nextInt();
				dump=in.nextLine();
				System.out.println("Name:");
				name=in.nextLine();
				System.out.println("Age:");
				age=in.nextInt();
				dump=in.nextLine();
				System.out.println("Enter the address:\n Hno:");
				hno=in.nextInt();
				System.out.println("Area:");
				area=in.nextLine();
				dump=in.nextLine();
				System.out.println("Street:");
				street=in.nextLine();
				System.out.println("City:");
				city=in.nextLine();
				System.out.println("State:");
				state=in.nextLine();
				System.out.println("Country:");
				country=in.nextLine();
				System.out.println("pincode");
				pincode=in.nextInt();
				
		
				Address a=new Address(hno,area,street,city,state,country,pincode);
				Employee e=new Employee(id,name,age,a);
		
				System.out.println("Before getting the salary, lets take more specific information:\n");
				System.out.println("Enter 1 if employee is a devoloper else enter 2 if he is a manager:");
				i=in.nextInt();
				switch(i) {
					case 1: {
						System.out.println("Enter the alloted time for the project in terms of months:");
						months_for_project=in.nextInt();
						dump=in.nextLine();
						System.out.println("Give the project title:");
						project=in.nextLine();
						Devoloper d=new Devoloper(project,months_for_project);
						System.out.println("Salary of this devoloper="+ d.getsalary());
						break;
					}
					case 2: {
						System.out.println("Enter true if he is also a devoloper else give false:");
						devoloper=in.nextBoolean();
						System.out.println("Number of employees under him:");
						months_for_project=in.nextInt();
						dump=in.nextLine();
						System.out.println("Give the project title:");
						proj=in.nextLine();
						Manager m=new Manager(proj,months_for_project,devoloper);
						System.out.println("\nSalary of this manager="+ m.getsalary());
					}
				}
		
				System.out.println("\n\nPresent Employee count:"+ Employee.employee_count);
				break;
				}
				case 2:{
					System.out.println("Thank you!!");
					System.exit(0);
				}
					
			}
		}
		
	}
	
}


