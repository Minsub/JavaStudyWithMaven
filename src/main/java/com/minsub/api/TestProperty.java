package com.minsub.api;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class TestProperty {

	public static void main(String[] args) throws ConfigurationException {
//		getProerty();
		getProertyUsingCC();
	}
	
	public static void getProerty() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File("src/db2.properties")));
			String driver = (String)p.get("driver");
			
			
			System.out.println("driver: " +p.get("log4j.logger"));
			System.out.println(p.getProperty("url"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getProertyUsingCC() throws ConfigurationException {
		PropertiesConfiguration pc = new PropertiesConfiguration("log4j.properties");
		Iterator iter = pc.getKeys();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		p("-----------------------");
		p(pc.getString("log4j.appender."));
		List<Object> list = pc.getList("log4j.");
		for (Object item: list) {
			p((String)item);
		}
		
		
		
		pc.addConfigurationListener(new ConfigurationListener() {

			public void configurationChanged(ConfigurationEvent event) {
				
				p("Listener: "+event.getSource().toString());
				
			}
		});
		//pc.setProperty("NEWONE", "NEWNEWNEW");
		//pc.save();
	}
	
	public static void p(String s) {
		System.out.println(s);
	}
}
