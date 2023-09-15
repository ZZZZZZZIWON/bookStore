<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<style type="text/css">
</style>
</head>
<body>
	<div class="container">
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		<div>
			<h3>고객 목록</h3>
		</div>
		<div>
			<form>
				<div class="row mb-2">
				<div class="col-6"></div>
					<div class="col">
						<select name="search" class="form-select form-select-sm">
							<option value="0">검색 항목을 선택하세요</option>				
							<option value="1" ${pager.search == 1 ? "selected" : ""}>고객번호</option>
							<option value="2" ${pager.search == 2 ? "selected" : ""}>이름</option>
							<option value="3" ${pager.search == 3 ? "selected" : ""}>주소</option>
							<option value="4" ${pager.search == 4 ? "selected" : ""}>전화번호</option>
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
						<th>고객번호</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>주소</th>
						<th>전화번호</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.custid}</td>
							<td>${item.passwd}</td>
							<td>${item.name}</td>
							<td>${item.address}</td>
							<td>${item.phone}</td>
							<td>
								<a href="delete/${item.custid}" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a> 
								<a href="update/${item.custid}" class="btn btn-warning btn-sm"><i class="bi bi-wrench"></i></a>
								</td>
						</tr>
					</c:forEach>

					<c:if test="${list.size() < 1 }">
						<tr>
							<td colspan="6">검색 된 고객이 없습니다</td>
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
			<a href="add" class="btn btn-primary btn-sm">등록</a> 
			<a href=".."	class="btn btn-success btn-sm">이전</a>
		</div>
	</div>
</body>
</html>
