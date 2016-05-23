package com.minsub.dp.prototype;

public class Main {

	public static final String NAME_UNIT_TANK = "tank";
	public static final String NAME_UNIT_GOLIATH = "goliath";
	
	public static void main(String[] args) {
		Factory factory = new Factory();
		Tank tank = new Tank();
		Goliath goliath = new Goliath();

		// 최초 Unit 객체를 Factory에 등록
		factory.register(NAME_UNIT_TANK, tank);
		factory.register(NAME_UNIT_GOLIATH, goliath);
		
		//Factory를 통해 clone
		Unit tank1 = factory.create(NAME_UNIT_TANK);
		tank1.attack();
		
		Unit goliath1 = factory.create(NAME_UNIT_GOLIATH);
		goliath1.attack();
	}
}
