<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="oracle.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

UserDao userdao=new UserDao();
User user=new User();
String number=null;
number=(String)request.getParameter("id");


	%>
	<form action="updatemima.jsp" method="post">
	<center>
	<table>
	<tr>
	<td>新密码：</td>
	<td><input type="text" name="password"></td>
	</tr>
	<tr>
	<td><input type="hidden" name="type" value="<%=number%>"></td>
	</tr>
	<tr>
    <td><input type="submit" value="提交"></td>
	</tr>
	</table>	
	</center>	
	</form>
	<% 

%>
</body>
</html>