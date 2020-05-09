package homework.data_structure.stack;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{

	public static void main(String[] args) {
		Queue<Student> queue = new Queue<>();
		queue.push(new Student("yuki",0));
		queue.push(new Student("danmo",1));
		queue.push(new Student("ole",1));
		queue.push(new Student("koto",0));
		queue.push(new Student("walu",1));
		queue.push(new Student("nani",0));
		queue.push(new Student("wota",0));
		queue.push(new Student("siwa",1));
		queue.push(new Student("mono",1));
		queue.push(new Student("gale",0));
		
		Student temp;
		Student temp1;
		while(!queue.isEmpty()) {
			temp = queue.pop();
			temp1 = queue.pop();
			if(!temp.dancing(temp1)) {
				queue.push(temp1);
			}
		}
	
		//Queue代码基本无改动
	}
	
	T[] objTs;
	private int tail;
	private int head;
	private int size;
	
	public Queue() {
		init(12);
	}
	
	public Queue(int size) {
		init(size);
	}

	@SuppressWarnings("unchecked")
	private void init(int size) {
		this.tail = 0;
		this.head = 0;
		this.size = 0;
		objTs = (T[]) new Object[size];
	}
	
	public void push(T t) {
		//1 bug not fix
		if(size >= objTs.length) {
			System.out.println("队列已满!");
			return;
		}
		
		objTs[tail++] = t;
		size++;
	}
	
	public T pop() {
		if((tail - head) <= 0) {
			System.out.println("空队列!");
			return null;
		}
		
		size--;
		return objTs[head++];
	}
	
	public boolean isEmpty() {
		return size <= 0;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {

			private int i;
			
			{
				i = head;
			}
			
			@Override
			public boolean hasNext() {
				return  (tail - i) > 0;
			}

			@Override
			public T next() {
				if(hasNext())
					return objTs[i++];
				
				return null;
			}
		};
	}
	
}

class Student{
	
	private String name;
	private int sex;
	
	public Student() {}
	public Student(String name, int sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	
	public boolean dancing(Student stu) {
		
		if(stu.sex != this.sex) {
			System.out.println(this + "正在和" + stu + "跳舞！");
			return true;
		}
		
		return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + (sex == 1 ? "男" : "女") + "]";
	}
	
	
}
