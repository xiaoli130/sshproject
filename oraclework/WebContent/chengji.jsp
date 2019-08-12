<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="oracle.UserDao"%>
<%@ page import="oracle.User" %>
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
user.setSno(request.getParameter("id"));
String username=userdao.findname(user.getSno());

%>
<form action="GradeServlet" method="post">
<center>
<h1>编辑学生<%=username%>成绩</h1>
<h6>注意：学生学号和姓名只需填其中之一即可</h6>
<table border="1">
<tr>
<td>学号：</td>
<td><input type="text" name="sno" value="<%=user.getSno()%>"></td>
</tr>
<tr>
<td>oracle：</td>
<td><input type="text" name="oracle"></td>
</tr>
<tr>
<td>语文：</td>
<td><input type="text" name="yuwen"></td>
</tr>
<tr>
<td>数学：</td>
<td><input type="text" name="math"></td>
</tr>
<tr>
<td>英语：</td>
<td><input type="text" name="English"></td>
</tr>
<tr>
<td>java：</td>
<td><input type="text" name="java"></td>
</tr>
<tr>
<td>
<input type="submit" value="提交">
</td>
<td>
<input type="reset" value="重置">
</td>
</tr>
</table>
</center>
</form>
</body>
</html>