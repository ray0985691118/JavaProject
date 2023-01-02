<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5" import="Model.member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>SSM</title>
</head>
<body>
<table width=600 align=center border=1>
 	<tr height=100>
 		<td align=center><jsp:include page="title.jsp"/>
	<tr height=450>
 		<td align=top>
 		<form action="../porder/add" method="post">
 			<table width=500 align=center border=1>
 				<tr>
 					<td colspan=3 align=center>
 						<h3>點餐</h3>
 				<tr>
 					<td colspan=3 align=center>
 					桌號:
 					<select name="name">
 						<option value="A桌">A桌
 						<option value="B桌">B桌
 						<option value="C桌">C桌
 						<option value="D桌">D桌
 					</select>
 				<tr valign=top>
						<td>
						product1<br>
						<img alt="1." src="../pic/coffee.jpg"><br>
						<select name="product1">
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
						product2<br>
						<img alt="2" src="../pic/coffee2.jpg"><br>
						<select name="product2">
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
						product3<br>
						<img alt="3" src="../pic/coffee3.jpg"><br>
						<select name="product3">
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
						<a href="pordermanager">上一頁</a>
 			</table>
 		</form>
</table>
</body>
</html>