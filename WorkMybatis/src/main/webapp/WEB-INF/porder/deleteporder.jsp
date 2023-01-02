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
member m=(member)session.getAttribute("M");
fact f=implFactory.a.getBean("sf",fact.class);
%>
</head>
<body>


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
   porder[]p=(porder[])session.getAttribute("P");
   
   if(p==null){
	   
   List<Object>l =f.getPd().queryAll();
    p=l.toArray(new porder[l.size()]);
    
   }
   

   for (porder o:p) {
   	out.println("<tr><td>ID:"+o.getId()+
   			"<td>nama:"+o.getName()+
   			"<td>product1:"+o.getProduct1()+
   			"<td>product2:"+o.getProduct2()+
   			"<td>product3:"+o.getProduct3()+
   			"<td>sum:"+o.getSum()+
   			"<td>discountprice:"+o.getDiscountprice()+
   			"<td>date:"+o.getDate()
   			);
   }
   
     session.removeAttribute("P");
   %>   
    <%out.println("</table>");%> 
    <table align="center">
			<tr>
				<td>
 					<a href="pordermanager">回首頁</a>
 			</table>
 </table>     
</body>
</html>