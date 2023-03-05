<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSM</title>
</head>
<body background="pic/wood.jpg">
	<form action="member/selectUser" method="post">
		<table width=400 align="center" border=1>
		<tr>
   			<td colspan=2><h2 align="center">請登入</h2>
		<tr>
  			<td>帳戶:
  			<td><input type="text" name="username">
		<tr>
  			<td>密碼:
  			<td><input type="password" name="password">
		<tr >
  			<td colspan=2 align="center"><input type="submit" value="ok">
			<a href="member/addmember">註冊</a>
		</table>
	</form>
</body>
</html>