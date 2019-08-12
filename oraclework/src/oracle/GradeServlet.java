package oracle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        String sno=request.getParameter("sno");
		    String username=request.getParameter("username");
		    String oracle=request.getParameter("oracle");
		    String yuwen=request.getParameter("yuwen");
		    String math=request.getParameter("math");
		    String English=request.getParameter("English");
		    String java=request.getParameter("java");
		    String cno=null;
		    UserDao userdao=new UserDao();
	//	    sno=userdao.findsno(username);
		//    System.out.println(sno);
		    if(sno.equals("")) {
		    	sno=userdao.findsno(username);
		    }
		    System.out.println(sno);
		    if(!oracle.equals("")) {
		    	cno=userdao.findcno("oracle");
		    	userdao.insertgrade(sno, cno, oracle);
		    	//System.out.println(cno);
		    }
		    if(!yuwen.equals("")) {
		    	cno=userdao.findcno("语文");
		    	userdao.insertgrade(sno, cno, yuwen);
		    	//System.out.println(cno);
		    }
		    if(!math.equals("")) {
		    	cno=userdao.findcno("数学");
		    	userdao.insertgrade(sno, cno, math);
		    }
		    if(!English.equals("")) {
		    	cno=userdao.findcno("英语");
		    	userdao.insertgrade(sno, cno, English);
		    }
		    if(!java.equals("")) {
		    	cno=userdao.findcno("java"); 
		    	userdao.insertgrade(sno, cno, java);
		    }
		    
		    request.getRequestDispatcher("loginsucc.jsp").forward(request, response);
		    
	}

}
