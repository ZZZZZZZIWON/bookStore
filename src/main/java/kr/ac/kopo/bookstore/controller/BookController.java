package kr.ac.kopo.bookstore.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.pager.Pager;
import kr.ac.kopo.bookstore.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	final String path = "book/";

	@Autowired
	BookService service;

	@ResponseBody
	@GetMapping("/add_cart/{bookid}")
	String addCart(@PathVariable Long bookid,
			@SessionAttribute(name = "cart", required = false) HashMap<Long, Integer> cart, 
			HttpSession session) {
		if (cart == null) {
			cart = new HashMap<Long, Integer>();
			session.setAttribute("cart", cart);
		}

		Integer amount = cart.get(bookid);
		if (amount == null)
			amount = 0;

		cart.put(bookid, amount + 1);

		System.out.println("장바구니 담기: " + bookid + ", " + cart.get(bookid) + "권");

		return "OK";
	}

	@GetMapping("/dummy")
	String dummy() {
		service.dummy();

		return "redirect:list";
	}

	@GetMapping("/init")
	String init() {
		service.init();

		return "redirect:list";
	}

	@GetMapping("/list")
	String list(Model model, Pager pager) {
		List<Book> list = service.list(pager);

		model.addAttribute("list", list);
		return path + "list";
	}

	@GetMapping("/add")
	String add() {
		return path + "add";
	}

	@PostMapping("/add")
	String add(@ModelAttribute Book item) {
		service.add(item);

		return "redirect:list";
	}

	@GetMapping("/update/{bookid}")
	String update(@PathVariable Long bookid, Model model) {
		Book item = service.item(bookid);

		model.addAttribute("item", item);

		return path + "update";

	}

	@PostMapping("/update/{bookid}")
	String update(@PathVariable Long bookid, Book item) {

		item.setBookid(bookid);
		service.update(item);

		return "redirect../list";
	}

	@GetMapping("delete/{bookid}")
	String delete(@PathVariable Long bookid) {
		service.delete(bookid);
		return "redirect:../list";
	}

}
