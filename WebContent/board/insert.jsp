<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post</title>
</head>
<body>
<h2>Post</h2>
<form action="board-insert-process.do" name="board" method="post" enctype="multipart/form-data">
	<p> Title : <input type="text" name="title"></p>
	<p> Content : <input type="text" name="content"></p>
	<p> Date : <input type="text" name="date"></p>
	<p> Image : <input type="file" name="fname"></p>
	<input type="hidden" name="writer" value=${sessionScope.user.u_id}>
	<input type="hidden" name="u_idx" value=${sessionScope.user.u_idx}>
	<p> <input type="submit" value="Save"></p>
</form>
</body>
</html>