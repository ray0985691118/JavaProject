<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Dao.porder.implPorder"
    import="java.util.List"
    import="Model.porder"%>
    <%
    List<porder> l=new implPorder().selectAll2();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=600 align=center border=1>
 	<tr height=100>
 		<td align=center><jsp:include page="title.jsp"/>
	<tr height=450>
	
	<form action="../deleteController" method="post">
 		<td><table width=500 align=center border=1>
 				<tr align=center>
						<td>刪除訂單資料
					<tr align=center>
						<td>
						ID:<input type="text" name="id" size=3>
						<input type="submit" value="確定">
 		</table>
 		</form>
 		<hr>
 		<table width=500 align=center border=1>
			<tr>
				<td>ID<td>桌號<td>A餐<td>B餐<td>C餐<td>金額
				<%
				for(porder p:l)
				{
					out.println("<tr><td>"+p.getId()+
									"<td>"+p.getDesk()+
									"<td>"+p.getA()+
									"<td>"+p.getB()+
									"<td>"+p.getC()+
									"<td>"+p.getSum());
				}
				%>
			</table>
 	<tr height=50>
 		<td align=center><jsp:include page="footer.jsp"/>
 		<tr>
						<td colspan=3 align="center">
 		<a href="index.jsp">回首頁</a>
</table>
</body>
</html>