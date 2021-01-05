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
		<th>No</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${list}" var="item">
	<tr>
		<td>${item.b_idx}</td>
		<td><a href="board-detail.do?b_idx=${item.b_idx}">${item.b_title}</a></td>
		<td>${item.b_writer}</td>
		<td>${item.b_date}</td>
	</tr>
	</c:forEach>
	<tr style="height:50px;">
		<td style="border:none;">
			<a href="board-insert.do" style="width:70%; font-weight:700; background-color:#818181; color:#fff;">글 쓰기</a>
		</td>
	</tr>
</table>
</body>
</html>