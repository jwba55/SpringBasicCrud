package kr.co.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import kr.co.kopo.model.Book;
import kr.co.kopo.model.Recently;
import kr.co.kopo.pager.Pager;

//오라클과 연결한 버전
@Primary	//bookDaoImple이 두개인 셈이라 우선권 부여해줌
@Repository
public class BookDaoOracle implements BookDao{
	
	//mybatis 불러오기
	@Autowired
	SqlSession sql;		//원래 ibatis에서 개발된 것을 최대한 수용했기에 ibati에서 mybatis로 넘어갔어도 작동함.
	
	@Override
	public List<Book> list(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectList("book.list", pager);		//namespace.id 형태임. mybatis에서 book이라는 namespace를 가진 mapper파일을 찾고 그 중에 id값이 list인 녀석을 찾게 되어있음.
	}

	@Override
	public void add(Book item) {
		
		sql.insert("book.add", item);
	}

	@Override
	public Book update(Long bookid) {
		// TODO Auto-generated method stub
		return sql.selectOne("book.item",bookid);
	}

	@Override
	public void update(Book item) {
		// TODO Auto-generated method stub
		sql.update("book.update", item);
	}

	@Override
	public void delete(Long bookid) {
		// TODO Auto-generated method stub
		sql.delete("book.delete", bookid);
	}

	@Override
	public Long getLastBookid() {
		// TODO Auto-generated method stub
		return sql.selectOne("book.getLastBookid");
	}

	//대량등록(반복문을 통해 mybatis에서 한번에 대량등록하는 법)
	@Override
	public void addDummy(List<Book> bookList) {
	
		sql.insert("book.addDummy", bookList);
	}

	//초기화 수정중
	@Override
	public void init(Long recentlyId) {
		sql.delete("book.init", recentlyId);
	}

	@Override
	public int total(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectOne("book.total", pager);
	}

	@Override
	public Long saveRecently() {
		Recently recently = new Recently();
		sql.insert("book.saveRecentlyId", recently); // insert 시 selectKey로 id 세팅

	    return recently.getRecentlyId();
	}

	@Override
	public Long selectRecently() {
		
		return (Long)sql.selectOne("book.selectRecently");
	}

	@Override
	public void updateSEQ(Long bookid) {
		
		sql.update("book.bookSeqUpdate", bookid);
	}

}
