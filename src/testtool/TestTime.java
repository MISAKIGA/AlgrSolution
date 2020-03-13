package testtool;

public class TestTime {

	public static <T extends TestTimeInterface> long testTime(T t) {
		
		long startTime = System.nanoTime();
		t.run();
		long endTime = System.nanoTime();
		
		return (endTime - startTime) / 1000;
	}
}
