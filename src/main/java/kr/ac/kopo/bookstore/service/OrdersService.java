package kr.ac.kopo.bookstore.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.kopo.bookstore.model.Orders;
import kr.ac.kopo.bookstore.pager.Pager;

public interface OrdersService {

	List<Orders> list(Pager pager);

	void order(String custid, HashMap<Long, Integer> cart);

}
