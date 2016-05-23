package com.minsub.dp.bridge;

//∑π¿ÃΩ∫!!
public class Wraith extends Unit {

	public Wraith(Weapon weapon) {
		super(weapon);
	}
	
	@Override
	public void attack() {
		System.out.print("Wraith Attck: ");
		super.attack();
	}
}
