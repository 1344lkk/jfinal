package com.seven.demo;

import com.jfinal.config.Routes;
/**
 * Ç°¶ËÂ·ÓÉ
 * @author Administrator
 *
 */
public class FrontRoutes extends Routes{

	public void config() {
		add("/front", HelloController.class);
	}

}
