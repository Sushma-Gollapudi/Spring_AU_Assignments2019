package com.junit.task.assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class WriteToFile {

	public WriteToFile() {
	
	}

	static void writeToFile(List<AllDetails> sortedList) throws IOException {
		Calendar calendar = Calendar.getInstance();

			String filename="C:\\Users\\Sushma.Gollapudi\\Junit\\assignment\\src\\main\\java\\com\\junit\\task\\assignment\\output";
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			for(AllDetails student:sortedList) {
				calendar.setTime(student.getDOB());
				writer.write(Integer.toString(student.getStudentId())+","+student.getStudentName()+","+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR)+","+student.getPercentile()+"\n");
			}
			writer.close();
		
	}
} 
