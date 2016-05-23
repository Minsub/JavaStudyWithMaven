package com.minsub.jdbc.db2;

import java.sql.DriverManager;

import com.minsub.jdbc.JDBC;

public class AS400 extends JDBC{
	public static final String NAME_AS400_DRIVER = "com.ibm.as400.access.AS400JDBCDriver";
	public static final String URL_AS400 = "jdbc:as400://203.242.32.18";
	private static final String ID = "dpbizjms"; 
	private static final String PWD = "jiminsub1";
	
	@Override
	public boolean createConnection() {
		try {
			Class.forName(NAME_AS400_DRIVER);
			super.conn = DriverManager.getConnection(URL_AS400, ID, PWD);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}	
}
