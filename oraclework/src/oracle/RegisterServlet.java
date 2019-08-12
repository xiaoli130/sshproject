package oracle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	    this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	   String number=request.getParameter("number");
	   String username=request.getParameter("username");
	   String password=request.getParameter("password");
	   String usersex=request.getParameter("usersex");
	   String age=request.getParameter("age");
	   String sdept=request.getParameter("sdept");
	   String sclass=request.getParameter("class");
	   UserDao userdao=new UserDao();
	   User user=new User();
	   user.setSno(number);
	   user.setSname(username);
	   user.setPassword(password);
	   user.setSsex(usersex);
	   user.setSage(age);
	   user.setSdept(sdept);
	   user.setSclass(sclass);
	   String name=null;
	   if(userdao.insert(user))
	   {

		   HttpSession session = request.getSession();
		   name=(String)session.getAttribute("username"); 
		   if(name=="teacher")
		   {
			   request.getRequestDispatcher("loginsucc.jsp").forward(request,response);
		   }
		   else
		   {
		   request.getRequestDispatcher("login.jsp").forward(request,response);
		   }
	   }
	   else
	   {
		   request.getRequestDispatcher("fail.jsp").forward(request,response);
	   }
		
	}

}
