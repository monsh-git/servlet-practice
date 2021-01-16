<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./header.jsp" %>
<meta charset="UTF-8">
<title>Post Reply</title>
</head>
<body>
<h2>Post</h2>
<form action="board-reply-process.do" name="board" method="post">
	<p> Title : <input type="text" name="b_title"></p>
	<p> Content : <input type="text" name="b_content"></p>
	<p> Date : <input type="text" name="b_date"></p>
	<input type="hidden" name="b_writer" value=${sessionScope.user.u_id}>
	<input type="hidden" name="u_idx" value=${sessionScope.user.u_idx}>
	<input type="hidden" name="b_origin" value=${board.b_origin}>
	<input type="hidden" name="b_group_idx" value=${board.b_group_idx}>
	<input type="hidden" name="b_layer_idx" value=${board.b_layer_idx}>
	<p> <input type="submit" value="Post"></p>
</form>
</body>
</html>