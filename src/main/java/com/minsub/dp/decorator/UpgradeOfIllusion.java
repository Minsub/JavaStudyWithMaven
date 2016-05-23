package com.minsub.dp.decorator;

// 환상 업그레이드
public class UpgradeOfIllusion extends Upgrade{

	public UpgradeOfIllusion(Unit unit) {
		super(unit);
	}

	@Override
	public void showAbility() {
		System.out.print("환상을 쓸 수 있는, ");
		super.unit.showAbility();
	}
}
