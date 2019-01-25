//package com.au.library.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.au.library.model.YourBooks;
//import com.au.library.repository.YourBookDAO;
//
//@RestController
//public class YourBooksController {
//	@Autowired
//	YourBookDAO yourBookDAO;
//	
//	@RequestMapping(value="/getyourbooks",method=RequestMethod.GET,produces="application/json")
//	public List<YourBooks> getAll() {
//		return yourBookDAO.all();
//	}
//		
//	@RequestMapping(value="/postyourbooks",method=RequestMethod.POST)
//	public YourBooks create(@RequestBody YourBooks bookToCreate) {
//		return yourBookDAO.create(bookToCreate);
//	}
//}
