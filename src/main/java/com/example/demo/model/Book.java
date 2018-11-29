package com.example.demo.model;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Entity
public class Book {

	@Id
	private String name;
	private String author;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
