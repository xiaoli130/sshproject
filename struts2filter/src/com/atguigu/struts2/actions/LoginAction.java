package com.atguigu.struts2.actions;

import java.util.Map;

import com.atguigu.struts2.entities.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception{
		System.out.println(user.getUsername()+" "+user.getPassword());
			if(user.getUsername().equals("xiaoli") && user.getPassword().equals("123456")){  //dao
				Map<String,Object> session=ActionContext.getContext().getSession();  
				session.put("username",user.getUsername());
				return "main";
			}else{
				return "error";
			}
	}
}
