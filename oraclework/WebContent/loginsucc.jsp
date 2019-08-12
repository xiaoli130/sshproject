<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="oracle.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
 <%//String name=null;
//  name=(String)session.getAttribute("user"); 
//  if(name=="teacher")
 // {
	 %>
	 <center><h1>教师主页</h1>
	 <a href="allstudent.jsp">查看学生信息</a>
	 </center>
	 <% 
 // request.getRequestDispatcher("login.jsp").forward(request, response);
 // }
 %>
 
 
  -->
  <%
  Username uname=new Username();
  
  %>
  <center><h1>教师主页</h1>
     <table>
	<tr><td><a href="allstudent.jsp">查看所有学生信息</a></td></tr>
	 <tr><td><a href="register.jsp">添加学生</a></td></tr>
	 <tr><td><a href="update.jsp?id=1">修改密码</a></td></tr>
	 </table>
  </center>
  
  <center>
       <h3>查看某学生成绩</h3>
    	<form action="searchgrade.jsp" method="post">
    	<table>
    	<tr>
       <td>
       <select name="type">
    	<option  value="1">学号</option>
    	<option value="2">姓名</option>
        </select>       
        </td>
        <td>
        <input type="text" name="name">    
        </td>
        <td>
       <input type="submit" value="搜索">       
       </td>
       </tr>
       </table>
       </form>	
    	</center>
    	
    	
    <center>
       <h3>查看某科目成绩</h3>
    	<form action="coursegrade.jsp" method="post">
    	<table>
    	<tr>
       <td>
       <select name="type">
    	<option  value="1">课程号</option>
    	<option value="2">课程名</option>
        </select>       
        </td>
        <td>
        <input type="text" name="name">    
        </td>
        <td>
       <input type="submit" value="搜索">       
       </td>
       </tr>
       </table>
       </form>	
    	</center>
    	<%
    //	String username=request.getParameter("name"); 
	//    String gender=request.getParameter("gender");
    	%>
</body>
</html>