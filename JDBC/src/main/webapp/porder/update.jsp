<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="dao.porder.ImplPorder"
    import="java.util.List"
    import="Model.Porder"%>
    <%
    List<Porder> l=new ImplPorder().selectAll2();
    %>
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
	
	<form action="../UpdateController" method="post">
 		<td><table width=500 align=center border=1>
 				<tr align=center>
						<td>修改訂單資料
					<tr align=center>
						<td>
						ID:<input type="text" name="id" size=3>
						縣市:<select name="address">
							<option value="台北">台北
							<option value="新北">新北
							<option value="台中">台中
							<option value="高雄">高雄
						</select>
						Arabica:<input type="text" name="A" size=3>
						Mandheling:<input type="text" name="B" size=3>
						Yirgacheffe:<input type="text" name="C" size=3>
						<input type="submit" value="確定">
 		</table>
 		</form>
 		<hr>
 		<table width=500 align=center border=1>
			<tr>
				<td>ID<td>縣市<td>Arabica<td>Mandheling<td>Yirgacheffe<td>金額
				<%
				for(Porder p:l)
				{
					out.println("<tr><td>"+p.getId()+
									"<td>"+p.getAddress()+
									"<td>"+p.getA()+
									"<td>"+p.getB()+
									"<td>"+p.getC()+
									"<td>"+p.getSum());
				}
				%>
			</table>
 			<tr height=50>
 				<td align="center"><a href="index.jsp">回首頁</a>
				<jsp:include page="footer.jsp"/>
</table>
</body>
</html>