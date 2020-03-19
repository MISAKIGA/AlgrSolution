package design_patterns.homework.factory;

import design_patterns.homework.factory.roles.ADC;
import design_patterns.homework.factory.roles.Mage;

/**
 *    英雄联盟 角色生产工厂
 * @author MISAKIGA
 *
 */
public class LOLRolesFactory extends RolesAbstractFactory {

	@Override
	public ADC getADCRole(Class<? extends ADC> clazz) {
		
		try {
			System.out.println("欢迎来到召唤师峡谷");
			return (ADC)clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		throw new RuntimeException();
	}

	@Override
	public Mage getMageRole(Class<? extends Mage> clazz) {

		try {
			System.out.println("欢迎来到召唤师峡谷");
			return (Mage)clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		throw new RuntimeException();
	}

}
