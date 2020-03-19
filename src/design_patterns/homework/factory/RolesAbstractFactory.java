package design_patterns.homework.factory;

import design_patterns.homework.factory.roles.ADC;
import design_patterns.homework.factory.roles.Mage;

/**
  *      角色抽象生产工厂
  * 
  *    可以生产 英雄角色 
 * @author MISAKIGA
 * @Date 2020-3-19 14
 */
public abstract class RolesAbstractFactory{

	
	/**
	 *   射手
	 *   生产 射手\ADC(Attack Damage Carry) 英雄角色
	 * @return
	 */
	public abstract ADC getADCRole(Class<? extends ADC> clazz);
	/**
	 *  法师
	 *  生产 法师\Mage 英雄角色
	 * @return
	 */
	public abstract Mage getMageRole(Class<? extends Mage> clazz);
}
