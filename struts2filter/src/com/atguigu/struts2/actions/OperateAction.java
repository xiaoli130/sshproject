package com.atguigu.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;

public class OperateAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String addUser() {
		System.out.println("����û�");
		return SUCCESS;
	}
	public String deleteUser() {
		System.out.println("ɾ���û�");
		return SUCCESS;
	}
	public String updateUser() {
		System.out.println("�޸��û�");
		return SUCCESS;
	}
	public String selectUser(){
		System.out.println("�����û�");
		return SUCCESS;
	}
	
	public String execute(){
		return SUCCESS;
	}
}
