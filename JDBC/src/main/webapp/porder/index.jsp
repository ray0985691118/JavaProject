<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body background="../pic/wood.jpg">
<table width=600 align=center border=1>
 	<tr height=100>
 		<td align=center><jsp:include page="title.jsp"/>
	<tr height=450>
 		<td><table width=300 align=center border=0>
 			<tr>
 				<td align=center><a href="addOrder.jsp">訂購商品</a>
 			<tr>
 				<td align=center><a href="query.jsp">訂購目錄</a>
 			<tr>
 				<td align=center><a href="update.jsp">修改商品</a>
 			<tr>
 				<td align=center><a href="delete.jsp">取消訂單</a>	
 		</table>
 	<tr height=50>
 		<td align=center><jsp:include page="footer.jsp"/>
</table>
</body>
</html>