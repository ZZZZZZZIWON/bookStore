package kr.ac.kopo.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.pager.Pager;
import kr.ac.kopo.bookstore.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	final String path = "customer/";
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/list")
	String list(Pager pager, Model model) {
		
		List<Customer> list = service.list(pager);
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Customer item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{custid}")
	String update(@PathVariable String custid, Model model) {
		
		Customer item = service.item(custid);
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{custid}")
	String update(@PathVariable String custid, Customer item) {
		item.setCustid(custid);
		service.update(item);

		return "redirect:../list";
		
	}
	
	@GetMapping("/delete/{custid}") 
	String delete(@PathVariable String custid) {

		service.delete(custid);
		
		return "redirect:../list";
	}
	
	
}
