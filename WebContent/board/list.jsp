<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<style>
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
</style>
<body>
<h1>Board</h1>
<ul>
	<li><a href="user-list.do">User List</a></li>
	<li><a href="logout.do">Logout</a></li>
</ul>
<br>
<table>
	<tr>
		<td colspan="4">Total Posts : ${pagination.boardCount}</td>
	<tr>
		<th>No</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${list}" var="item" varStatus="status">
	<tr>
		<td>${item.b_idx}</td>
		<td><a href="board-detail.do?b_idx=${item.b_idx}">${item.b_title}</a></td>
		<td>${item.b_writer}</td>
		<td>${item.b_date}</td>
	</tr>
	</c:forEach>
</table>
<!-- Pagination -->
<div>
	<ul>
		 <c:choose>
			<c:when test="${ pagination.prevPage lt 5 }">
				<li class="pageBtn" style="display:none;">
					<span>◀</span>
				</li>
			</c:when>
			<c:when test="${ pagination.prevPage ge 5}">
				<li class="pageBtn" >
					<a href="board-list.do?page=${pagination.prevPage}">
						◀
					</a>
				</li>
			</c:when>
		</c:choose> 
		<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
				<c:choose>
					<c:when test="${ pagination.page eq i }">
						
						<li class="pageBtn" style="background-color:#ededed;">
							<span>${i}</span>
						</li>
					</c:when>
					<c:when test="${ pagination.page ne i }">
						<li class="pageBtn" >
							<a href="board-list.do?page=${i}">${i}</a>
						</li>
					</c:when>
				</c:choose>
		</c:forEach>
		 <c:choose>
			<c:when test="${ pagination.nextPage lt pagination.lastPage }">
				<li class="pageBtn" style="">
					<a href="board-list.do?page=${pagination.nextPage}">▶</a>
				</li>
			</c:when>
			<c:when test="${ pagination.nextPage ge pagination.lastPage}">
				<li class="pageBtn" style="display:none;">
					<a href="board-list.do?page=${pagination.nextPage}">▶</a>
				</li>
			</c:when>
		</c:choose> 
		<%--  <li>
			<a href="user-list.do?page=${pagination.nextPage}">▶</a>
		</li>  --%>
	</ul>
</div>
<!-- board-insert -->
<div style="height:50px;">
	<div style="border:none;">
		<a href="board-insert.do" style="width:70%; font-weight:700; background-color:#818181; color:#fff;">Write a post</a>
	</div>
</div>
</body>
</html>