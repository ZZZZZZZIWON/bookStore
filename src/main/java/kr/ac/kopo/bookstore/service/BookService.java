package kr.ac.kopo.bookstore.service;

import java.util.List;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.pager.Pager;

public interface BookService {

	List<Book> list(Pager pager);

	void add(Book item);

	Book item(Long bookid);

	void update(Book item);

	void delete(Long bookid);

	void dummy();   

	void init();
	
	

}
