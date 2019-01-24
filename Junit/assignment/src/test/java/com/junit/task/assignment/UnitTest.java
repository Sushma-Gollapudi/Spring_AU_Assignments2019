package com.junit.task.assignment;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;




public class UnitTest {
	
		public GetMarksList getMarksList;
		public GetSortedDetails getSortedDetails;
		public GetStudentsList getStudentsList;
		public Main main;
		public MapMarks mapMarks;
		public Concatenate concatenate;
		public CalculatePercentiles calculatePercentiles;
		
		@BeforeClass
		public static void testMain1() throws IOException {
			Main.main(null);
			System.out.println("Main started");
			new GetMarksList();
			new GetSortedDetails();
			new GetStudentsList();
			new MapMarks();
			new Concatenate();
			new CalculatePercentiles();
			new WriteToFile();
			new Main();
		}
		
		@Before
		public void before() {
			System.out.println("Testing Method");
		}
		
		@After
		public void after() {
			System.out.println("Method Tested");
		}
		
		@AfterClass
		public static void testMain2() throws IOException {
			Main.main(null);
			System.out.println("Main Ended");
		}
		
		
		@Test(expected=IllegalArgumentException.class)
		public void testDivByZero() {
			Map<Integer,Double> marksMap=new HashMap<Integer, Double>();
			marksMap.put(1,56.98);
			marksMap.put(3,(double) 87);
			marksMap.put(4,89.65);
			marksMap.put(5,89.65);
			marksMap.put(8,100.00);
			marksMap.put(6,90.68);
			Map<Integer,Double> marks=CalculatePercentiles.calulatePercentiles(marksMap, 0.0);
			assertEquals(0,marks.size());
		}
		
		@Test(expected=Exception.class)
		public void testFileExistance1() throws FileNotFoundException {
			List<StudentMarks> marks=GetMarksList.getList("");
			assertEquals(0,marks.size());
		}

		
		@Test
		public void testGetMarksList() throws FileNotFoundException {
			String testFile="C:\\Users\\Sushma.Gollapudi\\Junit\\assignment\\src\\test\\java\\com\\junit\\task\\assignment\\testfile1";
			List<StudentMarks> marksList=getMarksList.getList(testFile);
			assertEquals(6,marksList.size());
			assertEquals(1001,marksList.get(0).getStudentId());
			assertEquals("Hibernate",marksList.get(0).getCourse());
			assertEquals(90,marksList.get(0).getMarks(),0.0001);
			assertEquals(1001,marksList.get(1).getStudentId());
			assertEquals(1004,marksList.get(2).getStudentId());
			assertEquals(1005,marksList.get(4).getStudentId());
			assertEquals(1004,marksList.get(3).getStudentId());
			assertEquals(1005,marksList.get(5).getStudentId());
		}
		
		
		@Test(expected=Exception.class)
		public void testFileExistance2() throws FileNotFoundException {
			List<StudentDetails> students=getStudentsList.getList("");
			assertEquals(0,students.size());
		}
		
		@Test
		public void testGetStudentList() {
			String testFile="C:\\Users\\Sushma.Gollapudi\\Junit\\assignment\\src\\test\\java\\com\\junit\\task\\assignment\\testfile2";
			List<StudentDetails> studentsList=getStudentsList.getList(testFile);
			assertEquals(3,studentsList.size());
			assertEquals(1002,studentsList.get(0).getStudentId());
			assertEquals("rahul",studentsList.get(0).getStudentName());
			//assertEquals("28/08/2008",studentsList.get(0).getDOB());
			assertEquals(1003,studentsList.get(1).getStudentId());
			assertEquals(1004,studentsList.get(2).getStudentId());
		}
		
		@Test
		public void testGetSortedList() throws ParseException {
			List<AllDetails> students=new  ArrayList();

			students.add(new AllDetails(1,"s1",new SimpleDateFormat("dd/MM/yyyy").parse("01/07/1998"),96.97)); 
			students.add(new AllDetails(5,"s2",new SimpleDateFormat("dd/MM/yyyy").parse("04/12/1997"),85.68)); 
			students.add(new AllDetails(3,"s3",new SimpleDateFormat("dd/MM/yyyy").parse("21/02/1998"),56.76)); 
			students.add(new AllDetails(6,"s4",new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2012"),100.00)); 
			students.add(new AllDetails(8,"s5",new SimpleDateFormat("dd/MM/yyyy").parse("31/10/2008"),56.76));
			students.add(new AllDetails(4,"s6",new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2011"),100.00)); 

			List<AllDetails> sortedList=getSortedDetails.sortMap(students);
			assertEquals(6,sortedList.size());
			assertEquals(4,sortedList.get(0).getStudentId()); 
			assertEquals(6,sortedList.get(1).getStudentId());
			assertEquals(1,sortedList.get(2).getStudentId());
			assertEquals(5,sortedList.get(3).getStudentId());
			assertEquals(3,sortedList.get(4).getStudentId());
			assertEquals(8,sortedList.get(5).getStudentId());
		}
		
		
		
		@Test
		public void testMapMarks() {
			List<StudentMarks> students=new  ArrayList();
			students.add(new StudentMarks(1,"c1",98)); 
			students.add(new StudentMarks(2,"c2",78)); 
			students.add(new StudentMarks(3,"c3",76)); 
			students.add(new StudentMarks(1,"c4",47)); 
			students.add(new StudentMarks(2,"c5",65));
			students.add(new StudentMarks(3,"c6",79)); 
			double max=0;
			Map<Integer,Double> marksMap=MapMarks.mapMarks(students,max);
			assertEquals(3,marksMap.size());
		}
		
		@Test
		public void testConcatenate() {
			List<StudentDetails> students=new  ArrayList();
			try {
			students.add(new StudentDetails(1,"s1",new SimpleDateFormat("dd/MM/yyyy").parse("01/07/1998"))); 
			students.add(new StudentDetails(5,"s2",new SimpleDateFormat("dd/MM/yyyy").parse("04/12/1997"))); 
			students.add(new StudentDetails(3,"s3",new SimpleDateFormat("dd/MM/yyyy").parse("21/02/1998"))); 
			students.add(new StudentDetails(6,"s4",new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2000"))); 
			students.add(new StudentDetails(8,"s5",new SimpleDateFormat("dd/MM/yyyy").parse("31/10/2008")));
			students.add(new StudentDetails(4,"s6",new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2011"))); 
			}
			catch (ParseException e) {
				
				e.printStackTrace();
			} 
			
			Map<Integer,Double> percentileMap=new HashMap<Integer, Double>();
			percentileMap.put(1,56.98);
			percentileMap.put(3,(double) 87);
			percentileMap.put(4,89.65);
			percentileMap.put(5,89.65);
			percentileMap.put(8,100.00);
			percentileMap.put(6,90.68);
			
			List<AllDetails> student=concatenate.concatenate(students, percentileMap);
			assertEquals(6,student.size());
			assertEquals(1,student.get(0).getStudentId());
			assertEquals("s1",student.get(0).getStudentName());
			//assertEquals(1,student.get(0).getStudentId());
		}
		
		
		
}
