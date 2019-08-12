<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="oracle.User" %>
<%@ page import="oracle.UserDao" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
</head>
<body>

  <center><h1>信息如下所示：</h1></center><br>
      <% 
        UserDao userdao = new UserDao();
  	List<User> list=userdao.findALL();//接收StudentDao中的students数组并赋给students对象
        %>    
      <center>  <table  border="1" >
            <tr>
                <td >学号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>院系</td>
                <td>班级</td>
                <td colspan="3">其他操作</td>
            </tr>
            <%
            for(int i=0;i<list.size();i++)//students.size()为其中数据的大小
           {
               User user=(User)list.get(i);////Student对象，students.get(i)为获得其中的第i组数据
                
           %>
            <tr>
                <td><%=user.getSno()%></td>
                <td><%=user.getSname() %></td>  
                <td><%=user.getSsex() %></td>
                <td><%=user.getSage() %></td>
                <td><%=user.getSdept() %></td>
                <td><%=user.getSclass() %></td>
                <td><a href="chengji.jsp?id=<%=user.getSno()%>">编辑成绩</a></td>
                <td><a href="deleteStudent.jsp?id=<%=user.getSno()%>">删除</a></td>
                 
            </tr>
          <%
          } 
          
          %>
           
            
        </table></center>
               
  </body>
</body>
</html>