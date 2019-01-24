package com.junit.task.assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMarks {

	public MapMarks() {
		
	}

	public static Map<Integer,Double> mapMarks(List<StudentMarks> marksList, double maxMarks){
		Map<Integer,Double> marksMap=new HashMap<Integer, Double>();
		for(StudentMarks student:marksList) {
			if(marksMap.containsKey(student.getStudentId())) {
				Double total= marksMap.get(student.getStudentId())+student.getMarks();
				marksMap.put(student.getStudentId(),total);
				if(marksMap.get(student.getStudentId())>maxMarks) {
					maxMarks=marksMap.get(student.getStudentId());
				}
		  }
			else { 
				marksMap.put(student.getStudentId(),student.getMarks());
			}
	    }
		return CalculatePercentiles.calulatePercentiles(marksMap, maxMarks); 
	}

}
