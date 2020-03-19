package design_patterns.homework.factory.roles.aov_impl;

import design_patterns.homework.factory.roles.Mage;

public class ShangguanWaner implements Mage{

	private final String NAME = "上官婉儿";
	
	@Override
	public void magicAttack() {
		
		System.out.println(NAME + "进行1技能攻击（法术伤害）");
	}

}
