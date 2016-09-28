package com.seven.demo;

import com.jfinal.core.Controller;

public class SessionController extends Controller{
	
	//session操作的方法
	public void setSession(){
		setSessionAttr("lkk","lkk");
		redirect("/index");
	}
}
