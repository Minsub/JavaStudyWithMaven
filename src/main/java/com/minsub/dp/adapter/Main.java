package com.minsub.dp.adapter;

/**
 -Client에서 요구하는 규격을 맞추기 위해 객체를 변경함
 - 기능객체를 상속하고 Client의 요구규격에 맞는 Interface를 implements함
 - 쉽게 말해 독립적인 CLASS A가 있다. 근데 다른 클래스와의 인터페이스를 위해 INTERFACE B를 만들고, 이 규격에 맞추기 위해 extends A implements B를 한 class C를 만든다. 기능은 A의 기능을 상속해서 사용하고, 규격만 B로 다시 재정의 하는 것이다. Class C에서 다시 정의하는 로직따윈 없다.

http://gyrfalcon.tistory.com/entry/Design-Pattern-Adapter

 * @author hmm1115222
 *
 */
public class Main {

	public static void main(String[] args) {
		Adapter adapter = new AdapterBanana("Banana");
		adapter.print();
	}

}
