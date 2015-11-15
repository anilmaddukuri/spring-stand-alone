package com.anil;

import org.springframework.stereotype.Component;

@Component("MyBean")
public class MyBean {

	public void myMethod() {
		System.out.println("My method called");
	}

}
