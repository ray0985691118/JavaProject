<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import = "Model.Member"
    import = "java.util.ArrayList"
    %>
    <%
    //ArrayList<Member> m = (ArrayList<Member>)session.getAttribute("M");
    Member m = (Member)session.getAttribute("M");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body background="../pic/wood.jpg">
<h1 align="center"><%=m.getName() %>�w��z,�n�J���\</h1>
<h2 align="center"><a href="../porder/index.jsp">�i�J�ʪ�</a></h2>
</body>
</html>