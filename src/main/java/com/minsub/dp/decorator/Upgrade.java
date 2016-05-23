package com.minsub.dp.decorator;

// Decorate할 Upgrade 추상 클래스
public abstract class Upgrade extends Unit {
	protected Unit unit;
	public Upgrade(Unit unit) {
		this.unit = unit;
	}
	
	public abstract void showAbility();
}
