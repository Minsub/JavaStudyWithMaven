package com.minsub.dp.singleton;

public class Singleton {
	private volatile static Singleton instance = null;
	
	// Closed Constructor
	private Singleton() {};
	
	// Singleton Constructor
	public static Singleton getInstance() {
		if (instance == null) {
			
			// 처음 한번만 인스턴스를 생성 
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}	
}
