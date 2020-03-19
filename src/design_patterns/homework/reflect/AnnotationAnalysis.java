package design_patterns.homework.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//注解解析
//获取标识了@Test注解的方法，并且运行方法
public class AnnotationAnalysis {

	public static void main(String[] args) {
		
		runAndAnalysisTest(DemoTests.class);
		runTestByClassName("design_patterns.homework.reflect.DemoTests");
	}
	
	public static void runAndAnalysisTest(Class<?> clazz) {
		
		try {
			//clazz.getResource("/").getPath();
			Object object = clazz.newInstance();
			//获取所有方法
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				//如果标识了@Test注解就执行该方法
				if(method.isAnnotationPresent(Test.class)) {
					method.invoke(object);
				}
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	public static void runTestByClassName(String className) {
		
		System.out.println("Class loader加载");
		//Object object = Class.forName(className);
		//获取Application ClassLoader
		ClassLoader classLoader = AnnotationAnalysis.class.getClassLoader();
		try {
			//加载该类到内存中，但不执行初始化
			Class<?> tests = classLoader.loadClass(className);
			Object object = tests.newInstance();
			Method[] methods = tests.getMethods();
			for (Method method : methods) {
				if(method.isAnnotationPresent(Test.class)) {
					method.invoke(object);
				}
				
			}
			
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
		
	}
}
