package kr.ac.kopo.bookstore.model;

import java.util.Date;

public class Orders {

	private Long orderid;
	private String custid;
	private Long saleprice;
	private Date orderdate;

	
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderId(Long orderId) {
		this.orderid = orderId;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public Long getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(Long saleprice) {
		this.saleprice = saleprice;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
}
