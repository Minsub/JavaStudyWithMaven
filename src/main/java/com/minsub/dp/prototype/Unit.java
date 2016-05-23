package com.minsub.dp.prototype;

// Cloneable을 상속받은 기본 Unit Abstraction
public abstract class Unit implements Cloneable{

	public abstract void attack();
	public abstract Unit createClone();
}
