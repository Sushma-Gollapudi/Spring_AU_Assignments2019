package org.accolite.java.EmployeeManagement.services;

import java.util.LinkedList;
import java.util.List;
import org.accolite.java.EmployeeManagement.dto.EmployeeDto;



public class EmployeeService {
	
	static List<EmployeeDto> EmpList =new LinkedList<>();
	
	public EmployeeService(){
		EmpList.add(new EmployeeDto(1,"Sushma",20));
		EmpList.add(new EmployeeDto(2,"Joy",23));
		EmpList.add(new EmployeeDto(3,"Hannah",24));
		EmpList.add(new EmployeeDto(4,"Tom",27));
	}
	
	public EmployeeDto getById(int id) {
		for(EmployeeDto p:EmpList) {
			if(p.getId()==id)
			{
				return p;
			}
		}
		return null;
		
	}
	
	public List<EmployeeDto> getAll() {
		return EmpList;
	}
	
	public EmployeeDto update(EmployeeDto e) {
		for(EmployeeDto p:EmpList) {
			if(p.getId()==e.getId()) {
				p.setAge(e.getAge());
				p.setName(e.getName());
				return p;
			}
		}
		return null;
	}

	public List<EmployeeDto> insert(EmployeeDto e) {
		EmpList.add(e);
		return getAll();
	}
	
	void delete(int id) {
		for(EmployeeDto p:EmpList) {
			if(p.getId()==id) {
				EmpList.remove(p);
			}
		}
	}
}
