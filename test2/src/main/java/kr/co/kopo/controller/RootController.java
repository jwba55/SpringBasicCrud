package kr.co.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

	@GetMapping("/")
	String index() {
		return "index";		//webapp/web-inf/views에 있는 index 반환
	}
}
