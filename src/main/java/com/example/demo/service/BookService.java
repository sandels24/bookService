package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Service
@Transactional
public class BookService {
	
	@Autowired
	EntityManager manager;
	org.slf4j.Logger logger = LoggerFactory.getLogger(BookService.class);
 
	
	public Book find(String name) {
		Book book = manager.find(Book.class,name);
		return book;
		
	}
	public Book create(String name, String author, String publisheddate) throws EntityExistsException{
		Book book = new Book();
		book.setAuthor(author);
		book.setName(name);
		book.setPublisheddate(publisheddate);
		manager.persist(book);
		return book;
		
	} 
	public Book delete(String name) {
		Book book = manager.find(Book.class,name);
		manager.remove(book);
		return book;
	}
	public List<Book> findAll() {
		@SuppressWarnings("unchecked")
		List<Book> book = manager.createQuery("from Book").getResultList();
		return book;
	} 
}
