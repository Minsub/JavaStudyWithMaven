package com.minsub.dp.decorator;

public class Main {

	public static void main(String[] args) {
		// 템플러를 만듬
		Unit highTempler = new HighTempler();
		// 무슨 능력이 있을까? 당근 아무것도 없지ㅠㅠ 걍 하이템플러
		highTempler.showAbility();

		// 업그레이드 데코레이터!!
		Unit upgradedHT;
		upgradedHT = new UpgradeOfStorm(new UpgradeOfMana(new UpgradeOfIllusion(highTempler), 100));
		upgradedHT.showAbility();

	}
}
