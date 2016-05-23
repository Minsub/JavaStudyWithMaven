package com.minsub.api;

import java.io.File;
import java.io.IOException;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

public class OCR extends Thread {

	static final String PATH = "C:/apache-tomcat-7.0.25/webapps/ROOT/TEST/";
	
	static final String SAMPLE_FILE_1 = "errorfile.xlsx";
	static final String SAMPLE_FILE_2 = "bigsize.xls";
	static final String SAMPLE_FILE_NORMAL_1 = "normal1.xls";
	static final String SAMPLE_FILE_NORMAL_2 = "normal2.xls";
	static final String SAMPLE_FILE_NORMAL_3 = "normal3.xls";
	
	static final String[] arrSample = {SAMPLE_FILE_NORMAL_1, SAMPLE_FILE_1, SAMPLE_FILE_NORMAL_3, SAMPLE_FILE_2, SAMPLE_FILE_NORMAL_2 };
//	static final String[] arrSample = {SAMPLE_FILE_2};
//	static final String[] arrSample = { SAMPLE_FILE_NORMAL_1, SAMPLE_FILE_NORMAL_2, SAMPLE_FILE_NORMAL_3};
	
	private String fileName = null;
	
	OfficeManager officeManager = null;
	private File inFile = null; 
	private File outFile = null;
	
	public static void main(String[] args) {
		OfficeManager om = null;
//		om = new DefaultOfficeManagerConfiguration()
//				.setProcessManager(new SigarProcessManager())
//				.setTaskExecutionTimeout(8000L)
//				.buildOfficeManager();
//		om.start();
		
		try {
			for (int i=0; i < arrSample.length; i++) {
				OCR converter = new OCR(arrSample[i]);
				converter.setOfficeManager(om);
				
				System.out.println(i+"   Start Thread for " + arrSample[i] );
				converter.start();
				converter.join(1000 * 20);
				converter.interrupt();
				Thread.sleep(3000);
				
//				converter.convertToPDF(arrSample[i], om);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (om != null) { 
				om.stop();
				om = null;
			}
		}
		System.out.println("-------------------");
		

	}
	
	public void setOfficeManager(OfficeManager officeManager){
		this.officeManager = officeManager;
	}

	public OCR(String fileName) {
		this.fileName = fileName;
	}
	
	public void convertToPDF(String fileName) {
		OfficeManager officeManager = null;
		try {
			inFile = new File(PATH, fileName);
			fileName = fileName.substring(0, fileName.indexOf("."));			
			outFile = new File(PATH + fileName + ".pdf");
			
			officeManager = new DefaultOfficeManagerConfiguration()
								 //.setProcessManager(new SigarProcessManager())
								 .buildOfficeManager();
		    officeManager.start();
			
		    System.out.println("converting...");
			
		    OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
		    converter.convert(inFile, outFile);
		        
			System.out.println("<<finished converting!!>>");
			
		} catch (Exception e) { 
			System.out.println("$$$$Failed to convert$$$$");
//			e.printStackTrace(); 
			try {
				Runtime.getRuntime().exec("taskkill /F /IM soffice.bin");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
		finally { 
			if (officeManager!=null) { 
				officeManager.stop();
				officeManager = null;
			}
		}
	}

	@Override
	public void run() {
		convertToPDF(fileName);
	}
	
	

}

