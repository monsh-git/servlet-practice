<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post View</title>
</head>
<body>
<ul>
	<li><a href="board-list.do">Board List</a></li>
	<li><a href="user-list.do">User List</a></li>
	<li><a href="logout.do">Logout</a></li>
</ul>
<br>
<ul>
	<li><a href="board-edit.do?b_idx=${board.b_idx}">Edit this post</a></li>
	<li><a href="board-delete.do?b_idx=${board.b_idx}">Delete this post</a></li>
	<li><a href="board-reply.do?b_idx=${board.b_idx}">Reply this post</a></li>
</ul>
<table>
	<tr>
		<td>No</td>
		<td>${board.b_idx}</td>
	</tr>
	<tr>
		<td>Title</td>
		<td>${board.b_title}</td>
	</tr>
	<tr>
		<td>Writer</td>
		<td>${board.b_writer}</td>
	</tr>
	<tr>
		<td>Date</td>
		<td>${board.b_date}</td>
	</tr>
	<tr>
		<td>Content</td>
		<td>${board.b_content}</td>
	</tr>
</table>

<!-- Comments -->
<table>
	<c:forEach items="${c_list}" var="comment">
	<tr>
		<td>${comment.u_idx}</td>
		<td>${comment.c_content}</td>
		<td>${comment.c_date}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>