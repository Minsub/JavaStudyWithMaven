package com.minsub.dp.factorymethod;

public class Main {
	public static final String UNIT_PACKAGE = "com.minsub.dp.factorymethod.";
	public static final String UNIT_MARINE = "Marine";
	public static final String UNIT_MEDIC = "Medic";
	
	public static void main(String[] args) {
		
		// Marine 으로 유닛 만들기 
		Unit unit1 = Barrack.createUnit(UNIT_PACKAGE + UNIT_MARINE);
		if (unit1 != null) {
			unit1.attack();
		} 
		
		// Medic으로 유닛 만들기 
		Unit unit2 = Barrack.createUnit(UNIT_PACKAGE + UNIT_MEDIC);
		if (unit2 != null) {
			unit2.attack();
		} 
	}
}
