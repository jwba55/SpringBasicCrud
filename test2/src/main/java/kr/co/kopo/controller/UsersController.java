package kr.co.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kopo.model.Customer;
import kr.co.kopo.service.CustomerService;

@Controller
@RequestMapping("/users")
public class UsersController {
	final static String path = "users/";

	//이런 기본들을 확실히 몸에 익혀 놓고 여기에 새로운 기술들을 적용시켜서 익히도록 하자!
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	String list(Model model) {
		List<Customer> list = customerService.list();
		
		model.addAttribute("list", list);
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Customer item) {
		customerService.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{custId}")
	String update(@PathVariable Long custId, Model model) {
		Customer customer = customerService.item(custId);
		
		model.addAttribute("item", customer);
		
		return path + "update";
	}
	
	@PostMapping("/update/{custId}")
	String update(@PathVariable Long custId, Customer customer) {
		customer.setCustId(custId);
		
		customerService.update(customer);
		
		return "redirect:../list";	//pathvariable을 사용했기 때문에 주소가 하나 더 안쪽에 있어서 하나 빠져나와야함. 그래서 ..을 사용해서 pathvariable을 빠져나와줌.
	}
	
	@GetMapping("delete/{custId}")
	String delete(@PathVariable Long custId) {
		customerService.delete(custId);
		
		return "redirect:../list";
	}
}
