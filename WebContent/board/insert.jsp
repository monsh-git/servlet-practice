<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./header.jsp" %>
<meta charset="UTF-8">
<title>Post</title>
</head>
<body>
<div class="container">
	<h2>Post</h2>
	<hr>
	<form action="board-insert-process.do" name="board" method="post" enctype="multipart/form-data">
	  <div class="form-group">
	    <label for="exampleInputTitle1">Title</label>
	    <input type="text" class="form-control" id="exampleInputTitle1" name="title" placeholder="Title">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputContent1">Content</label>
	    <input type="text" class="form-control" id="exampleInputContent1" name="content" placeholder="Content">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputDate1">Date</label>
	    <input type="text" class="form-control" id="exampleInputDate1" name="date" placeholder="0000-00-00">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputFile">Image</label>
	    <input type="file" id="exampleInputFile" name="fname">
  	  </div>
  	  <input type="hidden" name="writer" value=${sessionScope.user.u_id}>
	  <input type="hidden" name="u_idx" value=${sessionScope.user.u_idx}>
	  <button type="submit" class="btn btn-default" value="Save">Post</button>
	</form>
</div>
</body>
</html>