package kr.ac.kopo.bookstore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookstore.model.Customer;
import kr.ac.kopo.bookstore.pager.Pager;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SqlSession sql;

	@Override
	public int total(Pager pager) {
		return sql.selectOne("customer.total", pager);
	}
	
	@Override
	public List<Customer> list(Pager pager) {
		return sql.selectList("customer.list", pager);	
	}

	@Override
	public void add(Customer item) {
		sql.insert("customer.add", item);
	}

	@Override
	public Customer item(String custid) {
		return sql.selectOne("customer.item", custid);
	}

	@Override
	public void update(Customer item) {
		sql.update("customer.update", item);
	}

	@Override
	public void delete(String custid) {
		sql.delete("customer.delete", custid);
	}
	
	@Override
	public Customer login(Customer item) {
		
		return sql.selectOne("customer.login", item);
	}


}
