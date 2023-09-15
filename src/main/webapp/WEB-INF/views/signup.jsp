<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>

<script src="/resources/js/password_check.js"></script>
<script src="/resources/js/check_id.js"></script>
<script src="/resources/js/validate_form.js"></script>

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
					<button type="button" class="form-control" id="check_id">(비동기) 중복확인</button>
					<button type="button" class="form-control" id="check_id_sync">(동기) 중복확인</button>
				</div>
				<div>
					<label>비밀번호 : </label> 
					<input type="password" name="passwd" id="passwd">
					<button type="button" class="password_check" data-msg="Hello1" data-for="passwd">확인</button>
				</div>

				<div>
					<label>비밀번호 확인 : </label> 
					<input type="password" name="passwd_confirm" id="passwd_confirm">
					<button type="button" class="password_check" data-msg="Hello2" data-for="passwd_confirm">확인</button>
				</div>

				<div>
					<label>이름 : </label> <input type="text" name="name">
				</div>
				<div>
					<label>주소 : </label> <input type="text" name="address">
				</div>
				<div>
					<label>전화번호 : </label> <input type="text" name="phone">
				</div>
				<div>
					<button type="button" id="signup" class="btn btn-success">등록</button>
					<a href="/"><button type="button" class="btn btn-primary">처음으로</button></a>
				</div>
			</div>
		</form>
	</div>
	<script>
		new ValidateForm(
			{
				selector:"#signup",
				tags: [
				{tag: "custid", msg:"아이디는 필수 입니다"},
				{tag: "custid", msg:"아이디 중복 검사를 해 주세요", condition:"checkId"},
				{tag: "passwd", msg:"비밀번호는 필수 입니다"},
				{tag: "passwd_confirm", msg:"비밀번호는 필수 입니다"},
				{tag: "passwd_confirm", msg:"비밀번호와 비밀번호 확인이 일치하지 않습니다", eq:"passwd"},
				{tag: "name", msg:"이름는 필수 입니다"}			
			]	
			});
	</script>	
</body>
</html>