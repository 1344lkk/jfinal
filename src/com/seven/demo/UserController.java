package com.seven.demo;


import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class UserController extends Controller{
//	@ActionKey("/login")
	public void login(){
		renderText("��¼�ɹ�������");
	}
	
	public void regedist(){
		//User user = getModel(User.class);
		String name = getPara("user.name");
		System.out.println(name);
		renderText("��ȡ�ɹ�������");
	}
	
	//�ļ��ϴ�����
	public void submit(){
		UploadFile uploadFile = getFile("file");
		renderText("�ϴ��ɹ�");
	}
	
	public void download(){
		renderFile("3c30700efb_96.ico");
	}

}
