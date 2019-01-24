package com.junit.task.assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Main {

	
	public static void main(String[] args) throws IOException {
		double maxMarks=0;

		String fileMarks="C:\\\\Users\\\\Sushma.Gollapudi\\\\Junit\\\\assignment\\\\src\\\\main\\\\java\\\\com\\\\junit\\\\task\\\\assignment\\\\file2";
		List<StudentMarks> marksList = GetMarksList.getList(fileMarks);

		Map<Integer,Double> marksMap=MapMarks.mapMarks(marksList,maxMarks);

		String detailsFile="C:\\Users\\Sushma.Gollapudi\\Junit\\assignment\\src\\main\\java\\com\\junit\\task\\assignment\\file1";
		
		List<StudentDetails> studentsList = GetStudentsList.getList(detailsFile);
		
		List<AllDetails> fullList = Concatenate.concatenate(studentsList,marksMap);
		
		List<AllDetails> sortedList=GetSortedDetails.sortMap(fullList);
		
		WriteToFile.writeToFile(sortedList);

	}

}
	

