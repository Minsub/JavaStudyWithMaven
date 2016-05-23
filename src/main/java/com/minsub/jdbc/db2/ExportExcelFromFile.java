package com.minsub.jdbc.db2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExportExcelFromFile {
	
	private static final String DEFAULT_PATH = "C:/tmp.csv";
	
	public static void main(String[] args) {
		
		if (args[0] == null ){System.out.println("file path must be required"); return;}
		try{
			File file = new File(args[0]);
			
			String path = DEFAULT_PATH;
			if (args[1] != null) {
				path = args[1];
			} 
			
			ExportToExcelByQuery obj = new ExportToExcelByQuery(new AS400());
			obj.excute(path, getQuery(file));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	private static String getQuery(File file) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str;
		while((str = br.readLine()) != null) {
			System.out.println(str);
			sb.append(str+"\n");
		}
		
		return sb.toString();
	}

}
