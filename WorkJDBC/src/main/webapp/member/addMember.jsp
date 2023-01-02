<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form action="AddMemberController" method="post">
<table width=350 align=center border=1>
	<tr>
		<td colspan=2 align=center>會員基本資料
			<tr align=center>
				<td width=70>姓名
				<td><input type="text" name="name">
			<tr align=center>
				<td width=70>帳號
				<td><input type="text" name="Username">
			<tr align=center>
				<td width=70>密碼
				<td><input type="password" name="Password">
			<tr align=center>
				<td width=70>電話
				<td><input type="text" name="Phone">
			<tr align=center>
				<td width=70>地址
				<td><input type="text" name="address">
			<tr align=center>
				<td width=70>行動
				<td><input type="text" name="Mobile">
				
			<tr>
				<td colspan=2 align=center>
				<input type="submit" value="註冊">
</table>
</form>
</body>
</html>