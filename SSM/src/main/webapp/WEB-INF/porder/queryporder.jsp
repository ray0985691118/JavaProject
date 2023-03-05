<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="dao.PorderDao"
    import="java.util.List"
    import="Model.Porder"%>
    <%
    List<Porder> show1 = new PorderDao().queryAll();
    //List<porder> l=new porderDao().queryAll2();
    //List<porder> l=new porderDao().querySum(500, 1200);
    /*
	1.request-->接收判斷-->null ,""
 	2.有--->l=querySum
 	3.null,""-->l=queryAll2
 	*/
    String Start = request.getParameter("start");
 	String End = request.getParameter("end");
 	List<Porder> l = null;
 	if(Start != null && Start != "" && End != null && End != "")
 	{
 		int S = Integer.parseInt(Start);
 		int E = Integer.parseInt(End);
 		
 		l = new PorderDao().selectRange(S,E);
 	}
 	else{
 		l = new PorderDao().queryAll();
 	}
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
	
	<form action="../porder/selectRange">
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
				<td>ID<td>顧客<td>Arabica<td>Mandheling<td>Yirgacheffe<td>總金額<td>折扣後<td>時間
				<!-- <%=show1 %> -->
				<%
				for(Porder p:l)
				{
					out.println("<tr><td>"+p.getId()+
									"<td>"+p.getName()+
									"<td>"+p.getArabica()+
									"<td>"+p.getMandheling()+
									"<td>"+p.getYirgacheffe()+
									"<td>"+p.getSum()+
									"<td>"+p.getDiscountprice()+
									"<td>"+p.getDate());
				}
				%>
			</table>
			<table align="center">
			<tr>
				<td>
 					<a href="pordermanager">上一頁</a>	
 			<tr height=50>
 			<td align=center><jsp:include page="footer.jsp"/>
 			</table>	
</table>
</body>
</html>