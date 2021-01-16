<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./header.jsp" %>
<meta charset="UTF-8">
<title>Image Upload Test Page</title>
</head>
<body>
<h2>Image Upload Test</h2>
<form action="image-upload-test.do" name="board" method="post" enctype="multipart/form-data">
	<p> Image : <input type="file" name="fname"></p>
	<p> <input type="submit" value="Save"></p>
</form>
</body>
</html>