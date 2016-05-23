package com.minsub.dp.bridge;

// weaopn 인터페이스를 가지고 있는 Unit Abstraction
public abstract class Unit {
	private Weapon weapon = null;
	
	public Unit(Weapon weapon){
		this.weapon = weapon;
	}
	
	public void attack() {
		weapon.attack();
	}
	
	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
}
