package com.example.demo.controllers;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/books")
@CrossOrigin
public class BooksCRUD {

	@Autowired
	private Book book;
	@Autowired
	private BookService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET )
	@ResponseBody
	public Book findOne(@PathVariable("name") String name) {
		book = service.find(name);
	    return book;
	}

	@RequestMapping(value = "/{name}/{author}/{publisheddate}", method = RequestMethod.GET)
	@ResponseBody
	public Book create(@PathVariable("name") String name,@PathVariable("author") String author, @PathVariable("publisheddate") String publisheddate) {
		try{ 
			book = service.create(name,author,publisheddate);
		}catch(EntityExistsException e) {
			return null;
		}
	    return book;
	}
	
	@RequestMapping(value = "delete/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Book delete(@PathVariable("name") String name) {
		book = service.delete(name);
	    return book;
	}
	
}
