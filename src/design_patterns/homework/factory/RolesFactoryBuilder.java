package design_patterns.homework.factory;

public class RolesFactoryBuilder {

	public static RolesAbstractFactory build(Class<? extends RolesAbstractFactory> factory) {
		
		if(factory != null) {
			
			try {
				
				return factory.newInstance();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
