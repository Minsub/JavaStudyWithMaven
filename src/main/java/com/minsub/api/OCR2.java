package com.minsub.api;

import java.io.File;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeConnectionProtocol;
import org.artofsolving.jodconverter.office.OfficeManager;



public class OCR2 {
	
	static final String PATH = "C:/apache-tomcat-7.0.25/webapps/ROOT/TEST/";
	
	static final String SAMPLE_FILE_1 = "errorfile.xlsx";
	static final String SAMPLE_FILE_2 = "bigsize.xls";
	static final String SAMPLE_FILE_NORMAL_1 = "normal1.xls";
	static final String SAMPLE_FILE_NORMAL_2 = "normal2.xls";
	static final String SAMPLE_FILE_NORMAL_3 = "normal3.xls";
	
//	static final String[] arrSample = {SAMPLE_FILE_NORMAL_1, SAMPLE_FILE_1, SAMPLE_FILE_NORMAL_3, SAMPLE_FILE_2, SAMPLE_FILE_NORMAL_2 };
//	static final String[] arrSample = {SAMPLE_FILE_2};
	static final String[] arrSample = {SAMPLE_FILE_NORMAL_1, SAMPLE_FILE_NORMAL_2, SAMPLE_FILE_NORMAL_3};
	
	public static void main(String[] args) {
		OfficeManager officeManager = new DefaultOfficeManagerConfiguration()
											.buildOfficeManager();
		officeManager.start();
		
		String fileName = SAMPLE_FILE_NORMAL_1;
		File inFile = new File(PATH, fileName);
		
		File inFile2 = new File(PATH, SAMPLE_FILE_NORMAL_2);
		File inFile3 = new File(PATH, SAMPLE_FILE_NORMAL_3);
		
		fileName = fileName.substring(0, fileName.indexOf("."));			
		File outFile = new File(PATH + fileName + ".pdf");
		
		File outFile2 = new File(PATH + 2 + ".pdf");
		
		File outFile3 = new File(PATH + 3 + ".pdf");
		
		
		System.out.println("converting...");
		
	    OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
	    converter.convert(inFile, outFile);
	    
	    converter.convert(inFile2, outFile2);
	    
	    converter.convert(inFile3, outFile3);
	        
		System.out.println("<<finished converting!!>>");
		
		officeManager.stop();
	}

}
