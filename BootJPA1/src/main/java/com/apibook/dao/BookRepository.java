package com.apibook.dao;

import org.springframework.data.repository.CrudRepository;

import com.apibook.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
	public BookRepository findById(int id);
	
}
