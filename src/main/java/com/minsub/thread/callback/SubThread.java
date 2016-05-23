package com.minsub.thread.callback;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SubThread extends Thread {

	private int value = 0;
	private CallBackInter callback = null;
	
	public SubThread() {}
	
	public SubThread(int value, CallBackInter callback) {
		this.value = value;
		this.callback = callback;
	}
	
	
	public static String getTimeNow() {

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < value; i++) {
			System.out.println("SUB: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("SUB: INTERRUP EXCEPTION:" + getTimeNow());
				return;
			}
		}
		callback.Tfinish();
	}

}
