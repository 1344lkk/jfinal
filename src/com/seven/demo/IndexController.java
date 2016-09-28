package com.seven.demo;

import com.jfinal.core.Controller;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;

public class IndexController extends Controller{
	
	//跳转到首页
	public void index(){
		render("/index.jsp");
	}
	
	//renderJson：操作json
	public void getJson(){
		setAttr("name", "lkk");
		setAttr("age", 22);
		renderJson();
	}
	
	public void getRedis(){
		//获取名称为main的Redis Cache对象
		Cache cache = Redis.use();
		//cache.set("name","lkk");
		System.out.println(cache.get("name"));
		renderNull();
	}
}
