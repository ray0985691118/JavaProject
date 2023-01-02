<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 		<td align=top>
 		<form action="confirm.jsp" method="post">
 			<table width=500 align=center border=1>
 				<tr>
 					<td colspan=3 align=center>
 						<h3>點餐</h3>
 				<tr>
 					<td colspan=3 align=center>
 					桌號:
 					<select name="desk">
 						<option value="A桌">A桌
 						<option value="B桌">B桌
 						<option value="C桌">C桌
 						<option value="D桌">D桌
 					</select>
 				<tr valign=top>
						<td>
						A<br>
						<img alt="1." src="../pic/coffee.jpg"><br>
						<select name="A">
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
						B<br>
						<img alt="2" src="../pic/coffee2.jpg"><br>
						<select name="B">
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
						C<br>
						<img alt="3" src="../pic/coffee3.jpg"><br>
						<select name="C">
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
					<tr>
						<td colspan=3 align="center">
						<input type="submit" value="送出">
						<a href="index.jsp">上一頁</a>
 			</table>
 		</form>
 	<tr height=50>
 		<td align=center><jsp:include page="footer.jsp"/>
</table>
</body>
</html>