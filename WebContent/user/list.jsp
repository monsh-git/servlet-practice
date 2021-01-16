<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./header.jsp" %>
<meta charset="UTF-8">
<title>User List</title>
</head>
<!-- <style>
	h1 {
		text-align:center;
	}
	table {
		border-collapse:collapse;
		margin:40px auto;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
	a {
		text-decoration:none;
		color:#000;
		font-weight:700;
	}
	ul {
		width:600px;
		height:50px;
		margin:10px auto;
	}
	li {
		list-style:none;
		width:auto;
		line-height:50px;
		border:1px solid #ededed;
		float:left;
		text-align:center;
		margin:0 5px;
		border-radius:5px;
	}
	.pageBtn {
		list-style:none;
		width:50px;
		line-height:50px;
		border:1px solid #ededed;
		float:left;
		text-align:center;
		margin:0 5px;
		border-radius:5px;
	}
</style> -->
<body>
<div class="container">
	<h1>User List</h1>
	<div class="col-md-10"></div>
	<div class="col-md-1"><a class="btn btn-primary" href="board-list.do">Board List</a></div>
	<div class="col-md-1"><a class="btn btn-primary" href="logout.do">Logout</a></div>
	<hr>
	<table class="table">
		<tr>
			<td colspan="3">Total Use : ${pagination.userCount}</td>
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${list}" var="item" varStatus="status">
		 <tr>
			<td><a href="user-detail.do?u_idx=${item.u_idx}">${item.rownum}</a></td>
			<td>${item.u_id}</td>
			<td>${item.u_name}</td>
	     <tr>
		</c:forEach>
	</table>
<!-- 아래부터 pagination -->
	<div>
		<ul>
			 <c:choose>
				<c:when test="${ pagination.prevPage lt 5 }">
					<span class="btn btn-default col-md-1" style="display:none;">◀</span>
				</c:when>
				<c:when test="${ pagination.prevPage ge 5}">
					<a class="btn btn-default col-md-1" href="user-list.do?page=${pagination.prevPage}">
							◀
					</a>
				</c:when>
			</c:choose> 
			<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
					<c:choose>
						<c:when test="${ pagination.page eq i }">
							<span class="btn btn-default col-md-1">${i}</span>
						</c:when>
						<c:when test="${ pagination.page ne i }">
							<a class="btn btn-default col-md-1" href="user-list.do?page=${i}">${i}</a>
						</c:when>
					</c:choose>
			</c:forEach>
			 <c:choose>
				<c:when test="${ pagination.nextPage lt pagination.lastPage }">
					<a class="btn btn-default col-md-1" style="" href="user-list.do?page=${pagination.nextPage}">▶</a>
				</c:when>
				<c:when test="${ pagination.nextPage ge pagination.lastPage}">
					<a class="btn btn-default col-md-1" style="display:none;" href="user-list.do?page=${pagination.nextPage}">▶</a>
				</c:when>
			</c:choose> 
			<%--  <li>
				<a href="user-list.do?page=${pagination.nextPage}">▶</a>
			</li>  --%>
		</ul>
	</div>
</div>
</body>
</html>