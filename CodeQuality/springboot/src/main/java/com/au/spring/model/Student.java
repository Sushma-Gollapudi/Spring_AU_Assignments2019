package com.au.spring.model;

public class Student {
	private int studentId;
	private String studentName;
	
	public static final String STUDENT_NAME="name";
	
	/**
	 * Gets the student id.
	 *
	 * @return the student id
	 */
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
}


