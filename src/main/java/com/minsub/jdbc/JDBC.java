package com.minsub.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class JDBC {
	 protected Connection conn = null;
	 
	 /**
	  * 
	  * @return success: true, failure: false 
	  */
	 public abstract boolean createConnection();
	 
	 /**
	  * Connection 리소스 반환 
	  * @throws SQLException
	  */
	 public void close() {
		 if (conn != null) {
			 try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	 }
	 
	 /**
	  * @return Connecton
	  */
	 public Connection getConnection() {
		 return conn;
	 }
}
