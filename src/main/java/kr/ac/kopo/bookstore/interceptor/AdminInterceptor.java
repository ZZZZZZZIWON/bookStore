package kr.ac.kopo.bookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.bookstore.model.Customer;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		Customer member= (Customer) session.getAttribute("member");
		if(member != null) {
			if(!member.getCustid().equals("admin")) {				
				response.sendRedirect("/");
				return false;
			}
			return true;
		}
		response.sendRedirect("/login");
		return false;
	}
}
