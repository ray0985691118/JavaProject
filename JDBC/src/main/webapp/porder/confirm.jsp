<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="Model.Porder"%>
    <%
    /*
    1.request-->接收-->desk,A,B,C
    2.A,B,C-->String cast to int
    3.new porder
    */
    request.setCharacterEncoding("UTF-8");
    String address = request.getParameter("address");
    int a = Integer.parseInt(request.getParameter("A"));		
    int b = Integer.parseInt(request.getParameter("B"));	
    int c = Integer.parseInt(request.getParameter("C"));	
    
    Porder p = new Porder(address,a,b,c);
    session.setAttribute("P",p);
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
 		<td>
 		<table width=450 align=center border=1>
 				<tr>
					<td colspan=2 align=center><h3>訂單明細</h3>
				<tr>
					<td width=150 align=center><h5>縣市</h5>
					<td><%=p.getAddress() %>
				<tr>
					<td width=100 align=center><h5>Arabica</h5>
					<td><%=p.getA() %>
				<tr>
					<td width=100 align=center><h5>Mandheling</h5>
					<td><%=p.getB() %>
				<tr>
					<td width=100 align=center><h5>Yirgacheffe</h5>
					<td><%=p.getC() %>
				<tr>
					<td width=100 align=center><h5>共</h5>
					<td><%=p.getSum() %>元
				<tr>
					<td colspan=2 align=center>
					<a href="../AddOrderController">確定</a> ,<a href="addOrder.jsp">重新訂購</a>
 		</table>
 	<tr height=50>
 		<td align=center><jsp:include page="footer.jsp"/>
</table>
</body>
</html>