package kr.co.kopo.dao;

import java.util.List;

import kr.co.kopo.model.Book;
import kr.co.kopo.model.Recently;
import kr.co.kopo.pager.Pager;

public interface BookDao {

	void add(Book item);

	Book update(Long bookid);

	void update(Book item);

	void delete(Long bookid);

	Long getLastBookid();

	void addDummy(List<Book> bookList);

	void init(Long recentlyId);

	List<Book> list(Pager pager);

	int total(Pager pager);

	Long saveRecently();

	Long selectRecently();

	void updateSEQ(Long bookid);

}
