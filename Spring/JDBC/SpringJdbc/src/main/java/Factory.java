
public class Factory {
	
	 public static Student createusingFactoryMehod(String type)
	    {
	        if (type.contentEquals("newFactoryStudent"))
	        {
	            Student student = new Student();
	             
	            student.setName("Bert");

	            student.setAge(34);
	            student.setMajor("IS");
	             
	            return student;
	        }
	        else
	        {
	            throw new IllegalArgumentException("Unknown product");
	        }
	    }

}
