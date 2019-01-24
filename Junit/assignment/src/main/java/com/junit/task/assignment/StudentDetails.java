package com.junit.task.assignment;

import java.util.Date;

public class StudentDetails {
	private int studentId;
	private String studentName;
	private Date DOB;
	
	public StudentDetails(int studentId, String studentName, Date dOB) {
		this.studentId = studentId;
		this.studentName = studentName;
		DOB = dOB;
	}

	public int getStudentId() {
		return studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public Date getDOB() {
		return DOB;
	}

	
	
	
}
