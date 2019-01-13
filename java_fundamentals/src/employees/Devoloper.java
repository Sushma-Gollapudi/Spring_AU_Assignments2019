package employees;

public class Devoloper extends Employee implements Finance{
	
	String project;
	int months_for_project;
	double calculated_salary;
	
	public Devoloper(String project,int no) {
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
