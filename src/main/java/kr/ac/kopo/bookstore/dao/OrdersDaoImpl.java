package kr.ac.kopo.bookstore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookstore.model.Detail;
import kr.ac.kopo.bookstore.model.Orders;
import kr.ac.kopo.bookstore.pager.Pager;

@Repository
public class OrdersDaoImpl implements OrdersDao{

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Orders> list(Pager pager) {
		return sql.selectList("orders.list", pager);
	}

	@Override
	public int total(Pager pager) {
		return sql.selectOne("orders.total", pager);
	}

	@Override
	public void add(Orders item) {
		sql.insert("orders.add", item);
	}

	@Override
	public void addDetail(Detail detail) {
		sql.insert("orders.add_detail", detail);
	}

}
