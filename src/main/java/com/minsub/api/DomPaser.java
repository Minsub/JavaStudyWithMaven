package com.minsub.api; 

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


public class DomPaser {

	public static void main(String[] args) throws Exception{
//		usingSAX();
		TEST();
		
//		String test = System.getProperty("office.home");
//		System.out.println(test);
	}
	
	public static void usingSAX() {
		try {
		   SAXBuilder builder = new SAXBuilder();
		   Document doc = builder.build(new File("nations.xml"));
		   Element root = doc.getRootElement();
		   
		   System.out.println(root.getAttribute("email").getValue());
		   
		   List<Element> list = root.getChildren();
		   
		   for(Element item: list) {
			   if (item.getName().equalsIgnoreCase("name")) {
				   System.out.println(item.getText());
			   }
		   }
			   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void usingCommonConf() throws ConfigurationException {
		XMLConfiguration xml = new XMLConfiguration("C:/JavaCOP/nations.xml");
		
		List<Object> list = xml.getList("name");

		
		System.out.println(list.size());
		
		for(Object item: list)
			System.out.println((String)item);
		
		Iterator<String> iter = xml.getKeys();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("EMAIL: "+ xml.getString("test[@url]"));
	}
	
	public static void TEST() throws ConfigurationException {
		XMLConfiguration xml = new XMLConfiguration("C:/JavaCOP/nations.xml");
		
		List<Object> list = xml.getList("nation[@addr]");

		
		System.out.println(list.size());
		
		for(Object item: list)
			System.out.println((String)item);
		
		Iterator<String> iter = xml.getKeys();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("EMAIL: "+ xml.getString("test[@url]"));
	}
}
