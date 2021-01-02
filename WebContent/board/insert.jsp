<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>
<h2>글 쓰기</h2>
<form action="board-insert-process.do" name="board" method="post">
	<p> 제목 : <input type="text" name="title"></p>
	<p> 내용 : <input type="text" name="content"></p>
	<p> 작성일 : <input type="text" name="date"></p>
	<input type="hidden" name="writer" value=${sessionScope.user.u_id}>
	<input type="hidden" name="u_idx" value=${sessionScope.user.u_idx}>
	<p> <input type="submit" value="글 저장"></p>
</form>
</body>
</html>