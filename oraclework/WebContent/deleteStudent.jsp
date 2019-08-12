<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="oracle.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
User user=new User();
UserDao userdao=new UserDao();
user.setSno(request.getParameter("id"));
userdao.delete(user.getSno());
request.getRequestDispatcher("allstudent.jsp").forward(request,response);
%>

</body>
</html>