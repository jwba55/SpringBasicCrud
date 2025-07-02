package kr.co.kopo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kopo.dao.BookDao;
import kr.co.kopo.model.Book;
import kr.co.kopo.model.Recently;
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

	@Transactional
	@Override
	public void dummy() {
		//최근에 저장된 더미 내용을 저장하기위해 필요
		Long recentlyId = dao.saveRecently();
		
		Long bookid = dao.getLastBookid() +1;	//최근 bookid 호출 +1
		
		List<Book> list = new ArrayList<>();	//새로운 리스트 객체 생성
		
		for(int a= 0 ;a < 100; a++) {
			Book item = new Book();
			
			item.setBookid(bookid);
			item.setBookname("도서명"+ bookid);
			item.setPublisher("출판사" + bookid);
			item.setPrice(bookid.intValue() +1000);
			item.setRecentlyId(recentlyId);
			bookid++;
			
			list.add(item);	//새로 생성된 book 리스트 객체에 book을 담음
		}
		
		dao.addDummy(list);
		
		bookid = dao.getLastBookid() +1;
		dao.updateSEQ(bookid);
	}

	//롤백 로직
	@Override
	public void init() {
		Long recentlyId = dao.selectRecently();
		dao.init(recentlyId);
	}
	
	//초기화 로직
	//페이지네이션 없이 전체코드를 불러오는 기능이 필요함
	/*
	 * @Override public void init() {
	 * Pager pager = new Pager();
	 * pager.setPerPage(0);
	 * 
	 * List<Book> list = dao.list(pager);
	 * for(Book item : list) {
	 * 		dao.delete(item.getBookid());
	 * }
	 * 
	 * }
	 */

	@Override
	public List<Book> list(Pager pager) {
		//callByReference 이 값이 컨트롤러를 거쳐서 jsp에서도 그 값을 그대로 보여줌.
		int total = dao.total(pager);
		
		pager.setTotal(total);
		// TODO Auto-generated method stub
		return dao.list(pager);
	}

}
