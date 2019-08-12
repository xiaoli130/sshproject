<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
<form action="RegisterServlet" method="post">
<center>
<table border="0">
<tr>
<td>学号：</td>
<td><input type="text" name="number"></td>
</tr>
<tr>
<td>用户名：</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>密码：</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>性别：</td>
<td><input type="radio" name="usersex" value="男" checked>男
<input type="radio" name="usersex" value="女">女</td>
</tr>
<tr>
<td>年龄：</td>
<td><input type="text" name="age"></td>
</tr>
<tr>
<td>院系：</td>
<td><input type="text" name="sdept"></td>
</tr>
<tr>
<td>班级：</td>
<td><input type="text" name="class"></td>
</tr>
<tr>
<td><input type="submit" value="注册"></td>
<td><input type="reset" value="重置"></td>
</tr>
</table>
</center>
</form>
</body>
</html>