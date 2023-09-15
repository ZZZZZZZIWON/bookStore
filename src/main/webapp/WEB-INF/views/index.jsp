<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<style>

</style>
<script>
	const message = "${message}";
	if(message)
		alert(message);
</script>
</head>

<body>
	
	<div class="container">
		<div>
			<h1>폴리북스</h1>
		</div>
		<nav>
			<jsp:include page="nav.jsp"></jsp:include>
		</nav>
		
		<div>
			<ul class="list-group">
				<li class="list-group-item"><a href="book/list">도서관리</a></li>
				<li class="list-group-item"><a href="customer/list">고객관리</a></li>
				<li class="list-group-item"><a href="orders/list">주문관리</a></li>
			</ul>
		</div>
	</div>
</body>
</html>

