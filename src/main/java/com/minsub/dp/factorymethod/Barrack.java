package com.minsub.dp.factorymethod;

public class Barrack {

	public static Unit createUnit(String unitName)  {
		try {
			// IF문으로 처리할 수 있지만, Reflection을 사용해봤다.  
			Class cls = Class.forName(unitName);
			Object obj = cls.newInstance();
			return (Unit)obj;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
