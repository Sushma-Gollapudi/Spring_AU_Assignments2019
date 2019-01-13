/*Manager class extends employee class which all basic details 
 * \and it inherits finance interface which has method to calculate salary
 * 
 * This demonstrates:
 * Function Overriding
 * Function overloading
 */

package employees;

public class Manager extends Employee implements Finance {
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
