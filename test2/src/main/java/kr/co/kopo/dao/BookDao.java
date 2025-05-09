package kr.co.kopo.dao;

import java.util.List;

import kr.co.kopo.model.Book;

public interface BookDao {

	List<Book> list();

	void add(Book item);

	Book update(Long bookid);

	void update(Book item);

	void delete(Long bookid);

}
