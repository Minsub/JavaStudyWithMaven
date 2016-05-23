package com.minsub.jdbc.db2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.minsub.jdbc.JDBC;

public class ExportToExcelByQuery {
	private JDBC jdbc = null;

	private ExportToExcelByQuery() {}
	
	public ExportToExcelByQuery(JDBC jdbc) {
		if (jdbc == null) {
			jdbc = new AS400(); //default JDBC
		} else {
			this.jdbc = jdbc;
		}
	}
	
	
	//test
//	public static void main(String[] args) {
//		ExportToExcelByQuery obj = new ExportToExcelByQuery();
//		try{		
//			// Sql
//			QueryBuilder sqlBuilder = new Query20140715();
//			
//			obj.excute("C:/jiminsub/test.csv", sqlBuilder.getQuery("20130101", "20130199"));
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//		}
//	}
	
	public void excute(String fileName, String query) {
		System.out.println("Start Exporting to: "+ fileName);
		BufferedWriter bw = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			if (jdbc.createConnection()) {
				con = jdbc.getConnection();
			} else {
				System.out.println("JDBC fail");
				return;
			}
			
			// file io object
			bw = new BufferedWriter(new FileWriter(fileName));
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			System.out.println("excute Query");
			
			
			boolean isFirst = true;
			ResultSetMetaData meta = null;
			int cnt = 0;
			while(rs.next()){
				//Head Column
				if(isFirst){
					meta = rs.getMetaData();
					//Column Write
					for(int i=0; i<meta.getColumnCount(); i++){
						bw.write(meta.getColumnName(i+1));
						bw.write(",");
					}
					bw.write("\n");
					isFirst = false;
				}
				
				cnt++;
				if(cnt%100==0){
					System.out.println("Count : " + cnt);
					bw.flush();
				}
				
				//Column Write
				for(int i=0; i<meta.getColumnCount(); i++){
					String temp= rs.getString(i+1);
					if(temp!=null){
						bw.write(rs.getString(i+1).replace(',', ' '));
					}else{
						bw.write(" ");
					}
					bw.write(",");
				}
				bw.write("\n");
			}	
			bw.flush();
			System.out.println("Finish Exporting");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try {
				bw.close();
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
