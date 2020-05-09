package data_structure.queue;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		

	}
}

class ArrayQueue {
	private int maxSize;
	private int head;
	private int tail;
	private int[] arr;
	
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		head = -1;
		tail = -1;
		
	}
	
	public boolean isFull() {
		return tail == maxSize -1 ;
	}
	public boolean isEmpty() {
		return head == tail;
	}
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("FUlL");
			return;
		}
		tail++;
		arr[tail] = n;
	}
	public int  getQueue() throws Exception {
		if(isEmpty()) {
			throw new Exception("empty");
		}
		head++;
		return arr[head];
	}
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("empty");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
			
		}
	}
	public int peek() throws Exception {
		if(isEmpty()) {
			throw new Exception("empty");
		}
		return arr[head];
	}
}