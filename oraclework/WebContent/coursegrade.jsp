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
String type=request.getParameter("type");//课程号或课程名
String cno=null;//课程号
String coursename=null; 
SCgrade scgrade=new SCgrade();
UserDao userdao=new UserDao();

if(type.equals("1"))//课程号
{
	cno=name;
	coursename=userdao.findcname(cno);
}
else
{
	cno=userdao.findcno(name);
    coursename=name;
}
List<SCgrade> list=userdao.findSCgrade(cno);
%>
 <center>
 <h1><%=coursename%>科目成绩</h1>
   <table  border="1" >
            <tr>
                  <%
            for(int i=0;i<1;i++)//students.size()为其中数据的大小
           {
             
                
          %>          
                <td>学号</td>  
                <td>姓名</td>
                <td>成绩</td>
          <%
          } 
          
          %>
               
            </tr>
            <%
            for(int i=0;i<list.size();i++)//students.size()为其中数据的大小
           {
            	scgrade=(SCgrade)list.get(i);
       //        User user=(User)list.get(i);////Student对象，students.get(i)为获得其中的第i组数据
                
           %>
              <tr>
              <td><%=scgrade.getSno()%></td>
              <td><%=userdao.findname(scgrade.getSno()) %></td>
              <td><%=userdao.findgrade(scgrade.getSno(),cno)%></td>
              </tr>  
            
          <%
          } 
          
          %>
           
            
        </table></center>
</body>
</html>