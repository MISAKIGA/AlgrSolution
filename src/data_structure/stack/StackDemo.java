package data_structure.stack;


public class StackDemo {

	public static void main(String[] args) {

		System.out.println("初始化栈与入栈");
		StackType stackType = StackType.stackTypeInit();
		DATA3 data;
		
		System.out.println("初始化成功！进行入栈操作");
		
		do {
			data = new DATA3();
			data.name = "TEST DATA:" + stackType.top;
			data.age = stackType.top + 10;
			stackType.pushST(stackType, data);
			System.out.println("push Stack data:" + data.name + ":" + data.age);
			
		} while (stackType.top < 10);
		
		System.out.println("数据压入成功！栈内数据有" + stackType.top + "，进行出栈操作");
		
		data = null;
		while(!stackType.STIsEmpty(stackType)) {
			
			data = stackType.popST(stackType);
			System.out.println("POP Stack data:" + data.name + ":" + data.age + "TOP" + stackType.top);
			
		} 
		
		System.out.println("出栈操作完成！Stack is empty：" + stackType.STIsEmpty(stackType));
		stackType.STFree(stackType);
	}

}


class DATA3{
	String name;
	int age;
}
class StackType{
	
	static final int MAXLEN = 50;
	DATA3[] data = new DATA3[MAXLEN];	//数据元素
	int top;							//栈顶
	
	/**
	 * 读取栈顶数据，但不删除数据
	 * @param s
	 * @return
	 */
	public DATA3 peekST(StackType s) {
		if(s.top == 0)
			throw new RuntimeException("Stack don't has anything data");
		
		return (s.data[s.top]);
	}
	/**
	 * 出栈操作，弹出数据
	 * @param s
	 * @return
	 */
	public DATA3 popST(StackType s) {	
		if(s.top == 0)
			throw new RuntimeException("Stack don't has anything data");
		
		return (s.data[s.top--]);
	}
	/**
	 * 入栈操作，压入数据
	 * @param s
	 * @param data
	 * @return
	 */
	public int pushST(StackType s,DATA3 data) {
		if((s.top + 1) == MAXLEN)
			throw new RuntimeException("Stack free full!!!");
		
		s.data[(++s.top)] = data;
		return 1;
		
	}
	/**
	 * 释放内存空间
	 * @param s
	 */
	public void STFree(StackType s) {
		if(s != null)
			s = null;
	}
	/**
	 * 清空栈
	 * @param s
	 */
	public void STClear(StackType s) {
		s.top = 0;
	}
	/**
	 * 判断栈是否已满
	 * @param s
	 * @return 若是满栈，则反回true
	 */
	public boolean STIsFull(StackType s) {
		boolean t = false;
		t = (s.top == MAXLEN);
		return t;
	}
	/**
	 * 栈初始化
	 * @return
	 */
	public static StackType stackTypeInit() {
		StackType p; 
		if((p = new StackType()) != null) {
			p.top = 0;
			return p;
		}
		return null;
	}
	
	/**
	 * 判断栈是否为空，为空可以进行入 栈操作，但不可以出栈
	 * @param s
	 * @return
	 */
	public boolean STIsEmpty(StackType s) {
		boolean t = false;
		t = (s.top == 0);
		return t;
	}
}