package com.minsub.dp.bridge;

public class Main {

	public static void main(String[] args) {
		Weapon weaponNone = new WeaponNone();
		Weapon weaponRazer = new WeaponRazer();
		
		// 레이스, 드랍쉽 생성 
		Unit wraith = new Wraith(weaponRazer);
		Unit dropship = new Dropship(weaponNone);
		
		// 공격!!
		wraith.attack();
		dropship.attack();
		
		// 레이스에게 공격할 수 없는 Weapon 세팅, 드랍쉽에게 공격 Weapon 
		wraith.setWeapon(weaponNone);
		dropship.setWeapon(weaponRazer);
		
		wraith.attack();
		dropship.attack();
	}
}
