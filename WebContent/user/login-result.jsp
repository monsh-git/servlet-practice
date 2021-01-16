<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./header.jsp" %>
<meta charset="UTF-8">
<title>Login was successful</title>
</head>
<!-- <style>
	body {
		margin:0;
		padding:0;
	}
	div:nth-child(1) {
		background-color:rgba(75,189,217,0.1);
		padding:10px 30px;
		font-size:1.2rem;
		font-weight:700;
	}
	div:nth-child(2) {
		width:200px;
	}
	div ul {
		width:100%;
		text-align:center;
		list-style:none;
		padding:0;
	}
	div ul li {
		padding:10px;
		font-size:1rem;
		background-color:rgba(75,189,217,0.1);
		border-radius:10px;
		margin:10px;
		font-weight:700;
		box-shadow:2px 3px 3px #bbbbbb;
		
	}
	div ul li a {
		text-decoration:none;
		color:#333333;
	}
</style> -->
<body>
<div class="container">
	<h1>${sessionScope.user.u_name }'s Login Success</h1>
	<hr>
	<ul class="list-unstyled">
	<div class="row">
		<div class="col-md-4"></div>
		<li><a class="col-md-4 btn btn-default" href="board-list.do">Bulletin Board</a></li>
		<div class="col-md-4"></div>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<li><a class="col-md-4 btn btn-default" href="user-list.do">User List</a></li>
		<div class="col-md-4"></div>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<li><a class="col-md-4 btn btn-default" href="logout.do">Logout</a></li>
		<div class="col-md-4"></div>
	</div>
	</ul>
</div>
</body>
</html>