package com.minsub.dp.adapter;

public class AdapterBanana extends Banana implements Adapter{

	public AdapterBanana(String name) {
		super(name);
	}

	@Override
	public void print() {
		super.show(); // 부모 Banana 클래스의 show() 함수를 단순히 호출 
	}

}
