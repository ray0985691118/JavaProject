<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body background="../pic/wood.jpg">
<form action="../AddMemberController" method="post">
<table width=350 align=center border=1>
	<tr>
		<td colspan=2 align=center>�|���򥻸��
			<tr align=center>
				<td width=70>�m�W
				<td><input type="text" name="name">
			<tr align=center>
				<td width=70>�b��
				<td><input type="text" name="username">
			<tr align=center>
				<td width=70>�K�X
				<td><input type="password" name="password">
			<tr align=center>
				<td width=70>�q��
				<td><input type="text" name="phone">
			<tr align=center>
				<td width=70>�a�}
				<td><input type="text" name="address">
			<tr align=center>
				<td width=70>Email
				<td><input type="text" name="email">
				
			<tr>
				<td colspan=2 align=center>
				<input type="submit" value="���U">
</table>
</form>
</body>
</html>