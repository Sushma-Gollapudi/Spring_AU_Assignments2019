
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		JDBCTemplateDAO jdbc =  applicationContext.getBean(JDBCTemplateDAO.class);
		
		Student student = new Student();
		student.setAge(29);
		student.setName("Joy");
		student.setMajor("IS");
		
		
		Student student12 = new Student();
		student12.setAge(21);
		student12.setName("Spoorthi");
		student12.setMajor("IT");
		
		Student student11 = new Student();
		student11.setAge(28);
		student11.setName("San");
		student11.setMajor("IS");
		
		Student student13 = new Student();
		student13.setAge(38);
		student13.setName("Han");
		student13.setMajor("CS");
		
		Student student14 = new Student();
		student14.setAge(28);
		student14.setName("Fagy");
		student14.setMajor("IT");
		
		//jdbc.saveStudent(student);
		
		
		jdbc.saveStudentUsingPreparedStatement(student);
		jdbc.saveStudentUsingPreparedStatement(student11);
		jdbc.saveStudentUsingPreparedStatement(student12);
		jdbc.saveStudentUsingPreparedStatement(student13);
		jdbc.saveStudentUsingPreparedStatement(student14);
		
		
		System.out.println("List using Row Mapper:\n");
		List<Student> list1=jdbc.getAllEmployeesRowMapper();
		for(Student student2:list1)  
		    {
		    	
			System.out.println(student2.getName()+"   "+student2.getAge()+"   "+student2.getMajor());
	     }
		
		

		Student newStudent = (Student) applicationContext.getBean("newFactoryStudent");
        System.out.println("\n\nUsing factory method: \n ");
        System.out.println(newStudent.getName()+"   "+newStudent.getAge()+"   "+newStudent.getMajor());
		  
		/*
		 * System.out.println("List using Result extractor:\n"); List<Student>
		 * list=jdbc.getAllEmployeesByResultExtractor(); for(Student student1:list) {
		 * System.out.println(student1.getName()+"   "+student1.getAge()+"   "+student1.
		 * getMajor());
		 * 
		 * }
		 */
	
}
}
