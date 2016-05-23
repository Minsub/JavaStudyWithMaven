package com.minsub;

public class Child extends TestAbstract implements TestInterface{

	public int a;
	
	public Child(){
		System.out.println("Child Constructor");
	}
	
	public Child(int a) {
//		super();
		System.out.println("Child(int) Constructor");
		this.a = a;
	}
	
	@Override
	public void test1() {
		System.out.println("[test1()] Child-a: " + super.a);
	}

	@Override
	void test2() {
		System.out.println("[test2()] Child-a: " + super.b);
	}

}
