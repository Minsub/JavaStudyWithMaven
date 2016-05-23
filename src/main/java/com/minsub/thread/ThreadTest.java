package com.minsub.thread;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ThreadTest extends Thread{
	public static final int CNT = 5;  
	
	@Override
	public void run() {
		boolean isFinish = false;
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Sub:" + i);
				Thread.sleep(1000);
			}
			isFinish = true;
		} catch (InterruptedException e) {
			System.out.println("Sub: INTERRUPT");
			if (!isFinish) {
				System.out.println("Sub: 자원해제");
			}
			return;
		}
	}
	
	public static String getTimeNow() {

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
	// Main Function
	public static void main(String[] args) {
		
		try {
			int cnt = 0;
			while(cnt++ < 3) {
				ThreadTest t = new ThreadTest();
				System.out.println("Main: Start");
				t.start();
				System.out.println("Main: wait 7 minite for sub thread");
				t.join(3000);
				t.interrupt();
				System.out.println("Main: END");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
