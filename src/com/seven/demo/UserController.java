package com.seven.demo;


import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class UserController extends Controller{
//	@ActionKey("/login")
	public void login(){
		renderText("登录成功。。。");
	}
	
	public void regedist(){
		//User user = getModel(User.class);
		String name = getPara("user.name");
		System.out.println(name);
		renderText("获取成功。。。");
	}
	
	//文件上传方法
	public void submit(){
		UploadFile uploadFile = getFile("file");
		renderText("上传成功");
	}
	
	public void download(){
		renderFile("3c30700efb_96.ico");
	}

}
