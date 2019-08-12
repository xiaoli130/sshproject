<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="oracle.UserDao" %>
<%@ page import="oracle.User" %>
<%@ page import="java.util.*" %>
<%@ page import="oracle.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩</title>
</head>
<body>
<%
UserDao userdao=new UserDao();
User user=new User();
Course cuser=new Course();
user.setSno(request.getParameter("id"));
List<Course> list=userdao.findCourse();
%>
 <center>  <table  border="1" >
            <tr>
                  <%
            for(int i=0;i<list.size();i++)//students.size()为其中数据的大小
           {
              cuser=(Course)list.get(i);////Student对象，students.get(i)为获得其中的第i组数据
                
          %>          
                <td><%=cuser.getCname()%></td>  
          <%
          } 
          
          %>
               
            </tr>
            <%
            for(int i=0;i<list.size();i++)//students.size()为其中数据的大小
           {
            	cuser=(Course)list.get(i);
       //        User user=(User)list.get(i);////Student对象，students.get(i)为获得其中的第i组数据
                
           %>
            
              <td><%=userdao.findgrade(user.getSno(),cuser.getCno())%></td>
                 
            
          <%
          } 
          
          %>
           
            
        </table></center>
</body>
</html>