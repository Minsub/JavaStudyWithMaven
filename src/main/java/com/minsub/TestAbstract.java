package com.minsub;

public abstract class TestAbstract {
	public int a = 1;
	static public int b = 2;
	
	public TestAbstract() {
		System.out.println("TestAbstract Constructor");
	}
	
	abstract public void test1();
	abstract void test2();
	
	public void test3() {
		System.out.println("Abstract Test3");
	}
}
