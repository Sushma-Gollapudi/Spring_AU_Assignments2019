package com.junit.task.assignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class GetMarksList {
	
	public static List<StudentMarks> getList(String file)throws FileNotFoundException{
		
		
		List<StudentMarks> marksList = new ArrayList<StudentMarks>();
		try { 
			if(file.equals(""))
				throw new FileNotFoundException();
		
	        FileReader filereader = new FileReader(file); 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        
	        String[] nextRecord; 
	        
	        while ((nextRecord = csvReader.readNext()) != null) { 
	        		marksList.add(new StudentMarks(Integer.parseInt(nextRecord[0]), nextRecord[1], Integer.parseInt(nextRecord[2]))); 		
	         } 
		}
		
	    catch (Exception e) {  
	        return null;
	    } 
		
		
		return marksList;
	}
}
