package com.minsub.dp.bridge;

//드랍쉽 (얜 공격기능 없음 ㅠㅠ)
public class Dropship extends Unit {

	public Dropship(Weapon weapon) {
		super(weapon);
	}
	
	@Override
	public void attack() {
		System.out.print("Dropship Attck: ");
		super.attack();
	}
}
