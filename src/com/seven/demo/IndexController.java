package com.seven.demo;

import com.jfinal.core.Controller;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;

public class IndexController extends Controller{
	
	//��ת����ҳ
	public void index(){
		render("/index.jsp");
	}
	
	//renderJson������json
	public void getJson(){
		setAttr("name", "lkk");
		setAttr("age", 22);
		renderJson();
	}
	
	public void getRedis(){
		//��ȡ����Ϊmain��Redis Cache����
		Cache cache = Redis.use();
		//cache.set("name","lkk");
		System.out.println(cache.get("name"));
		renderNull();
	}
}
