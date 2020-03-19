package design_patterns.homework.factory;

import design_patterns.homework.factory.roles.ADC;
import design_patterns.homework.factory.roles.Mage;

/**
 *   王者荣耀 角色生产工厂
 * @author MISAKIGA
 *
 */
public  class ArenaOfValorRolesFactory extends RolesAbstractFactory {

	@Override
	public ADC getADCRole(Class<? extends ADC> clazz) {
		
		try {
			System.out.println("欢迎来到王者峡谷");
			return (ADC)clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

	@Override
	public Mage getMageRole(Class<? extends Mage> clazz) {

		try {
			System.out.println("欢迎来到王者峡谷");
			return (Mage)clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}


}
