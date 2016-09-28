package com.seven.demo;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class DemoInterceptor implements Interceptor{

	public void intercept(Invocation inv) {
		System.out.println("Before method invoking:"+inv.getMethodName());
		inv.invoke();
		System.out.println("After method invoking");
	}

}
