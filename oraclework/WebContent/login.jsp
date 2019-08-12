<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩管理系统</title>
</head>
<body>
<form action="LoginServlet" method="post">
<center>
<table border="0">
<tr>
<td>用户名：</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>密&nbsp;&nbsp;码：</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>
<input type="radio" name="usertype" value="学生" checked>学生</td>
<td><input type="radio" name="usertype" value="教师">教师</td>
</tr>
<tr>
<td><input type="submit" value="登录"></td>
<td><input type="button" value="注册" onClick="window.location.href='register.jsp'"></td>
</tr>
</table>
</center>
</form>
</body>
</html>