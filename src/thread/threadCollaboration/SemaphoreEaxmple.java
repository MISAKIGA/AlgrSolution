package thread.threadCollaboration;

import java.util.concurrent.Semaphore;

public class SemaphoreEaxmple {

	
	private static final Semaphore placeSemaphore = new Semaphore(5);
	
	public static void main(String[] args) {
		
		placeSemaphore.tryAcquire();
		placeSemaphore.release();
	}
}
