package com.minsub.dp.decorator;

// 마나 업그레이드
public class UpgradeOfMana extends Upgrade{
	
	private int mana = 0;
	
	// 기본 생성자를 막음
	private UpgradeOfMana(Unit unit) {
		super(unit);
	}
	
	// 늘어날 마나를 입력받는 생성자 (필수)
	public UpgradeOfMana(Unit unit, int mana){
		super(unit);
		this.mana = mana;
	}

	@Override
	public void showAbility() {
		System.out.print("마나가 +" + mana +"늘어난, ");
		super.unit.showAbility();
	}
}
