<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		<div>
			<h3>도서 등록</h3>
		</div>
		<form method="post">
			<div>
				<div>
					<label>도서명 : </label> <input type="text" name="bookname">
				</div>
				<div>
					<label>출판사 : </label> <input type="text" name="publisher">
				</div>
				<div>
					<label>가격 : </label> <input type="number" name="price">
				</div>
				<div>
					<button>등록</button>
					<a href="list"><button type="button">목록</button></a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>