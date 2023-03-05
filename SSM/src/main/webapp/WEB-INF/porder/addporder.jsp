<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5" 
    import="Model.Member"
    import="Model.Porder"%>
    <%
    Member m=(Member)session.getAttribute("M");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>SSM</title>
</head>
<body background="../pic/wood.jpg">
<table width=600 align=center border=1>
 	<tr height=100>
 		<td align=center><jsp:include page="title.jsp"/>
	<tr height=450>
 		<td align=top>
 		<form action="../porder/add" method="post">
 			<table width=500 align=center border=1>

 					<h2 align="center">點餐</h2>
 				<tr>
 					<td colspan=3 align=center>
 					顧客:<%=m.getName() %>
 					
 				<tr valign=top>
						<td>
						Arabica<br>
						<img alt="1." src="../pic/arabica.jpg" width=300 height=300><br>
						<select name="arabica">
							<option value="0">0
							<option value="1">1
							<option value="2">2
							<option value="3">3
							<option value="4">4
							<option value="5">5
							<option value="6">6
							<option value="7">7
							<option value="8">8
							<option value="9">9					
						</select>
						
						<td>
						Mandheling<br>
						<img alt="2" src="../pic/mandheling.jpg" width=300 height=300><br>
						<select name="mandheling">
							<option value="0">0
							<option value="1">1
							<option value="2">2
							<option value="3">3
							<option value="4">4
							<option value="5">5
							<option value="6">6
							<option value="7">7
							<option value="8">8
							<option value="9">9					
						
						</select>
						<td>
						Yirgacheffe<br>
						<img alt="3" src="../pic/yirgacheffe.jpg" width=300 height=300><br>
						<select name="yirgacheffe">
							<option value="0">0
							<option value="1">1
							<option value="2">2
							<option value="3">3
							<option value="4">4
							<option value="5">5
							<option value="6">6
							<option value="7">7
							<option value="8">8
							<option value="9">9					
						</select>			
 			</table>
 					<h4 align="center">
					<input type="submit" value="送出">
					<a href="pordermanager">上一頁</a></h4>
 			
 			<tr height=50>
 			<td align=center><jsp:include page="footer.jsp"/>
 		</form>
</table>
</body>
</html>