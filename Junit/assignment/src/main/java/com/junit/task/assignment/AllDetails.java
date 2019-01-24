package com.junit.task.assignment;

import java.util.Date;

public class AllDetails {
	private int studentId;
	private String studentName;
	private Date DOB;
	private Double percentile;
	public AllDetails(int studentId, String studentName, Date dOB, Double percentile) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		DOB = dOB;
		this.percentile = percentile;
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
	public Double getPercentile() {
		return percentile;
	}
}
