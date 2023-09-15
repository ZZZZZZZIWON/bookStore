package kr.ac.kopo.bookstore.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookstore.dao.OrdersDao;
import kr.ac.kopo.bookstore.model.Detail;
import kr.ac.kopo.bookstore.model.Orders;
import kr.ac.kopo.bookstore.pager.Pager;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersDao dao;
	
	@Override
	public List<Orders> list(Pager pager) {
		int total = dao.total(pager);
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void order(String custid, HashMap<Long, Integer> cart) {
		Orders item = new Orders();
		item.setCustid(custid);
		item.setSaleprice(0L);
		
		dao.add(item);
		
		for (Long bookid : cart.keySet()) {
			Detail detail = new Detail();
			detail.setBookid(bookid);
			detail.setOrderid(item.getOrderid());
			detail.setAmount(0L);
			
			
			dao.addDetail(detail);
		}
	}

}
