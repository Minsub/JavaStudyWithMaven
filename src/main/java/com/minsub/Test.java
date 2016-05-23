package com.minsub;

import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		String str = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		
		System.out.println(str);
		
		
		String aa = "1234567890";
		
	}

}