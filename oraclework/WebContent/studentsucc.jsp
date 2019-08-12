<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="oracle.Username" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Username uname=new Username();
String sno=null;
sno=(String)session.getAttribute("id"); 
%>
<center>
<h1>学生主页</h1>
<table>
<tr>
<td><a href="findGrade.jsp?id=<%=sno%>">查看成绩</a></td>
</tr>
<tr>
<td><a href="update.jsp?id=2">修改密码</a></td>
</tr>
</table>
</center>
</body>
</html>