package com.minsub.thread.callback;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Main extends Thread implements CallBackInter{
	
	public static String getTimeNow() {

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
	@Override
	public void run() {
		int cnt = 0;
		while (cnt++ < 5) {
			System.out.println("MAIN: START, " + getTimeNow());
			Thread thread = new SubThread(3, this);
			thread.start();
			
			try {
				synchronized (this) {
					System.out.println("MAIN: 5ÃÊ ´ë±â");
					this.wait(10000);
				}
							
				thread.interrupt();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("MAIN: END,  " + getTimeNow());
		}
	}

	@Override
	public void Tfinish() {
		System.out.println("SUB: call finish() in CallBack");
		
		synchronized (this) {
			this.notify();
		}
		
	}

	@Override
	public void Tinterrupt() {
	}
	
	public static void main(String[] args) {
		Thread thread = new Main();
		thread.start();
		
		
	}
}
