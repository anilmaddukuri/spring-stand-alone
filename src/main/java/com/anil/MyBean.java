package com.anil;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("MyBean")
public class MyBean {

	public void myMethod() {
		System.out.println("My method called");
	}
	
	@Transactional
	public void myTransactionalMethod() {
		
	}
}
