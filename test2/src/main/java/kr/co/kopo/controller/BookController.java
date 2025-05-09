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
import kr.co.kopo.service.BookService;

@Controller
@RequestMapping("/book")//book이라는 주소로 들어왔을때의 처리
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/list")	//어떠한 주소로 들어왔을때 무엇을 처리 할 것인가?
	String list(Model model) {
		List<Book> list = service.list();
		
		model.addAttribute("list", list); //model에 담아서 jsp에서 꺼내쓸 수 있도록 함.
		
		model.addAttribute("msg", "hello");	//하나의 예시를 확인하기 위함/ msq라는 명칭에 hello 문자열을 담음
		
		return "/book/list";	// book에 있는 list라는 명칭의 jsp로 반환
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
