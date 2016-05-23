package com.minsub.dp.prototype;

public class Tank extends Unit{

	@Override
	public void attack() {
		System.out.println("Toong Toong, and then Siz Mode!! Kuwang~ ");
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