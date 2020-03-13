package thread;

import java.util.concurrent.TimeUnit;

public class Deadlock {

	public static Integer r1 = 1;
	public static Integer r2 = 2;
	
	
	public static void main(String[] args) {
		TestThread t1;
		t1 = new TestThread();
		t1.start();
		TestThread1 t2 = new TestThread1();
		
		t2.start();
	}
	
	
}

class TestThread extends Thread{
	
	@Override
	public void run() {
		
		synchronized(Deadlock.r1) {
			try {
				TimeUnit.SECONDS.sleep(3);

				synchronized (Deadlock.r2) {
					System.out.println("This's r2");	
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}

class TestThread1 extends Thread{
	
	@Override
	public void run() {
		
		synchronized(Deadlock.r2) {
			try {
				TimeUnit.SECONDS.sleep(3);

				synchronized (Deadlock.r1) {
					System.out.println("This's r2");	
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
