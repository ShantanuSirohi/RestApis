package com.apibook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apibook.dao.BookRepository;
import com.apibook.entities.Book;


@Service
public class BookServices {
//	private static List<Book>list=new ArrayList<>() ;
//	static {
//		list.add(new Book(1,"Java Complete Reference","ABC",999.99));
//		list.add(new Book(2,"C++ References","DEF",214.99));
//		list.add(new Book(3,"C/C# References","GHI",514.99));
//		list.add(new Book(4,"References to Python","JKL",114.99));
//		list.add(new Book(5,"Reference to Java","ABC",114.99));
//	}
	
	@Autowired
	private BookRepository bookRepository;
	
	//getAllBooks
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	//getBookById
	public Book getBookById(int id){
		Book book=null;
		try {
			//book=list.stream().filter(e->e.getId()==id).findFirst().get();	
			book=(Book) this.bookRepository.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
	}
	
	//addTheBook
	public Book addBook(Book b) {
		Book resultBook=bookRepository.save(b);
		return resultBook;
	}
	
	
	
	
	//delete book handler
	public void deleteBook(int id){
//		try {
//		list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
		bookRepository.deleteById(id);
	}

	
	//updatebook handler
	public void updateBook(Book book, int id) {
//		list=list.stream().map(b->{
//			if(b.getId()==id) {
//				b.setName(book.getName());
//				b.setAutor(book.getAutor());
//				b.setPrice(book.getPrice());
//			}
//			return b;
//		}).collect(Collectors.toList());
			book.setId(id);
			bookRepository.save(book);
		}

	
}
