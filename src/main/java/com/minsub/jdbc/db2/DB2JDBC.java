package com.minsub.jdbc.db2;

import java.sql.DriverManager;

import com.minsub.jdbc.JDBC;

public class DB2JDBC extends JDBC{
	public static final String NAME_DB2_DRIVER = "com.ibm.db2.jcc.DB2Driver";
	public static final String URL_DB2 = "jdbc:db2://localhost:50000/sample";
	private static final String ID = "db2admin"; 
	private static final String PWD = "db2admin";
	
	@Override
	public boolean createConnection() {
		try {
			Class.forName(NAME_DB2_DRIVER);
			super.conn = DriverManager.getConnection(URL_DB2, ID, PWD);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}	
}
