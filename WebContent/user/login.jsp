<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./header.jsp" %>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div class="container">
	<h1>Login</h1>
	<hr>
	<form class="form-horizontal" action="user-login-process.do" name="user" method="post">
	  <div class="form-group">
	    <label for="inputId3" class="col-sm-2 control-label">Id</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputEmail3" name="login_id" placeholder="ID">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="inputPassword3" name="login_password" placeholder="Password">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default" value="Login">Sign in</button>
	  </div>
  </div>
</form>
</div>
</body>
</html>