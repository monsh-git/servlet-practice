<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� �߰�</title>
</head>
<body>

<h2>ȸ������</h2>
<form action="user-insert-process.do" name="user" method="post">
	<p> ���̵� : <input type="text" name="id"><input type="button" value="���̵� �ߺ� �˻�"></p>
	<p> ��й�ȣ : <input type="password" name="password"></p>
	<p> �̸� : <input type="text" name="name">
	<p> ����ó : <input type="text" maxlength="4" size="4" name="tel1"> -
			   <input type="text" maxlength="4" size="4" name="tel2"> -
			   <input type="text" maxlength="4" size="4" name="tel3"> 
	</p>
	<p> ���� : <input type="text" name="age"></p>
	<p> <input type="submit" value="�����ϱ�"></p>	
</form>
</body>
</html>