<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body background="../pic/wood.jpg">
<form action="../LoginController" method="post">
	<table width="300" align=center border=1>
		<tr>
			<td colspan=2 align=center>會員登入
			<tr align=center>
			<td>帳號
			<td><input type="text" name="username">
			<tr align=center>
			<td>密碼
			<td><input type="password" name="password">
			<tr>
			<td colspan=2 align=center>
			<input type="submit" value="登入">
			<a href="addMember.jsp">註冊</a>
	</table>
</form>
</body>
</html>