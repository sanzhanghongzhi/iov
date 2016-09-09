package com.zbmatsu.iov.common.web;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Startup {

	@PostConstruct
	void init() {
		
		//1.注解解析
		customAnnotationInit();
	}
	
	/**
	 * 
	 */
	public void customAnnotationInit(){
		System.out.println("test init......");
	}
}
