<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:if test="${sessionScope.member == null }">
<div class="my-2">				
	<a href="/login" class="btn btn-sm btn-primary">로그인</a>
	<a href="/signup" class="btn btn-sm btn-secondary">회원가입</a>
	<a href="/cart" class="btn btn-sm btn-secondary">장바구니</a>
</div>		
</c:if>		
<c:if test="${sessionScope.member != null }">
<div class="my-2">
	<a href="/logout" class="btn btn-sm btn-primary">로그아웃</a>
	<a href="/cart" class="btn btn-sm btn-secondary">장바구니</a>
</div>
</c:if>		