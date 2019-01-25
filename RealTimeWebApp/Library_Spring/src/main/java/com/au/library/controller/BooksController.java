package com.au.library.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.au.library.model.Book;

import com.au.library.repository.BookDAO;


@RestController
public class BooksController {
	
	@Autowired
	BookDAO bookDAO;
	@RequestMapping(value="/books",method=RequestMethod.GET,produces="application/json")
	public List<Book> getAll() {
//		List<Book> books=new ArrayList<Book>();
//		books.add(new Book("1","a","a",2D,"a"));
//		return books;
		return bookDAO.all();
	}
	@RequestMapping(value="/book/{bookId}/get",method=RequestMethod.GET)
	public String getOne(@PathVariable(value="bookId") String bookId) {
		
		return bookDAO.getId(bookId);
	}
	
	@RequestMapping(value="/books",method=RequestMethod.POST)
	public Book create(@RequestBody Book bookToCreate) {
		return bookDAO.create(bookToCreate);
	}
	
//	@Autowired
//	YourBookDAO yourBookDAO;
	
	@RequestMapping(value="/getyourbooks",method=RequestMethod.GET,produces="application/json")
	public List<Book> getAllYourBooks() {
		return bookDAO.allYourBooks();
	}
		
	@RequestMapping(value="/postyourbooks",method=RequestMethod.POST)
	public Book createYourBooks(@RequestBody Book bookToCreate) {
		return bookDAO.createYourBooks(bookToCreate);
	}
}
