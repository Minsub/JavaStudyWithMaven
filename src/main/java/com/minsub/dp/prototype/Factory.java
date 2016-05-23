package com.minsub.dp.prototype;

import java.util.HashMap;

public class Factory {
	private HashMap<String,Unit> hash = new HashMap<String,Unit>();
	
	// 최초 객체를 등록하는 함수
	public void register(String name, Unit unit) {
		hash.put(name, unit);
	}
	
	// Clone(복사)를 하는 함수
	public Unit create(String name) {
		Unit unit = hash.get(name);
		return unit.createClone();
	}
}
