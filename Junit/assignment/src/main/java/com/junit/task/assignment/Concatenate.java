package com.junit.task.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Concatenate {
	static List<AllDetails> concatenate(List<StudentDetails> studentsList, Map<Integer, Double> marksMap) {
		List<AllDetails> fullList = new ArrayList();
		for(StudentDetails student:studentsList) {
			fullList.add(new AllDetails(student.getStudentId(),student.getStudentName(),student.getDOB(),marksMap.get(student.getStudentId())));
		}
		return fullList;
	}
}
