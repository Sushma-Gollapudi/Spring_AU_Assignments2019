package org.accolite.java.EmployeeManagement.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.accolite.java.EmployeeManagement.dto.EmployeeDto;
import org.accolite.java.EmployeeManagement.services.EmployeeService;
import org.accolite.java.EmployeeManagement.dto.EmployeeDto;

@Path("emplist")
public class EmployeeController {
	static EmployeeService service=new EmployeeService();
	
	    @GET
	    @Path("all")
	    @Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeDto> getIt() {
	    return service.getAll();
	}
	    
	    @GET
	    @Path("{Id}")
	    @Produces(MediaType.APPLICATION_JSON)
	public EmployeeDto empid(@PathParam("Id") int id) {
	    return service.getById(id);
	    }
	    
	    @POST
		@Path("update")
		@Consumes({"application/xml", "application/json"})
	    public EmployeeDto getupdates(EmployeeDto e) {
	    	return service.update(e);
		}

}
	    
	    
	    
	    
	

		
	   


