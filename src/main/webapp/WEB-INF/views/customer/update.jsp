<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<script src="/kopo/resources/js/password_check.js"></script>
</head>
<body>
	<div class="container">
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		<div>
			<h3>고객정보 변경</h3>
		</div>
		<form method="post">
			<div>
				<div>
					<label>아이디 : </label> ${item.custid}
				</div>
				<div>
					<label>비밀번호 : </label> 
					<input id="password_check" type="password" name="passwd" value="${item.passwd}">
					<button type="button" class="password_check" data-for="passwd">확인</button>
				</div>
				<div>
					<label>이름 : </label> 
					<input type="text" name="name" value="${item.name}">
				</div>
				<div>
					<label>주소 : </label> 
					<input type="text" name="address" value="${item.address}">
				</div>
				<div>
					<label>전화번호 : </label> 
					<input type="text" name="phone" value="${item.phone}">
				</div>
				<div>
					<button>변경</button>
					<a href="list"><button type="button">목록</button></a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
