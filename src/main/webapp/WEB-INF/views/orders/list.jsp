<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<style type="text/css">
</style>
<script src="/resources/js/cart.js"></script>
</head>
<body>
	<div class="container">
		
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		<div>
			<h3>주문 목록</h3>
		</div>
		<div>
			<form>
				<div class="row mb-2">
				<div class="col-6"></div>
					<div class="col">
						<select name="search" class="form-select form-select-sm">
							<option value="0">검색 항목을 선택하세요</option>				
							<option value="1" ${pager.search == 1 ? "selected" : ""}>주문번호</option>
							<option value="2" ${pager.search == 2 ? "selected" : ""}>고객번호</option>
						</select>
					</div>
					<div class="col">
						<input type="text" name="keyword" class="form-control form-control-sm" value="${pager.keyword}">
					</div>
					<div class="d-grid col-1">
						<button class="btn btn-sm btn-primary">검색</button>
					</div>`
				</div>
			</form>
		</div>
		<div>
			<table border="1" class="table table-scriped table-hover">
				<thead class="table-dark">
					<tr>
						<th>주문번호</th>
						<th>고객번호</th>
						<th>주문금액</th>
						<th>주문일자</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.orderid}</td>
							<td>${item.custid}</td>
							<td>${item.saleprice}</td>
							<td>${item.orderdate}</td>
							<td><a href="delete/${item.orderid}" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a> 
							</td>
						</tr>
					</c:forEach>

					<c:if test="${list.size() < 1 }">
						<tr>
							<td colspan="5">검색 된 주문 내역이 없습니다</td>
						</tr>
					</c:if>
				</tbody>

				<tfoot>
					<tr>
						<td colspan="5">
							<ul class="pagination justify-content-center mt-3">
								<li class="page-item"><a href="?page=1${pager.query}" class="page-link">처음</a></li>
								<li class="page-item"><a href="?page=${pager.prev}${pager.query}" class="page-link">이전</a></li>
								<c:forEach var="page" items="${pager.list}">
									<li class="page-item"><a href="?page=${page}${pager.query}" class="page-link ${page == pager.page ? 'active' : ''}">${page}</a></li>
								</c:forEach>
								<li class="page-item"><a href="?page=${pager.next}${pager.query}" class="page-link">다음</a></li>
								<li class="page-item"><a href="?page=${pager.last}${pager.query}" class="page-link">마지막</a></li>
							</ul>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div class="mb-5">
			<a href=".."	class="btn btn-success btn-sm">이전</a>
		</div>
	</div>
</body>
</html>
