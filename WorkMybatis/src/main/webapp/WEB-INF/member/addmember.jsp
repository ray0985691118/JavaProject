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
		<td colspan=2 align="center"><h2>�е��U</h2>
	<tr>
		<td width=200>�W��:
		<input type="text" name="name">
	<tr>
		<td width=200>�b��:
   		<input type="text" name="username">
   	<tr>
		<td width=200>�K�X:
   		<input type="password" name="password">  
	<tr>
   		<td width=200>�q��:
   		<input type="text" name="phone">
	<tr>
   		<td width=200>�a�}:
   		<input type="text" name="address">
	<tr>
   		<td width=200>�ʧO:
   		<input type="radio" name="admin" value="true">�k  
       <input type="radio" name="admin" value="false">�k 
	<tr>
  		<td colspan=2><input type="submit" value="ok"> 
</table>
</form>
</body>
</html>