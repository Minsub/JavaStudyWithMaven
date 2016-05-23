package com.minsub.api;

import org.apache.log4j.Logger;



public class TestLog4j {
	
	static Logger logger = Logger.getLogger(TestLog4j.class.getName());
	
	public static void main(String[] args) {
		logger.info("info message");
		logger.debug("debug message");
		logger.error("error message");

		
	
	}

}
