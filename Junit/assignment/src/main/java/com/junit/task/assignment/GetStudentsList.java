package com.junit.task.assignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class GetStudentsList {
	
	
	public GetStudentsList() {
		
	}

	public static List<StudentDetails> getList(String file){
		 
		
		List<StudentDetails> studentsList = new ArrayList<StudentDetails>();
		try { 
			if(file.equals(""))
				throw new FileNotFoundException();
	        FileReader filereader = new FileReader(file); 
	        
	        CSVReader csvReader = new CSVReaderBuilder(filereader)  
	                                  .withSkipLines(1) 
	                                  .build(); 
	        
	        String[] nextRecord; 
	        
	        while ((nextRecord = csvReader.readNext()) != null) { 
	        		studentsList.add(new StudentDetails(Integer.parseInt(nextRecord[1]),nextRecord[0], new SimpleDateFormat("dd/MM/yyyy").parse(nextRecord[2]))); 		
	         } 
		}
	    catch (Exception e) { 
	        return null;
	    } 
		
		
		return studentsList; 
	}
}
