<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<script src="/resources/js/password_check.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<h3>회원 가입</h3>
		</div>
		<form method="post" name="signup_form">
			<div class="form-control">
				<div class="form-group">
					<label class="form-label">아이디 : </label> 
					<input class="form-control" type="text" name="custid">
					
				</div>
				<div class="form-group">
					<label>비밀번호 : </label> 
					<input class="form-control" type="password" name="passwd" id="passwd">
					<button type="button" class="password_check form-control btn" data-msg="Hello1" data-for="passwd">확인</button>
				</div>


				<div>
					<button  id="signup" class="btn btn-success">로그인</button>
					<a href="/"><button type="button" class="btn btn-primary">처음으로</button></a>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>