package design_patterns.homework.factory;

import design_patterns.homework.factory.roles.ADC;
import design_patterns.homework.factory.roles.Mage;
import design_patterns.homework.factory.roles.aov_impl.HouYi;
import design_patterns.homework.factory.roles.aov_impl.ShangguanWaner;
import design_patterns.homework.factory.roles.lol_impl.Ahri;
import design_patterns.homework.factory.roles.lol_impl.Ashe;

public class Applicatoin {

	public static void main(String[] args) {
		
		
		//工厂模式目的，解耦，单一原则，开闭原则（可扩展，无需修改原代码）。。。
		//某程序员缺女朋友，他直接new GirlFriend类实现了女朋友的创建。
		//当他想换个理性点的女朋友，他又直接new  RationalGirlFriend。
		//但是这样老是要动源代码才能实现DIY化女朋友的创建，实在是麻烦，很不优雅
		//为了解决这问题，使用了工厂模式这个概念，Factory.getGirlFriend(RationalGirlFriend.class) 
		//这样自己想加的角色属性直接交给工厂，让工厂制造出你DIY好的女朋友。
		//假如你想换个萌一点的女朋友直接把RationalGirlFriend.class = 换成CuteGirlFriend.class即可
		//但是这样的代码还没有完全脱耦。你依然需要修改代码，有没有办法不需要修改代码也可以实现DIY创建女朋友呢？
		//使用反射即可，实现后的使用方法类似Spring的IOC 注入。

		//抽象工厂
		//首先建立一个抽象的角色工厂（moba游戏都有英雄概念）
		//每个moba游戏都是不同制造商制造出来的，所以虽然生产的英雄类型相同但是角色的技能不同
		//他们都有ADC、Mage类型的英雄角色，但实际内部实现的攻击方法，攻击类型却又不同
		//使用抽象工厂可以完美解决这个问题，抽象一个角色生产工厂，然后由不同的游戏制造商实现他们自己的工厂，定制自己的英雄角色
	
		//建造王者荣耀角色工厂
		RolesAbstractFactory raf = RolesFactoryBuilder.build(ArenaOfValorRolesFactory.class);
		//创建 射手
		ADC adc = raf.getADCRole(HouYi.class);
		adc.physicalAttack();
		
		//创建 法师
		Mage mage = raf.getMageRole(ShangguanWaner.class);
		mage.magicAttack();
		
		//建造英雄联盟工厂
		raf = RolesFactoryBuilder.build(LOLRolesFactory.class);
		ADC adc2 = raf.getADCRole(Ashe.class);
		adc2.physicalAttack();
		Mage mage2 = raf.getMageRole(Ahri.class);
		mage2.magicAttack();
	}
}
