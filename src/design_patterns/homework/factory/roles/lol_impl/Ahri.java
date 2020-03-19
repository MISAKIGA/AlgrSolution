package design_patterns.homework.factory.roles.lol_impl;

import design_patterns.homework.factory.roles.Mage;

public class Ahri implements Mage{

	private final String NAME = "阿狸";
	
	@Override
	public void magicAttack() {
		
		System.out.println(NAME + "进行技能Q攻击（法术伤害）");
	}

}
