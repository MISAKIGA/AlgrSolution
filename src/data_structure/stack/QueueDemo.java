package data_structure.stack;


public class QueueDemo {

	public static void main(String[] args) {
		System.out.println("初始化队列");
		QueueType queue = QueueType.initQueue();
		
		DATA4 data = new DATA4();
		data.name = "aa";
		data.age = 11;
		queue.pushQueue(queue, data);
		data = new DATA4();
		data.name = "bb";
		data.age = 22;
		queue.pushQueue(queue, data);
		data = new DATA4();
		data.name = "cc";
		data.age = 33;
		queue.pushQueue(queue, data);
		
		
		System.out.println("数据排入成功！长度为：" + queue.queueLen(queue));
		while (!(queue.queueIsEmpty(queue) == 1)) {
			
			data = queue.PopQueue(queue);
			System.out.println("处理队列：" + data.name + ":" + data.age);
		}
		
		queue.queueClear(queue);
		queue.queueFree(queue);

	}

}

class DATA4{
	String name;
	int age;
}
class QueueType{
	
	static final int QUEUELEN = 15;
	
	DATA4[] datas = new DATA4[QUEUELEN];
	int tail;
	int head;
	
	/**
	 * 查询队列长度
	 * @param queue
	 * @return
	 */
	int queueLen(QueueType queue) {
		
		if(queue == null)
			return -1;
		
		int temp = (queue.tail - queue.head);
		return temp;
	}
	/**
	 * 读取队头
	 * @param queue
	 * @return
	 */
	DATA4 peekQueue(QueueType queue) {
		if(queue.queueIsEmpty(queue) == 1)
			System.out.println("Queue is empty!!!");
		
		return queue.datas[queue.head];
	}
	/**
	 * 处理队列
	 * @param queue
	 * @return
	 */
	DATA4 PopQueue(QueueType queue) {
		if(queue.head == queue.tail)
			System.out.println("Queue is empty!!!");
		
		return queue.datas[queue.head++];
	}
	/**
	 * 进入队列排队
	 * @param queue
	 * @param data
	 * @return
	 */
	DATA4 pushQueue(QueueType queue,DATA4 data) {
		
		if(queue.tail == QUEUELEN)
			System.out.println("Queue is full!!!");
		
		queue.datas[queue.tail++] = data;
		
		return data;
		
	}
	/**
	 * 释放空间
	 * @param q
	 */
	void queueFree(QueueType q) {
		if(q != null)
			q = null;
	}
	/**
	 * 清空队列
	 * @param q
	 */
	void queueClear(QueueType q) {
		if(q != null) {
			q.head = 0;
			q.tail = 0;
		}
	}
	/**
	 * 判断队列是否已满，1表示已满
	 * @param q
	 * @return
	 */
	int queueIsFull(QueueType q) {
		int temp = 0;
		if(q.tail == QUEUELEN) {
			temp = 1;
		}
		return temp;
	}
	/**
	 * 判断队列是否为空，为空返回1；
	 * @param q
	 * @return
	 */
	int queueIsEmpty(QueueType q) {
		int temp = 0;
		if(q.head == q.tail) {
			temp = 1;
		}
		return temp;
	}
	/**
	 * 初始化栈队列
	 * @return
	 */
	public static QueueType initQueue() {
		
		QueueType q = null;
		if((q = new QueueType()) != null) {
			q.head = 0;
			q.tail = 0;
		}
		
		return q;
	}
}
