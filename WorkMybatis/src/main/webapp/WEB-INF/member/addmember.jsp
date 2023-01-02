<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>SSM</title>
</head>
<body>
<form action="../member/add" method="post">
<table width=400 align="center" border=1>
	<tr>
		<td colspan=2 align="center"><h2>請註冊</h2>
	<tr>
		<td width=200>名稱:
		<input type="text" name="name">
	<tr>
		<td width=200>帳戶:
   		<input type="text" name="username">
   	<tr>
		<td width=200>密碼:
   		<input type="password" name="password">  
	<tr>
   		<td width=200>電話:
   		<input type="text" name="phone">
	<tr>
   		<td width=200>地址:
   		<input type="text" name="address">
	<tr>
   		<td width=200>性別:
   		<input type="radio" name="admin" value="true">男  
       <input type="radio" name="admin" value="false">女 
	<tr>
  		<td colspan=2><input type="submit" value="ok"> 
</table>
</form>
</body>
</html>