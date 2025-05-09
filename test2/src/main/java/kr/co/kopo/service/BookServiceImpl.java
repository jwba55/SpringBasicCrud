package kr.co.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kopo.dao.BookDao;
import kr.co.kopo.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;
	
	@Override
	public List<Book> list() {
		return dao.list();
	}

	@Override
	public void add(Book item) {

		dao.add(item);
	}

	@Override
	public Book update(Long bookid) {
		return dao.update(bookid);
	}

	@Override
	public void update(Book item) {

		dao.update(item);
	}

	@Override
	public void delete(Long bookid) {

		dao.delete(bookid);
	}

}
