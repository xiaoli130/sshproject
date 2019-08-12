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
request.setCharacterEncoding("UTF-8");
String name=request.getParameter("name"); 
String type=request.getParameter("type");//学号或姓名
String sno=null;//学号
String username=null; 
Course cuser=new Course();
UserDao userdao=new UserDao();
List<Course> list=userdao.findCourse();
if(type.equals("1"))
{
	sno=name;
	username=userdao.findname(sno);
}
else
{
	sno=userdao.findsno(name);
	username=name;
}
%>
 <center>
 <h1><%=username%>的成绩页面</h1>
   <table  border="1" >
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
            
              <td><%=userdao.findgrade(sno,cuser.getCno())%></td>
                 
            
          <%
          } 
          
          %>
           
            
        </table></center>
</body>
</html>