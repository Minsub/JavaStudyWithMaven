package com.minsub.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMain {
	public static final String CLASS_NAME_DBMS_DB2 = "com.minsub.jdbc.db2.DB2JDBC";

	public static void main(String[] args) {
		// Factory�� ���� String���� �Է¹��� DB����� JDBC ��ü�� �� 
		JDBC jdbc = FactoryJDBC.createJDBC(CLASS_NAME_DBMS_DB2);
		if (jdbc != null) {
			JDBCMain main = new JDBCMain();
			main.selectAll(jdbc);

			//main.insert(jdbc);
			jdbc.close();
		}

	}

	boolean selectAll(JDBC jdbc) {
		String sql = "select * from PERS"; //

		PreparedStatement stmt;
		try {
			stmt = jdbc.getConnection().prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("NAME");
				String job = rs.getString("job");
				int no = rs.getInt("ID");
				System.out.println(no + " : " + name + " : " + job);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	boolean insert(JDBC jdbc) {
		String query = "INSERT INTO PERS VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = jdbc.getConnection().prepareStatement(query);

			String strNameList[] = { "Smith", "Fiona", "Roy", "Daniel", "Gabriel" };

			for (int i = 1; i <= 10; i++) {
				stmt.setInt(1, i); // ID
				stmt.setString(2, strNameList[i & 4]); // NAME
				stmt.setInt(3, ((i > 5) ? 20 : 40)); // DEPT
				stmt.setString(4, ((i > 5) ? "PRM" : "ENG")); // JOB
				stmt.setInt(5, (i > 5) ? 4 : 7); // YEARS
				stmt.setFloat(6, i * 1000.0f); // SALARY
				stmt.setFloat(7, i * 150.0f); // COMM
				stmt.setString(8, ("1984-3-" + i)); // DATE
				stmt.addBatch();
				stmt.clearParameters();
				// stmt.execute();
				// stmt.clearParameters();
			}
			stmt.executeBatch();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
