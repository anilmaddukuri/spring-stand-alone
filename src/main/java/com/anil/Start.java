package com.anil;


/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("Start")
public class Start {

	//Log log = LogFactory.getLog(Start.class);
	Logger logger = LoggerFactory.getLogger(Start.class);
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/applicationcontext.xml");
		MyBean bean = (MyBean) context.getBean("MyBean");
		bean.myMethod();
		Start start = (Start) context.getBean("Start");
		start.methodInStart();
		context.close();
	}
	
	public void methodInStart() {
		logger.error("method in start class called - error");
		logger.debug("debug");
	}
}
