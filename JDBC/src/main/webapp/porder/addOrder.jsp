<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 		<td align=top>
 		<form action="confirm.jsp" method="post">
 			<table width=500 align=center border=1>
 				<tr>
 					<td colspan=3 align=center>
 						<h3>訂購頁面</h3>
 				<tr>
 					<td colspan=3 align=center>
 					地址:
 					<select name="address">
 						<option value="台北">台北
 						<option value="新北">新北
 						<option value="台中">台中
 						<option value="高雄">高雄
 					</select>
 				<tr valign=top>
						<td>
						Arabica<br>
						<img alt="1." src="../pic/arabica.jpg" width=300 height=300><br>
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
						Mandheling<br>
						<img alt="2" src="../pic/mandheling.jpg" width=300 height=300><br>
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
						Yirgacheffe<br>
						<img alt="3" src="../pic/yirgacheffe.jpg" width=300 height=300><br>
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
 			</table>
 				<tr height=50>
 				<td align="center"><a href="index.jsp">回首頁</a>
				<jsp:include page="footer.jsp"/>
 		</form>
</table>
</body>
</html>