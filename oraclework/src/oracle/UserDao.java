package oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
/*
  public boolean  saveInfo(User user){//添加会员
        try{
            session=HibernateUtil.getThreadLocalSession();
            transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();
           
            return true;
        }catch(Exception e){
            message("saveInfo.error:"+e);
            e.printStackTrace();
            return false;
        }finally{
        	HibernateUtil.closeSession();
        }
    }
    
   public User insert(User user) throws Exception{
	User u1=null;
	Connection con=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	try{
		con=DbConnect.getDBconnection();
		pstm=con.prepareStatement(INSERT_SQL);
		pstm.setString(1, user.getUser());//第一个?指定为user.getUser()
		pstm.setString(2, user.getPassword());//第二个?指定为user.getPassword()
		pstm.executeUpdate();
	}catch(Exception e){		
	}finally{
		DbConnect.closeDB(con, pstm, rs);
	}
	return user;
} 
   
    
 public boolean findUserByName(String hql,String name)  {//查看用户名是否存在
    	boolean message=true;
		try{
			session=HibernateUtil.getThreadLocalSession();		
		 // User	user=(User)s.get(User.class, name);		  
		 //   return user;
			transaction=session.beginTransaction();
			 List<User> list = session.createQuery(hql).setString(0, name).list();
	            if(list.isEmpty())
	            {
	            	message=false;
	            }
	            transaction.commit();
	           
		}finally{
			HibernateUtil.closeSession();
		}
		return message;
		
	}
	
	  public boolean findInfo(String username,String passwd){//登录验证用户名，密码
    	boolean message=true;
        session=HibernateUtil.getThreadLocalSession();
        try{
            transaction=session.beginTransaction();
          //  String hql="from User as model where model.username="+username;     
         //   query=session.createQuery(hql);       
         //   List<User>  list=query.list();
            String hql = "FROM User WHERE username = ? AND passwd = ?";
            List<User> list = session.createQuery(hql).setString(0, username).setString(1, passwd).list();
            if(list.isEmpty())
            {
            	message=false;
            }
            transaction.commit();
            
          
        }catch(Exception e){
            message("findInfo.error:"+e);
            e.printStackTrace();
           
        }
		return message;
    }
    
    //实现方法，接收要处理的对象
public User find(User user)throws Exception
{
    //创建数据库连接接口对象
    Connection con = null;
    //创建执行SQL语句的接口
    PreparedStatement prepStmt = null;
    //创建SQL执行完毕后的结果集接口
    ResultSet rs = null;
    //创建返回的对象
    User u = null;
    try
    {
        //数据库连接
        con = DbConnect.getDBconnection();
        //预执行SQL语句
        prepStmt = con.prepareStatement(SELECT_SQL);
        //初始化SQL语句，传递参数值
        prepStmt.setString(1, user.getUser());//第一个?指定为user.getUser()
        prepStmt.setString(2, user.getPassword());//第二个?指定为user.getPassword()
        //执行SQL语句，返回的结果集由rs结果集对象接收
        rs = prepStmt.executeQuery();
        //rs.next()返回查询结果有效true，无效fals
        if (rs.next())
        {
            //查询数据库有该用户，赋值要返回的对象u
            u=new User();
            u.setUser(rs.getString("username"));
            u.setPassword(rs.getString("passwd"));
        }
     }
     catch (Exception localException) {}finally
     {
         DbConnect.closeDB(con, prepStmt, rs);
     }
     //返回对象
     return u;
}
 */
	 public boolean  insert(User user){//添加学生
		   boolean message=false;
	        Connection conn=DataBaseConn.getConnection();
	        PreparedStatement pstmt=null;
	        ResultSet rs=null;
	        try {
	        	String sql="insert into STUDENT values(?,?,?,?,?,?,?)";
	        	pstmt=conn.prepareStatement(sql);
	        	pstmt.setString(1,user.getSno());
	        	pstmt.setString(2, user.getSname());
	        	pstmt.setString(3, user.getPassword());
	        	pstmt.setString(4, user.getSsex());
	        	pstmt.setString(5, user.getSage());
	        	pstmt.setString(6, user.getSdept());
	        	pstmt.setString(7, user.getSclass());
	        	pstmt.executeUpdate();
	        	message=true;
	        	
	        }catch(Exception e) {
	        	
	        }finally {
	        	DataBaseConn.closeConnection(conn);
	        }
	        return message;
	    }
	
	 public boolean findInfo(String username,String passwd,String type){//登录验证用户名，密码
	    	  boolean message=false;
	    	  Connection conn=DataBaseConn.getConnection();
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      String sql=null;
		      try {
		    	  if(type=="1")
		    	  {
		    		//  System.out.println("这里是学生端");
		    	   sql="select * from STUDENT where SNAME='"+username+"'"+" AND PASSWORD=?";
		    	  }
		    	  else
		    	  {
		    		//  System.out.println("这里是教师端");
		    	   sql="select * from TEACHER where TNAME='"+username+"'"+" AND TPASSWORD=?";  
		    	  }
		    	  pstmt=conn.prepareStatement(sql);
		    	  
		    //	  pstmt.setString(1, username);
		    	  pstmt.setString(1, passwd);
		    	//  System.out.println(username+" "+passwd);
		    	  rs = pstmt.executeQuery();
		    	  while(rs.next())
		          {
		    	//System.out.println("hello");
		           message=true;
		          }
		    	//  System.out.println("haha");
		        }catch(Exception e) {
		        	
		        }finally {
		        	DataBaseConn.closeConnection(conn);
		        }
			return message;
	    }
	 
	 /*
	 public boolean  insertGrade(String grade,String sql){//编辑学生成绩
		   boolean message=false;
	        Connection conn=DataBaseConn.getConnection();
	        PreparedStatement pstmt=null;
	        ResultSet rs=null;
	        try {
	        	
	        	pstmt=conn.prepareStatement(sql);
	        	                                                     
	        	message=true;
	        	
	        }catch(Exception e) {
	        	
	        }finally {
	        	DataBaseConn.closeConnection(conn);
	        }
	        return message;
	    }
	 */
	 
	
	 public String findsno(String name){//获得学生学号
   	  String sno=null;
   	  Connection conn=DataBaseConn.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      String sql=null;
	      try {
	    	  sql="select sno from STUDENT where SNAME='"+name+"'";  
	    	  pstmt=conn.prepareStatement(sql);
	    	  rs = pstmt.executeQuery();
	    	  while(rs.next()) {
	    		sno=rs.getString("SNO") ;
	    	  }
	    
	        }catch(Exception e) {
	        	
	        }finally {
	        	DataBaseConn.closeConnection(conn);
	        }
		return sno;
   }
	 
	 public String findtno(String name){//获得学生学号
	   	  String tno=null;
	   	  Connection conn=DataBaseConn.getConnection();
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      String sql=null;
		      try {
		    	  sql="select tno from TEACHER where TNAME='"+name+"'";  
		    	  pstmt=conn.prepareStatement(sql);
		    	  rs = pstmt.executeQuery();
		    	  while(rs.next()) {
		    		tno=rs.getString("TNO") ;
		    	  }
		    
		        }catch(Exception e) {
		        	
		        }finally {
		        	DataBaseConn.closeConnection(conn);
		        }
			return tno;
	   }
   
	 public String findname(String sno){//获得学生姓名
	   	  String sname=null;
	   	  Connection conn=DataBaseConn.getConnection();
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      String sql=null;
		      try {
		    	  sql="select sname from STUDENT where SNO='"+sno+"'";  
		    	  pstmt=conn.prepareStatement(sql);
		    	  rs = pstmt.executeQuery();
		    	  while(rs.next()) {
		    		sname=rs.getString("SNAME") ;
		    	  }
		    
		        }catch(Exception e) {
		        	
		        }finally {
		        	DataBaseConn.closeConnection(conn);
		        }
			return sname;
	   } 
	 
	 public String findcno(String name){//获得课程号
	   	  String cno=null;
	   	  Connection conn=DataBaseConn.getConnection();
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      String sql=null;
		      try {
		    	  sql="select cno from COURSE where CNAME='"+name+"'";  
		    	  pstmt=conn.prepareStatement(sql);
		    	  rs = pstmt.executeQuery();
		          while(rs.next()) {
		        	  cno=rs.getString("CNO");
		          }
		        }catch(Exception e) {
		        	
		        }finally {
		        	DataBaseConn.closeConnection(conn);
		        }
			return cno;
	   }
	 
	 public String findcname(String cno){//获得课程名
	   	  String cname=null;
	   	  Connection conn=DataBaseConn.getConnection();
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      String sql=null;
		      try {
		    	  sql="select cname from COURSE where CNO='"+cno+"'";  
		    	  pstmt=conn.prepareStatement(sql);
		    	  rs = pstmt.executeQuery();
		          while(rs.next()) {
		        	  cname=rs.getString("CNAME");
		          }
		        }catch(Exception e) {
		        	
		        }finally {
		        	DataBaseConn.closeConnection(conn);
		        }
			return cname;
	   }
	 
	 
	 
	 public boolean  insertgrade(String sno,String cno,String grade){//添加学生成绩
		   boolean message=false;
	        Connection conn=DataBaseConn.getConnection();
	        PreparedStatement pstmt=null;
	        ResultSet rs=null;
	        try {
	        	String sql="insert into SCGRADE values(?,?,?)";
	        	pstmt=conn.prepareStatement(sql);
	        	pstmt.setString(1,sno);
	        	pstmt.setString(2,cno);
	        	pstmt.setString(3,grade);
	        	pstmt.executeUpdate();
	        	message=true;
	        	
	        }catch(Exception e) {
	        	
	        }finally {
	        	DataBaseConn.closeConnection(conn);
	        }
	        return message;
	    }
	 
	 
	 /*
	public List<User> findALL() throws Exception {//查询所有记录
	Connection con=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	List<User> list=new ArrayList<User>();
	con=DbConnect.getDBconnection();
	pstm=con.prepareStatement("select * from usern");
	rs=pstm.executeQuery();
	while(rs.next())
	{
		User u2=new User();
		u2.setUser(rs.getString(1));
		u2.setPassword(rs.getString(2));
		list.add(u2);
	}
	DbConnect.closeDB(con, pstm, rs);
	return list;
}
	  
	  	  */
	 
	 public List<User> findALL()  {
	   	  Connection conn=DataBaseConn.getConnection();
	   	List<User> list=new ArrayList<User>();
	   	     
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      String sql=null;
		      try {
		    	  sql="select * from STUDENT order by to_number(SNO)";  
		    	  pstmt=conn.prepareStatement(sql);
		    	  rs = pstmt.executeQuery();
		          while(rs.next()) {
		        	  User user=new User();//必须在这里定义，每次创建新的对象保存不同的信息组，
		        	  //如果在while循环外定义，只新建了一次对象，保存的信息会被下一组覆盖，
		        	  //最后只能保存最后一组数据
		        	 user.setSno(rs.getString(1));
		        	 user.setSname(rs.getString(2));
		        	 user.setPassword(rs.getString(3));
		        	 user.setSsex(rs.getString(4));
		        	 user.setSage(rs.getString(5));
		        	 user.setSdept(rs.getString(6));
		        	 user.setSclass(rs.getString(7));
		        	 list.add(user);
		          }
		        }catch(Exception e) {
		        	
		        }finally {
		        	DataBaseConn.closeConnection(conn);
		        }
			return list;
	   }
	 
	 public String findgrade(String sno,String cno){//学号、课程号查找成绩
   	  String grade=null;
   	  Connection conn=DataBaseConn.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      String sql=null;
	      try {
	    	  sql="select grade from SCGRADE where sno=? and cno=?";
	    	  pstmt=conn.prepareStatement(sql);
	          pstmt.setString(1, sno);
	          pstmt.setString(2, cno);
	    	  rs = pstmt.executeQuery();
	    	  while(rs.next())
	          {
	    	   grade=rs.getString("GRADE");
	          }
	    
	        }catch(Exception e) {
	        	
	        }finally {
	        	DataBaseConn.closeConnection(conn);
	        }
		return grade;
   }
	 
   
	 public List<Course> findCourse()  {
	   	  Connection conn=DataBaseConn.getConnection();
	   	List<Course> list=new ArrayList<Course>();
	   	     
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      String sql=null;
		      try {
		    	  sql="select * from COURSE";  
		    	  pstmt=conn.prepareStatement(sql);
		    	  rs = pstmt.executeQuery();
		          while(rs.next()) {
		        	  Course cuser=new Course();		        	  
		        	  cuser.setCno(rs.getString(1));
		        	  cuser.setCname(rs.getString(2));
		        	 list.add(cuser);
		          }
		        }catch(Exception e) {
		        	
		        }finally {
		        	DataBaseConn.closeConnection(conn);
		        }
			return list;
	   }
	 
	 public List<SCgrade> findSCgrade(String cno)  {
	   	  Connection conn=DataBaseConn.getConnection();
	   	List<SCgrade> list=new ArrayList<SCgrade>();
	   	     
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      String sql=null;
		      try {
		    	  sql="select * from SCGRADE where cno=? order by to_number(grade)";  
		    	  pstmt=conn.prepareStatement(sql);
		    	  pstmt.setString(1, cno);
		    	  rs = pstmt.executeQuery();
		          while(rs.next()) {
		        	  SCgrade scgrade=new SCgrade();		        	  
		        	  scgrade.setSno(rs.getString(1));
		        	  scgrade.setCno(rs.getString(2));
		        	  scgrade.setGrade(rs.getString(3));
		        	 list.add(scgrade);
		          }
		        }catch(Exception e) {
		        	
		        }finally {
		        	DataBaseConn.closeConnection(conn);
		        }
			return list;
	   }
	 
	 public String delete(String sno) throws Exception {//删除学生对象
		 Connection conn=DataBaseConn.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      String sql=null;
	      String sql2=null;
			try{
				sql="delete from STUDENT where sno=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,sno);
				pstmt.executeUpdate();
				sql2="delete from SCGRADE where sno=?";
				pstmt=conn.prepareStatement(sql2);
				pstmt.setString(1,sno);
				pstmt.executeUpdate();
			}catch(Exception e){		
			}finally{
				DataBaseConn.closeConnection(conn);
			}
			return null;
		}
	 
	 
	 public String update(String sql) throws Exception {
		 Connection conn=DataBaseConn.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	    
			try{
				
				pstmt=conn.prepareStatement(sql);
				
				int n=pstmt.executeUpdate();
				
			}catch(Exception e){
			}finally{
				DataBaseConn.closeConnection(conn);
			}
			return null;
		}
	 /*
	public User update(User user) throws Exception {
	Connection con=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	try{
		con=DbConnect.getDBconnection();
		pstm=con.prepareStatement(UPDATE_SQL);
		pstm.setString(1, user.getUser());
		pstm.setString(2, user.getPassword());
		pstm.setString(3, user.getUser());
		int n=pstm.executeUpdate();
		if(n==0){
			throw new Exception("Update Error:username:"+user.getUser());
		}
	}catch(Exception e){
	}finally{
		DbConnect.closeDB(con, pstm, rs);
	}
	return null;
}
		*/
	    
}
