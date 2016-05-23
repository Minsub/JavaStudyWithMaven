package com.minsub.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AS400Main {
	public static final String CLASS_NAME_DBMS_DB2 = "com.minsub.jdbc.db2.AS400";

	public static void main(String[] args) {
		// Factory�� ���� String���� �Է¹��� DB����� JDBC ��ü�� �� 
		JDBC jdbc = FactoryJDBC.createJDBC(CLASS_NAME_DBMS_DB2);
		if (jdbc != null) {
			AS400Main main = new AS400Main();
			
			main.selectAll(jdbc);

			
			jdbc.close();
		}

	}

	boolean selectAll(JDBC jdbc) {
		//String sql = "SELECT * from PLIBBK.BKGAASIAG"; //
		/*
		String sql = 
		"SELECT (CASE WHEN MFEDAT LIKE '%ERP%' THEN SUBSTR(MFEDAT,7,13) ELSE SUBSTR(MFEDAT,7,70) END) MSG "
		+"FROM PLIBSD.MFKRARCV "
		+"WHERE MFENUM = '14HDMUA4239HDMU0026' AND MFEDOC='SCA' AND MFERSP='5VL' "
		+"AND (MFEDAT LIKE '%FTX%' OR MFEDAT LIKE '%ERP%')";
		*/
		
		String sql = "SELECT (CASE WHEN MFEDAT LIKE '%ERP%' THEN SUBSTR(MFEDAT,7,13) ELSE SUBSTR(MFEDAT,7,70) END) MSG "
						+"FROM PLIBSD.MFKRARCV "
						+"WHERE MFENUM = '14HDMUA4239HDMU0026' AND MFEDOC='SCA' AND MFERSP='5VL' "
						+"AND (MFEDAT LIKE '%FTX%' OR MFEDAT LIKE '%ERP%')";

		PreparedStatement stmt;
		
		try {
			stmt = jdbc.getConnection().prepareStatement(sql);
			

			ResultSet rs = stmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				String name = rs.getString("MSG");
				System.out.println( (cnt++) + ", " + name);
				
			}
			System.out.print("value count: " + cnt) ;
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
