<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./header.jsp" %>
<meta charset="UTF-8">
<title>Post Edit</title>
</head>
<body>
<ul>
	<li><a href="board-list.do">Board List</a></li>
	<li><a href="user-list.do">User List</a></li>
	<li><a href="logout.do">Logout</a></li>
</ul>
<br>
<form action="board-edit-process.do" name="board" method="post">
	<table>
		<tr>
			<td>No</td>
			<td>${board.b_idx}</td>
			<input type="hidden" name="edit_b_idx" value=${board.b_idx}>
		</tr>
		<tr>
			<td>Title</td>
			<td><input type="text" name="edit_title" value=${board.b_title}></td>
		</tr>
		<tr>
			<td>Writer</td>
			<td>${board.b_writer}</td>
			<input type="hidden" name="edit_writer" value=${board.b_writer}>
		</tr>
		<tr>
			<td>Date</td>
			<td>${board.b_date}</td>
			<input type="hidden" name="edit_date" value=${board.b_date}>
		</tr>
		<tr>
			<td>Content</td>
			<td><input type="text" name="edit_content" value=${board.b_content}></td>
		</tr>
		<tr>
			<input type="hidden" name="edit_u_idx" value=${board.u_idx}>
			<input type="submit" value="Save">
		</tr>
	</table>
</form>
</body>
</html>