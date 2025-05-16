package kr.co.kopo.service;

import java.util.List;

import kr.co.kopo.model.Book;
import kr.co.kopo.pager.Pager;

public interface BookService {

	List<Book> list(Pager pager);

	void add(Book item);

	void update(Book item);

	Book update(Long bookid);

	void delete(Long bookid);

	void dummy();

	void init();

}
