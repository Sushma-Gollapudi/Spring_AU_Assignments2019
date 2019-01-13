/* Devoloper class extends employee class which all basic details 
 * \and it inherits finance interface which has method to calculate salary
 * 
 * This demonstrates:
 * Function Overriding
 */

package employees;

public class Devoloper extends Employee implements Finance{
	
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
