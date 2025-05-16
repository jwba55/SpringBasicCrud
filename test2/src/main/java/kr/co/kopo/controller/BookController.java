package kr.co.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kopo.model.Book;
import kr.co.kopo.pager.Pager;
import kr.co.kopo.service.BookService;

@Controller
@RequestMapping("/book")//book이라는 주소로 들어왔을때의 처리
public class BookController {
	
	@Autowired
	BookService service;
	
	//객체를 넘겨주거나 갖고 오기만 하면 되지 객체 안의 필드가 몇개가 되었든 상관이 없음. 구조를 전달할 뿐임.
	//일반적인 crud에서는 그저 값이 지나다니는 통로에 불과함.
	
	@GetMapping("/list")	//어떠한 주소로 들어왔을때 무엇을 처리 할 것인가?
	String list(Model model, Pager pager) {		//pager 객체를 새로 생성하고 사용자가 보낸 파라미터에서 get과 set을 이용해서 값을 service에 넘겨줌.
		//int page같은 것들을 사용해 전달할 수도 있지만 유지보수의 효율성을 위해 pager를 따로 만들어서 가변성을 높임.
		
		List<Book> list = service.list(pager);	//리스트에 담긴 인자 값인 pager의 값도 같이 넘겨줌.
		
		model.addAttribute("list", list); //model에 담아서 jsp에서 꺼내쓸 수 있도록 함.
		
		model.addAttribute("msg", "hello");	//하나의 예시를 확인하기 위함/ msq라는 명칭에 hello 문자열을 담음
		
		return "/book/list";	// book에 있는 list라는 명칭의 jsp로 반환
	}
	
	//대량등록
	@GetMapping("/dummy")
	String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	//초기화
	@GetMapping("/init")
	String init() {
		service.init();
			
		return "redirect:list";	
	}
	
	@GetMapping("/add")
	String add() {
		
		return "/book/add";
	}
	
	@PostMapping("/add")
	String add(Book item) {	//사용자가 보내는 데이터를 넘겨 받기 위한 모델
		service.add(item);
		
		return "redirect:list";	//주소값을 match시켜주기위함, redirect를 사용하지않으면 주소가 mismatch되어서 새로고침 시에 재동록될수있음.
		//redirect 시에 300번대의 응답으로 값없이 list에 대한 request 요청을 새로 만들어서 보냄.
		//redirect는 해당 주소로 보냄.
	}
	
	@GetMapping("/update/{bookid}")
	String update(@PathVariable Long bookid, Model model) {
		Book item = service.update(bookid);
		
		model.addAttribute("item", item);
		
		return "/book/update";
	}
	
	@PostMapping("/update/{bookid}")
	String update(@PathVariable Long bookid, Book item) {
		item.setBookid(bookid);
		
		service.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{bookid}")
	String delete(@PathVariable Long bookid) {
		
		service.delete(bookid);
		
		return "redirect:../list";
	}
}
