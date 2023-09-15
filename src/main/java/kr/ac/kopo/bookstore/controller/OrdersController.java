package kr.ac.kopo.bookstore.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.model.Orders;
import kr.ac.kopo.bookstore.pager.Pager;
import kr.ac.kopo.bookstore.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	final String path = "orders/";
	
	@Autowired
	OrdersService service;
	
	@GetMapping("/order")
	String order(@SessionAttribute("member") Customer customer, 
				@SessionAttribute("cart") HashMap<Long, Integer> cart) {
		
		service.order(customer.getCustid(), cart);
		
		return "redirect:list";
	}
	
	@GetMapping("/list")
	String list(Pager pager, Model model) {
		List<Orders> list = service.list(pager);
		
		model.addAttribute("list", list);
		return path + "list";
	}
}
