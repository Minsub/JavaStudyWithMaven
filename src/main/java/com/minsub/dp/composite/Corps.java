package com.minsub.dp.composite;

import java.util.ArrayList;

import com.minsub.dp.factorymethod.Unit;

/**
 * 부대지정 클래스
 * com.minsub.dp.factorymethod에서 사용한 클래스를 이용
 * 
 * @author Minsub ji
 *
 */
public class Corps extends Unit{

	private ArrayList<Unit> list = new ArrayList<Unit>();
	
	@Override
	public void attack() {
		System.out.println("Corps1 Attack!!");
		for (Unit unit: list) {
			unit.attack();
		}
	}
	
	public void add(Unit unit){
		list.add(unit);
	}
	
	public void remove(Unit unit) {
		list.remove(unit);
	}

}
