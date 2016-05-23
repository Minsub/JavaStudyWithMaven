package com.minsub.dp.composite;

import com.minsub.dp.factorymethod.Marine;
import com.minsub.dp.factorymethod.Medic;
import com.minsub.dp.factorymethod.Unit;

public class Main {

	public static void main(String[] args) {
		// 단일 유닛의 어택!!
		Unit marine1 = new Marine();
		Unit medic1 = new Medic();
		marine1.attack();
		medic1.attack();
		
		//부대지정 후 어택
		Unit corps1 = new Corps();
		((Corps)corps1).add(marine1);
		((Corps)corps1).add(medic1);
		corps1.attack();
	}
}

