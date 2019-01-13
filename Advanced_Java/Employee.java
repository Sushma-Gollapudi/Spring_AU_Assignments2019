package Employees_Companies;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;


class Company {
	String name;
	Address a;
	List<Employee> Employee_tree;
	
	Company(String name,Address a,List<Employee> set){
		this.name=name;
		this.a=a;
		this.Employee_tree=set;
	}
}


class Address {

	private String street;
	private String city;
	private String state;


	Address(String street,String city,String state) {

		this.street=street;
		this.city=city;
		this.state=state;

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
		
		void setStreet(String st) {
			this.street=st;
		}
		
		void setCity(String ct) {
			this.city=ct;
		}
		
		void setState(String st) {
			this.state=st;
		}
		

}



class Employee implements Comparable<Employee>{
	
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


public static void main(String[] args) {
		
		HashMap<String, Company> Company_map=new HashMap<>();
		//TreeSet<Employee> Emp_tree =new TreeSet<>();
		List<Employee> Emp_tree =new LinkedList<>();
		
		Scanner in=new Scanner(System.in);
		
		Emp_tree.add(new Employee(1,"Sushma",21));
		Emp_tree.add(new Employee(2,"Chay",25));
		Emp_tree.add(new Employee(3,"Joy",20));
		Emp_tree.add(new Employee(4,"Alen",31));
		Emp_tree.add(new Employee(5,"Hannah",41));
		Emp_tree.add(new Employee(6,"Anor",26));
		Emp_tree.add(new Employee(7,"Priq",23));
		Emp_tree.add(new Employee(8,"San",33));
		Emp_tree.add(new Employee(9,"Scarlet",39));
		Emp_tree.add(new Employee(10,"Vile",27));
		Emp_tree.add(new Employee(11,"Garg",25));
		Emp_tree.add(new Employee(12,"Nijule",30));
		Emp_tree.add(new Employee(13,"Sarah",29));
		Emp_tree.add(new Employee(14,"wesdh",22));
		
		List<Employee> Banglore_Emp_tree =new LinkedList<>();
		Banglore_Emp_tree.add(new Employee(4,"Anor",26));
		Banglore_Emp_tree.add(new Employee(6,"Priq",23));
		Banglore_Emp_tree.add(new Employee(9,"San",33));
		
		Company_map.put("Bangalore",new Company("Accolite",new Address("Bellandhur","Bangalore","karnataka"),Banglore_Emp_tree));
		
		List<Employee> Mysore_Emp_tree =new LinkedList<>();
		Mysore_Emp_tree.add(new Employee(13,"Garg",25));
		Mysore_Emp_tree.add(new Employee(7,"Nijule",30));
		Mysore_Emp_tree.add(new Employee(2,"Sarah",29));
		Mysore_Emp_tree.add(new Employee(14,"wesdh",22));
		
		Company_map.put("Mysore",new Company("Compiler Tree",new Address("Manasagangothri","Mysore","karnataka"),Mysore_Emp_tree));
		
		List<Employee> Delhi_Emp_tree =new LinkedList<>();
		Delhi_Emp_tree.add(new Employee(8,"Chay",25));
		Delhi_Emp_tree.add(new Employee(11,"Joy",20));
		Delhi_Emp_tree.add(new Employee(1,"Alen",31));
		Delhi_Emp_tree.add(new Employee(12,"Hannah",41));
		Company_map.put("Delhi",new Company("DCompiler",new Address("Gandhi Nagar","Delhi_","Delhi_"),Delhi_Emp_tree));
	
		int c;
		for(;;)
		{
			System.out.println("\n\nEnter:\n1. Print all Employees\n 2.Get Employees in ascending order according to their age\n 3.Get Employees in descending order according to their age"
					+ "\n 4.Get Employees in ascending order according to their id\n 5.Get Employees in ascending order according to their name"
					+ "\n 6.Get Employees whose age is less than 30\n7.Get the list of employees working in same location(Banglore/Mysore/Delhi)\n8.Exit\n");
			c=in.nextInt();
			switch(c){
				case 1:getemployees(Emp_tree);break;
				case 2:AscSortEmployeesByAge(Emp_tree);break;
				case 3:DescSortEmployeesByAge(Emp_tree);break;
				case 4:SortEmployeesById(Emp_tree);break;
				case 5:SortEmployeesByName(Emp_tree);break;
				case 6:EmployeesAgeLessThan30(Emp_tree);break;
				case 7:{
					String dump=in.nextLine();
					System.out.println("Enter the location(Banglore/Mysore/Delhi):");
					String l=in.nextLine();
					if(!(l.equals("Banglore"))&&!(l.equals("Mysore"))&&!(l.equals("Delhi")))
					{
						System.out.println("Location not found\n");
						break;
					}
					Company_Employees(l,Company_map);
					break;
				}
				case 8:System.exit(0);
			}
		}
	}



	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//Function to get the list of all employees
	static void getemployees(List<Employee> emp_tree){

		for(Employee p:emp_tree) {
			System.out.println(p.getID()+","+p.getName()+","+p.getAge());
		}
	}
	
	
	//Function to sort Employees in ascending order according to their age
	static void AscSortEmployeesByAge(List<Employee> emp_tree) {
		TreeSet<Employee> sorted = new TreeSet<Employee>((p1,p2) -> (p1.getAge()>p2.getAge()?1:-1));
		for(Employee p:emp_tree) {
				sorted.add(p);
			}
		System.out.println("\n\nEmployees sorted in ascending order by age:\n");
		for(Employee p:sorted) {
			System.out.println(p.getID()+","+p.getName()+","+p.getAge());
		}
	}
	
	//Function to sort Employees in descending order according to their age
		static void DescSortEmployeesByAge(List<Employee> emp_tree) {
			TreeSet<Employee> sorted = new TreeSet<Employee>((p1,p2) -> (p2.getAge()>p1.getAge()?1:-1));
			for(Employee p:emp_tree) {
				sorted.add(p);
			}
			System.out.println("\n\nEmployees sorted in descending order by age:\n");
			for(Employee p:sorted) {
				System.out.println(p.getID()+","+p.getName()+","+p.getAge());
			}
		}
	
	
	//Function to sort Employees according to their ID
		static void SortEmployeesById(List<Employee> emp_tree) {
			TreeSet<Employee> sorted = new TreeSet<Employee>((p1,p2) -> (p1.getID()<p1.getID()?1:-1));
			for(Employee p:emp_tree) {
				sorted.add(p);
			}
			System.out.println("\n\nEmployees sorted in ascending order by ID:\n");
			for(Employee p:sorted) {
				System.out.println(p.getID()+","+p.getName()+","+p.getAge());
			}
		}
		
	//Function to sort Employees according to their name
		static void SortEmployeesByName(List<Employee> emp_tree) {
			TreeSet<Employee> sorted = new TreeSet<Employee>((p1,p2) -> p1.getName().compareTo(p2.getName()));
			for(Employee p:emp_tree) {
				sorted.add(p);
			}
			System.out.println("\n\nEmployees sorted in ascending order by Name:\n");
			for(Employee p:sorted) {
				System.out.println(p.getID()+","+p.getName()+","+p.getAge());
			}
		}
			
	//Function to get all employees whose age is less than 30
	static void EmployeesAgeLessThan30(List<Employee> emp_tree) {
		System.out.println("Employees whose age is less than 30:\n");
		for(Employee p:emp_tree) {
			if(p.getAge()<30)
				System.out.println(p.getID()+","+p.getName()+","+p.getAge());
		}
			
		}
			
	//Function to get the list of employees belonging to each
	static void Company_Employees(String loc,HashMap<String, Company> Company_map) {
		System.out.println("Employess of location "+loc +" are:\n");
		/*for(String c:map.values()) {
			System.out.println(c);
		}*/
		for(Employee p:Company_map.get(loc).Employee_tree) {
				System.out.println(p.getID()+","+p.getName()+","+p.getAge());
		}
	}
		
}

