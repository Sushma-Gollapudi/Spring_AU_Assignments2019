package employees;

public class Employee {
	
	int id;
	String name;
	int age;
	Address a;

	
	final double basesal=20000;
	static int employee_count;
	
	//Static block
	static {
		System.out.println("\nAdding new employee");
	}
	
	Employee(){
		
	}
	
	Employee(int id,String name,int age,Address a) throws Age_exception{
		this.id=id;
		this.name=name;
		try {
			if(age<20)  
			      throw new Age_exception("Age not valid");  
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
