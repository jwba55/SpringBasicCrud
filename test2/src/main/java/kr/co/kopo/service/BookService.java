package kr.co.kopo.service;

import java.util.List;

import kr.co.kopo.model.Book;

public interface BookService {

	List<Book> list();

	void add(Book item);

	void update(Book item);

	Book update(Long bookid);

	void delete(Long bookid);

}
