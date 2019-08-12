package com.atguigu.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;

public class OperateAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String addUser() {
		System.out.println("添加用户");
		return SUCCESS;
	}
	public String deleteUser() {
		System.out.println("删除用户");
		return SUCCESS;
	}
	public String updateUser() {
		System.out.println("修改用户");
		return SUCCESS;
	}
	public String selectUser(){
		System.out.println("查找用户");
		return SUCCESS;
	}
	
	public String execute(){
		return SUCCESS;
	}
}
