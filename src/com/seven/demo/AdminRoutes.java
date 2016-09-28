package com.seven.demo;

import com.jfinal.config.Routes;

public class AdminRoutes extends Routes{

	@Override
	public void config() {
		add("/admin/user",UserController.class);
		
	}

}
