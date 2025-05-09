package kr.co.kopo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kopo.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	ArrayList<Book> list = new ArrayList<Book>();	//영속성이 없음. 데이터를 생성한 프로그램이 종료되면 데이터가 사라짐.
	
	@Override
	public List<Book> list() {

		return list;	//이것이 데이터베이스에서 가져 오는 것인지 아니면 더미 데이터인지 알 수 없음
	}

	@Override
	public void add(Book item) {
		item.setBookid((long) list.size() + 1L);		//DB에서의 시퀀스처럼 작동하게 설계. 리스트에 담긴 객체의 수를 가지고와서 +1 해줌으로 도서를 새로 등록될 때마다 bookid가 증가됨.
		
		list.add(item);			//생성된 item을 list에 담아줌
	}

	@Override
	public Book update(Long bookid) {
		for(Book item : list) {
			if(item.getBookid() == bookid) {
				return item;
			}
		}
		return null;
	}

	@Override
	public void update(Book item) {
			
		for(Book book : list) {
			if(item.getBookid() == book.getBookid()) {
				book.setBookname(item.getBookname());
				book.setPrice(item.getPrice());
				book.setPublisher(item.getPublisher());
				return;
			}
		}
	}

	@Override
	public void delete(Long bookid) {
		for(Book item : list) {
			if(item.getBookid() == bookid) {
				list.remove(item);
				return;
			}
		}
	}
	

}
