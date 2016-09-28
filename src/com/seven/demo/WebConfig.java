package com.seven.demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.handler.Handler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CPI;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.IMainRenderFactory;
import com.jfinal.render.ViewType;

public class WebConfig extends JFinalConfig{

	/*
	 * configConstant():此方法用来配置 JFinal 常量值，如开发模式常量 devMode 的配置，
	 * 默认视图类型 ViewType的配置，如下代码配置了 JFinal 运行在开发模式下且默认视图类型为 JSP
	 */
	
	public void configConstant(Constants constant) {
		constant.setDevMode(true);
		constant.setBaseUploadPath("newUpload");  //设置文件上传的路径
		constant.setBaseDownloadPath("newUpload"); //设置文件下载路径
		constant.setViewType(ViewType.JSP);
		
	}
	
	/*
	 * 此方法用来配置 JFinal 访问路由，如下代码配置了将”/hello”映射到 HelloController 这个控制 器 ，
	 * 通 过 以 下 的 配 置 ， http://localhost/hello 将 访 问 HelloController.index() 方 法 ，
	 * 而http://localhost/hello/methodName 将访问到 HelloController.methodName()方法。
	 */
	public void configRoute(Routes route) {
		route.add("/hello" , HelloController.class);
		route.add("/user", UserController.class);
		route.add("/session", SessionController.class);
		route.add("/index",IndexController.class);
		route.add(new FrontRoutes());
		route.add(new AdminRoutes());
	}

	
	/*
	 * 此方法用来配置 JFinal 的 Plugin，如下代码配置了 C3p0 数据库连接池插件与 ActiveRecord
	 * 数据库访问插件。 通过以下的配置， 可以在应用中使用 ActiveRecord 非常方便地操作数据库。
	 */
	public void configPlugin(Plugins plugin) {
/*		Properties p = loadPropertyFile("../db.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(p.getProperty("jdbcUrl"), p.getProperty("username"), 
				                               p.getProperty("password"));
		plugin.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		plugin.add(arp);
		arp.addMapping("user", User.class);*/
		
		//操作redis的主缓存
		RedisPlugin redisPlugin = new RedisPlugin("main", "127.0.0.1");
		plugin.add(redisPlugin);
		
	}
	
	
	/*
	 * 此方法用来配置 JFinal 的 Handler， 如下代码配置了名为 ResourceHandler的处理器， Handler可以接管所有 web 请求，
	 * 并对应用拥有完全的控制权，可以很方便地实现更高层的功能性扩展。
	 */
	public void configHandler(Handlers handler) {}

	/*
	 * 此方法用来配置 JFinal 的全局拦截器，全局拦截器将拦截所有 action 请求，除非使用
	 * @Clear 在 Controller 中清除
	 */
	public void configInterceptor(Interceptors interceptor) {
		interceptor.add(new DemoInterceptor());
	}	
	/*
	 * 这两个方法可以很方便地在项目启动后与关闭前让开发者有机会进行额外操作，
	 * 如在系统启动后创建调度线程或在系统关闭前写回缓存
	 */
	public void afterJFinalStart() {
		System.out.println("系统开启后调用");
	}
	public void beforeJFinalStop() {
		System.out.println("系统关闭前调用");
	}

}
