<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Dao.porderDao"
    import="java.util.List"
    import="Model.porder"%>
    <%
    List<porder> show1=new porderDao().queryAll2();
    //List<porder> l=new porderDao().queryAll2();
    //List<porder> l=new porderDao().querySum(500, 1200);
    /*
	1.request-->接收判斷-->null ,""
 	2.有--->l=querySum
 	3.null,""-->l=queryAll2
 	*/
    String Start=request.getParameter("start");
 	String End=request.getParameter("end");
 	List<porder> l=null;
 	if(Start!=null && Start!="" && End!=null && End!="")
 	{
 		int S=Integer.parseInt(Start);
 		int E=Integer.parseInt(End);
 		
 		l=new porderDao().queryrange(S,E);
 	}
 	else
 	{
 		l=new porderDao().queryAll2();
 	}
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
	
	<form action="../porder/querysum">
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
				<td>ID<td>桌號<td>Product1<td>Product2<td>Product3<td>金額<td>折扣<td>時間
				<!-- <%=show1 %> -->
				<%
				for(porder p:l)
				{
					out.println("<tr><td>"+p.getId()+
									"<td>"+p.getName()+
									"<td>"+p.getProduct1()+
									"<td>"+p.getProduct2()+
									"<td>"+p.getProduct3()+
									"<td>"+p.getSum()+
									"<td>"+p.getDiscountprice()+
									"<td>"+p.getDate());
				}
				%>
			</table>
			<table align="center">
			<tr>
				<td>
 					<a href="pordermanager">回首頁</a>
 			</table>	
</table>
</body>
</html>