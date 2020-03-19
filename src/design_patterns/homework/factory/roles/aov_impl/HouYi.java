package design_patterns.homework.factory.roles.aov_impl;

import design_patterns.homework.factory.roles.ADC;

public class HouYi implements ADC{

	private final String NAME = "后羿";
	
	@Override
	public void physicalAttack() {
		
		System.out.println(NAME + "进行平A攻击（物理伤害）");
	}

}
