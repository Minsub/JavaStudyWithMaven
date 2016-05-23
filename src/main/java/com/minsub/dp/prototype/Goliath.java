package com.minsub.dp.prototype;

public class Goliath extends Unit{

	@Override
	public void attack() {
		System.out.println("Missile in the sky, DADADADADA on the ground ");
	}

	@Override
	public Unit createClone() {
		Unit unit = null;
		try {
			unit = (Unit) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return unit;
	}
}
