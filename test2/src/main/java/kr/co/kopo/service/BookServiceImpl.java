package kr.co.kopo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kopo.dao.BookDao;
import kr.co.kopo.model.Book;
import kr.co.kopo.pager.Pager;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;

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

	@Override
	public void dummy() {
		Long bookid = dao.getLastBookid() +1;	//최근 bookid 호출 +1
		
		List<Book> list = new ArrayList<>();	//새로운 리스트 객체 생성
		
		for( ;bookid < 100; bookid++) {
			Book item = new Book();
			
			//bookid는 mybatis 쿼리문에서 시퀀스를 사용할것임
			item.setBookname("도서명"+ bookid);
			item.setPublisher("출판사" + bookid);
			item.setPrice(bookid.intValue() +1000);
			
			list.add(item);	//새로 생성된 book 리스트 객체에 book을 담음
		}
		
		dao.addDummy(list);
	}

	//초기화 로직
	@Override
	public void init() {
		// TODO Auto-generated method stub
		dao.init();
	}

	@Override
	public List<Book> list(Pager pager) {
		//callByReference 이 값이 컨트롤러를 거쳐서 jsp에서도 그 값을 그대로 보여줌.
		int total = dao.total(pager);
		
		pager.setTotal(total);
		// TODO Auto-generated method stub
		return dao.list(pager);
	}

}
