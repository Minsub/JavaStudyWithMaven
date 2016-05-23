package com.minsub.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileIOTest {

	public static void main(String[] args) {
//		FileIOTest.FileReadWrite();
		FileIOTest.randomAccessFile();
	}

	public static void FileReadWrite() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/log4j.properties")));
			String str = null;
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/log4j.test.sample")));
			
			while((str = br.readLine()) != null) {
				System.out.println(str);
				bw.write(str+"\n");
			}
			bw.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void randomAccessFile() {
		try {
			RandomAccessFile rf = new RandomAccessFile(new File("src/log4j.test.sample"), "rw");
			long pointer = rf.getFilePointer();
			System.out.println("pointer: " + pointer);
			
			String str = null;
			
			rf.seek(100);
			
			while((str = rf.readLine()) != null) {
				System.out.println(str);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
