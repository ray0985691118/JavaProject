<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8" 
    import="Model.*"
    import="Factory.*"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSM</title>
<%
Member m = (Member)session.getAttribute("M");
Fact f = ImplFactory.a.getBean("sf",Fact.class);
%>
</head>
<body background="../pic/wood.jpg">
	<table width=90% align="center" >
	  <form action="../porder/deleteId" method="post">
	    <tr>
	      <td colspan=7 align="center"><h2><%=m.getName() %>你好，請輸入刪除條件</h2>
	  	<tr>
	      <td  colspan=7 align="center">
	      ID:<input type="text" name="id" size="5">  
	      <input type="submit" value="ok">
	  </from>        
	  <hr>
	   <tr>
		   <td align="center">   
		   <%out.println("<table width=750 align=center border=1>"); %>
		   <%
	   		Porder[] p = (Porder[])session.getAttribute("P");
	   
		   if(p==null){
			   
		   List<Object>l  = f.getPd().selectAll();
		   p = l.toArray(new Porder[l.size()]);
		    }
		   for (Porder o:p) {
		   	out.println("<tr><td>ID:"+o.getId()+
		   			"<td>顧客:"+o.getName()+
		   			"<td>Arabica:"+o.getArabica()+
		   			"<td>Mandheling:"+o.getMandheling()+
		   			"<td>Yirgacheffe:"+o.getYirgacheffe()+
		   			"<td>總金額:"+o.getSum()+
		   			"<td>折扣後:"+o.getDiscountprice()+
		   			"<td>時間:"+o.getDate()
		   			);
		   }
		   
		     session.removeAttribute("P");
	   		%>   
	    <%out.println("</table>");%> 
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