package design_patterns.homework.reflect;

public class DemoTests {


	@Test
	public void printAddSum() {
		System.out.println("1+1=" + (1 + 1));
	}

	@Test
	public void printMultiplySum() {
		System.out.println("9*2=" + (9 << 1));
	}
	
	public void printDivisionSum() {
		System.out.println("9/2=" + (9 >> 1));
	}
}
