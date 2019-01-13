package employees;

import java.util.Scanner;

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
						System.out.println("Enter the alloted time for the project:");
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
