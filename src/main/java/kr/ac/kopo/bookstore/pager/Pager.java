package kr.ac.kopo.bookstore.pager;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page = 1;
	
	private int perPage = 10;
	private float total;
	private int perGroup = 3;
	
	private int search;
	private String keyword;
	
	
	public String getQuery() {
		String queryString = "";
		if(search  > 0) {
			queryString += "&search=" + search + "&keyword=" + keyword;
		}
		return queryString;
	}
	
	public int getSearch() {
		return search;
	}
	public void setSearch(int search) {
		this.search = search;
	}
	public String getKeyword() {
		if(search < 1 ) 
			keyword = "";
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getPerGroup() {
		return perGroup;
	}
	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}
	
	public int getLast() {
		return (int) Math.ceil(total / perPage);
	}
	
	public int getPrev() {
		return page <= perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup + 1;
	}
	
	public int getNext() {
		int next = (((page - 1) / perGroup) + 1) * perGroup + 1;
		int last = getLast();
		
		return next < last ? next: last;
	}	
	
	public List<Integer> getList() {
		List<Integer> list = new ArrayList<Integer>();
		int startPage = (((page - 1) / perGroup) + 0) * perGroup + 1; // 현재 속해있는 그룹의 첫번째 page값
		
		for(int i= startPage ; i <= (startPage + perGroup) && i <= getLast(); i++) {
			list.add(i);
		}
		if(list.isEmpty())
			list.add(1);
		
		return list; 
	}
}
