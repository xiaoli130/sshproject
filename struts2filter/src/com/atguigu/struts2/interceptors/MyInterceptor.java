package com.atguigu.struts2.interceptors;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.atguigu.struts2.entities.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class MyInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation arg0) throws Exception{
		Map<String,Object> session=ActionContext.getContext().getSession();
		String username=(String) session.get("username");
		if(username==null || username.equals(""))
			return "input";
		else
			return arg0.invoke();
	}
}
