<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post View</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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

<!-- Comment Insert -->
<div>
	<textarea rows="2" id="c_content" placeholder="Type your comment here" style="width:100%"></textarea>
	<div>
		<c:if test="${sessionScope.user.u_id == null}">
			<input type="button" value="Save Comment" disabled="disabled">
		</c:if>
		<c:if test="${sessionScope.user.u_id != null}">
			<input type="button" value="Save Comment" id="commentWriteBtn">
		</c:if>
	</div>
</div>

<!-- Comments -->
<table id="commentContainer">

</table>

<script>
let obj = {
	comment_list: function () {
		$.ajax({
			method: "GET",
			url: "/lcomputerstudy/comment-read.do",
			dataType: "json",
			data:{
				b_idx: "${board.b_idx}"
			}
		})
		.done(function(json){
			let html = "";
			$.each(json, function(index, item){
				html += "<tr align='center'>";
	            html += "<td>" + item.u_idx + "</td>";
	            html += "<td align='left'>" + item.c_content + "</td>";
	            let date = item.c_date.substring(0, 10);
	            html += "<td>" + date + "</td>";
	            html += "</tr>";
			})
			$('#commentContainer').html(html);
		});
	}
};

obj.comment_list();

$(document).on('click', '#commentWriteBtn', function(){
	$.ajax({
		url: "/lcomputerstudy/comment-write.do",
		data:{
			b_idx:"${board.b_idx}",
			u_idx:"${sessionScope.user.u_idx}",
			c_content:$("#c_content").val(),
		},
		beforeSend:function() {
			console.log("beforeSend : comment-write");
		},
		comple:function() {
			console.log("complete : comment-write");
		},
		success:function(data) {
			if(data.result){
				console.log("success : comment-write");
			}
		}
	})
});
</script>

<!-- Ajax Example
<button id="btn">button</button>

<script>
$(document).on('click', '#btn', function () {
	$.ajax({
	  method: "POST",
	  url: "some.php",
	  data: { name: "John", location: "Boston" }
	})
	  .done(function( html ) {
	    $('#ddd').html(html);
	  });
});
</script>
 -->
 
</body>
</html>