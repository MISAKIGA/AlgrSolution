package data_structure.queue;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("环形队列");
		
		CircleArrayQueue caq = new CircleArrayQueue(10);
		caq.addQueue(1);
		caq.addQueue(2);
		caq.addQueue(3);
		
		try {
			caq.showQueue();
			System.out.println(caq.getQueue());
			System.out.println(caq.getQueue());
			System.out.println(caq.peek());
			System.out.println(caq.peek());
			caq.addQueue(4);
			caq.getQueue();
			caq.showQueue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}


class CircleArrayQueue {
	private int maxSize;
	private int head;
	private int tail;
	private int[] arr;
	
	public CircleArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}
	
	public boolean isFull() {
		return (tail + 1) % maxSize == head;
	}
	public boolean isEmpty() {
		return head == tail;
	}
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("FUlL");
			return;
		}
		arr[tail] = n;
		//取模
		tail = (tail  + 1) % maxSize;
	}
	public int  getQueue() throws Exception {
		if(isEmpty()) {
			throw new Exception("empty");
		}
		int temp = arr[head];
		head = (head + 1 ) % maxSize;
		return temp;
	}
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("empty");
		}
		for (int i = head; i < head+size(); i++) {
			System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
			
		}
	}
	public int size() {
		return (tail + maxSize - head) % maxSize;
	}
	public int peek() throws Exception {
		if(isEmpty()) {
			throw new Exception("empty");
		}
		return arr[head];
	}
}