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
	 * configConstant():�˷����������� JFinal ����ֵ���翪��ģʽ���� devMode �����ã�
	 * Ĭ����ͼ���� ViewType�����ã����´��������� JFinal �����ڿ���ģʽ����Ĭ����ͼ����Ϊ JSP
	 */
	
	public void configConstant(Constants constant) {
		constant.setDevMode(true);
		constant.setBaseUploadPath("newUpload");  //�����ļ��ϴ���·��
		constant.setBaseDownloadPath("newUpload"); //�����ļ�����·��
		constant.setViewType(ViewType.JSP);
		
	}
	
	/*
	 * �˷����������� JFinal ����·�ɣ����´��������˽���/hello��ӳ�䵽 HelloController ������� �� ��
	 * ͨ �� �� �� �� �� �� �� http://localhost/hello �� �� �� HelloController.index() �� �� ��
	 * ��http://localhost/hello/methodName �����ʵ� HelloController.methodName()������
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
	 * �˷����������� JFinal �� Plugin�����´��������� C3p0 ���ݿ����ӳز���� ActiveRecord
	 * ���ݿ���ʲ���� ͨ�����µ����ã� ������Ӧ����ʹ�� ActiveRecord �ǳ�����ز������ݿ⡣
	 */
	public void configPlugin(Plugins plugin) {
/*		Properties p = loadPropertyFile("../db.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(p.getProperty("jdbcUrl"), p.getProperty("username"), 
				                               p.getProperty("password"));
		plugin.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		plugin.add(arp);
		arp.addMapping("user", User.class);*/
		
		//����redis��������
		RedisPlugin redisPlugin = new RedisPlugin("main", "127.0.0.1");
		plugin.add(redisPlugin);
		
	}
	
	
	/*
	 * �˷����������� JFinal �� Handler�� ���´�����������Ϊ ResourceHandler�Ĵ������� Handler���Խӹ����� web ����
	 * ����Ӧ��ӵ����ȫ�Ŀ���Ȩ�����Ժܷ����ʵ�ָ��߲�Ĺ�������չ��
	 */
	public void configHandler(Handlers handler) {}

	/*
	 * �˷����������� JFinal ��ȫ����������ȫ������������������ action ���󣬳���ʹ��
	 * @Clear �� Controller �����
	 */
	public void configInterceptor(Interceptors interceptor) {
		interceptor.add(new DemoInterceptor());
	}	
	/*
	 * �������������Ժܷ��������Ŀ��������ر�ǰ�ÿ������л�����ж��������
	 * ����ϵͳ�����󴴽������̻߳���ϵͳ�ر�ǰд�ػ���
	 */
	public void afterJFinalStart() {
		System.out.println("ϵͳ���������");
	}
	public void beforeJFinalStop() {
		System.out.println("ϵͳ�ر�ǰ����");
	}

}
