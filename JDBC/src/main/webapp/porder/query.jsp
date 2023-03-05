<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "dao.porder.ImplPorder"
    import = "java.util.List"
    import = "Model.Porder"
    import = "java.util.ArrayList"
    %>
    <%
    String show = new ImplPorder().selectAll1();
    List<Porder> l = (List<Porder>)session.getAttribute("L");
    /*
	1.request-->接收判斷-->null ,""
 	2.有--->l=querySum
 	3.null,""-->l=queryAll2*/
 	
    /*String start = request.getParameter("start");
 	String end = request.getParameter("end");
 	List<Porder> l = null;
 	if(start!=null && start!="" && end!=null && end!="")
 	{
 		int s = Integer.parseInt(start);
 		int e = Integer.parseInt(end);
 		
 		l = new ImplPorder().selectSum(s,e);
 	}
 	else
 	{
 		l = new ImplPorder().selectAll2();
 	}*/
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
	
	<form action="../QueryController" method="post">
 		<td><table width=500 align=center border=1>
 			<tr>
				<td>訂單資料
			<tr>
				<td>
				輸入金額:
				從<input type="text" name="start" size=5>到<input type="text" name="end" size=5>
				<input type="submit" value="確定">
 		</table>
 		</form>
 		<hr>
 		<table width=500 align=center border=1>
			<tr>
				<td>ID<td>地址<td>Arabica<td>Mandheling<td>Yirgacheffe<td>金額
				
				<%			
				if(l != null){
					for(Porder p:l){
								out.println("<tr><td>" + p.getId()+
									"<td>" + p.getAddress()+
									"<td>" + p.getA()+
									"<td>" + p.getB()+
									"<td>" + p.getC()+
									"<td>" + p.getSum());
					}
				}else{
					out.println(show);
				}
				%>
				
			</table>
 			<tr height=50>
 				<td align="center"><a href="index.jsp">回首頁</a>
				<jsp:include page="footer.jsp"/>
</table>
</body>
</html>