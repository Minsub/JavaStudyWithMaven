package com.minsub.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {
	public static final String FILE1 = "src/log4j.properties";
	public static final String FILE2 = "src/log4j.test.sample";
	public static final String FILE3 = "io_test.txt";

	public static void main(String[] args) {
//		NIO.NIOsample();
		NIO.NIOsample2();
	}
	
	public static void NIOsample2() {
		try {
			RandomAccessFile rf = new RandomAccessFile(new File(FILE3), "rw");
			FileChannel channel = rf.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocateDirect(5);
			buffer.clear();
			
			// original : ABCDE12345FGHIJ67890
			// converted: ABCDE12345ABCDE67890
			rf.seek(0);
			channel.read(buffer);
			buffer.flip();
			
			
			rf.seek(10);
			channel.write(buffer);
			
			channel.close();
			rf.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void NIOsample() {
		try {
			FileInputStream fis = new FileInputStream(new File(FILE1));
			FileOutputStream fos = new FileOutputStream(new File(FILE2));
			
			FileChannel fic = fis.getChannel();
			FileChannel foc = fos.getChannel();
			
//			ByteBuffer buffer = ByteBuffer.allocate(1024);		
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			
			while(true) {
				int ret = fic.read(buffer);
				
				if(ret != -1) {
					buffer.flip();
					foc.write(buffer);
					buffer.clear();
					
				} else {
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO resource close()
		}
	}
}

