package com.minsub.commonlib.lang;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestIOUtils {

	public static void main(String[] args) {
		try {
			List<String> list = FileUtils.readLines(new File("src/log4j.properties"));
			Iterator iter = list.iterator();
			String str;
			while(iter.hasNext()) {
				str = (String)iter.next();
				System.out.println(str);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
