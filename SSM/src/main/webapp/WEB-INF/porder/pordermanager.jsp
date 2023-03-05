<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5" 
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>SSM</title>
</head>
<body background="../pic/wood.jpg">
<table width=400 align="center" border=1>
	
 		<tr height=50>
   			<td  align="center"><h2>購物選單</h2>
		<tr height=50>
   			<td width=200  align="center">
   			<a href="../porder/addporder">新增訂單</a>
		<tr height=50>
   			<td width=200  align="center">
   			<a href="../porder/queryporder">查詢訂單</a>
		<tr height=50>
   			<td width=200  align="center">
   			<a href="../porder/updateporder">修改訂單</a>
		<tr height=50>
   			<td width=200  align="center">
   			<a href="../porder/deleteporder">刪除訂單</a>
   			
   			<tr height=50>
 			<td align=center><jsp:include page="footer.jsp"/>
   
</table>
</body>
</html>