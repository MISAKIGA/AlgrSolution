package thread.threadCollaboration;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample {

	//Rewritable lock
	private static final ReentrantLock queueLock = new ReentrantLock();
	
	//Reentrant read-write lock
	private static final ReentrantReadWriteLock orderLock = new ReentrantReadWriteLock(); 
	
	
	public static void main(String[] args) {
		queueLock.tryLock();
		queueLock.unlock();
		
		
		orderLock.readLock().lock();
		orderLock.readLock().unlock();
		
		orderLock.writeLock().lock();
		orderLock.writeLock().unlock();;
		
	}
}
