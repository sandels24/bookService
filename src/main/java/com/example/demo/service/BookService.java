package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Service
@Transactional
public class BookService {
	
	@Autowired
	EntityManager manager;
	
	public Book find(String name) {
		Book book = manager.find(Book.class,name);
		return book;
		
	}
	public Book create(String name, String author) {
		Book book = new Book();
		book.setAuthor(author);
		book.setName(name);
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
