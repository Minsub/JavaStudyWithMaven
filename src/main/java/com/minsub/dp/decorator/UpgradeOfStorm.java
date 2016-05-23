package com.minsub.dp.decorator;

//싸이오닉 스톰 업그레이드
public class UpgradeOfStorm extends Upgrade{

	public UpgradeOfStorm(Unit unit) {
		super(unit);
	}

	@Override
	public void showAbility() {
		System.out.print("싸이오닉 스톰을 쓸 수 있는, ");
		super.unit.showAbility();
	}
}
