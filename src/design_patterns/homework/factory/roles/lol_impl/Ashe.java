package design_patterns.homework.factory.roles.lol_impl;

import design_patterns.homework.factory.roles.ADC;

public class Ashe implements ADC {

	private final String NAME = "艾希";
	
	@Override
	public void physicalAttack() {
		
		System.out.println(NAME + "进行平A攻击（物理伤害）");
		
	}
}
