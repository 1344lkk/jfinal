package com.seven.demo;

import com.jfinal.core.Controller;

public class SessionController extends Controller{
	
	//session�����ķ���
	public void setSession(){
		setSessionAttr("lkk","lkk");
		redirect("/index");
	}
}
