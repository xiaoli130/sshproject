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
String number=null;
number=(String)session.getAttribute("id"); 
UserDao userdao=new UserDao();
Username uname=new Username();
String password=(String)request.getParameter("password");
String type=(String)request.getParameter("type");
if(type.equals("2"))
{
    String sql="update STUDENT set PASSWORD='"+password+"' where SNO='"+number+"'";
    userdao.update(sql);
    request.getRequestDispatcher("login.jsp").forward(request,response);
}
else
{
	String sql="update TEACHER set TPASSWORD='"+password+"' where TNO='"+number+"'";	
	userdao.update(sql);
	request.getRequestDispatcher("login.jsp").forward(request,response);
}
%>
</body>
</html>