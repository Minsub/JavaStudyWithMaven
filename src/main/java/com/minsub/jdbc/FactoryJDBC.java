package com.minsub.jdbc;

/**
 * JDBC 객체를 생성하는 목적의 Factory
 * 들어오는 클래스 이름에 따라 동적으로 객체를 생성한다. 
 * @author Minsub ji
 */
public class FactoryJDBC {
	/**
	 * 
	 * @param className for creating dynamic class
	 * @return
	 */
	public static JDBC createJDBC(String className) {
		try {
			Object obj = Class.forName(className).newInstance();
			JDBC jdbc = (JDBC)obj;
			jdbc.createConnection();
			
			return jdbc;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
