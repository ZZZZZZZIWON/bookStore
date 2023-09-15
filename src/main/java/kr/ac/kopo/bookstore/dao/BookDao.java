package kr.ac.kopo.bookstore.dao;

import java.util.List;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.pager.Pager;

public interface BookDao {

	int total(Pager pager);

	List<Book> list(Pager pager);

	void add(Book item);

	Book item(Long bookid);

	void update(Book item);

	void delete(Long bookid);
	
	
}
