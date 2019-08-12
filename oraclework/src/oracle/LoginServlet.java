package oracle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		   this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
		   String usertype=request.getParameter("usertype");
		//  System.out.println(username+" "+password+" "+usertype);
		   UserDao userdao=new UserDao();
		   if(usertype.equals("学生"))
		   {
			//   System.out.println("学生端");
			//   String sql="select * from STUDENT where SNAME="+username+",PASSWORD="+password;
			   if(userdao.findInfo(username, password,"1"))
			   {
				   HttpSession session = request.getSession();
				   session.setAttribute("username",username); 
				   String sno=userdao.findsno(username);
				   Username uname=new Username();
				   uname.setUsername(sno);
				   session.setAttribute("id", sno);
				   request.getRequestDispatcher("studentsucc.jsp").forward(request,response);
			   }
			   else
			   {
				   request.getRequestDispatcher("fail.jsp").forward(request,response);
			   }
			   
		   }
		   else
		   {
			//   System.out.println("教师端");
			//   String sql="select * from TEACHER where TNAME="+username+",TPASSWORD="+password;
			   if(userdao.findInfo(username, password,"2"))
			   {
				   String tno=userdao.findtno(username);
				   Username uname=new Username();
				   uname.setUsername(tno);
				   HttpSession session = request.getSession();
				   session.setAttribute("username", "teacher"); 
				   session.setAttribute("id", tno);
				   request.getRequestDispatcher("loginsucc.jsp").forward(request,response);
			   }
			   else
			   {
				   request.getRequestDispatcher("fail.jsp").forward(request,response);
			   }
			 
		   }
	}

}
