package kr.ac.kopo.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.service.CustomerService;

@Controller
public class RootController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/cart")
	String cart() {
		return "cart";
	}
	
	
	@GetMapping("/")
	String index(HttpSession session, Model model) {
		
		String message = (String) session.getAttribute("message");
		
		if(message != null) {
			model.addAttribute("message", message);
			session.removeAttribute("message");
		}
		return "index";
	}
	
	@GetMapping("/login")
	String login() {
		return "login";
	}

	@PostMapping("/login")
	String login(Customer item, HttpSession session) {
		Boolean result = customerService.login(item);
		if(result) {
			session.setAttribute("member", item);
			session.setAttribute("message", "로그인 성공");
		} else {
			session.setAttribute("message", "로그인 실패");
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/signup")
	String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	String signup(Customer item) {
		customerService.add(item);
		return "redirect:.";
	}
	
	@ResponseBody
	@GetMapping("/checkId/{custId}")
	String checkId(@PathVariable String custId) {
		if(customerService.item(custId) == null) 
			return "OK";
		else return "FAIL";
	}
}
