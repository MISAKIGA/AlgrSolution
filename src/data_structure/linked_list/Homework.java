package data_structure.linked_list;

import java.util.Iterator;
import java.util.Random;

/**
 * 
 * @author MISAKIGA 1932349119
 * @date update 20-03-11 16
 */
public class Homework {

	public static void main(String[] args) {
		
		LineList<Integer> list = new LineList<>();
		int i = 35;
		//插入
		//修复了下面语句插入后依然能执行的bug
		//list.insert(1, i);
		
		//设置当前插入数据大小。
		//list.setLength(4);
		list.add(98);
		list.add(80);
		list.add(20);
		list.add(54);
		list.add(54);
		System.out.println(list);
	
		//插入
		list.insert(0, i);
		System.out.println("insert(i*0)："+list);
		
		//添加元素
		list.add(60);
		System.out.println("add(60)："+list);

		//删除下标为0的元素
		list.remove(0);
		System.out.println("delete(i*0)："+list);
		
		System.out.println("扩容 前+  " + list.capacity());
		while(i-- > 0) 
			list.add(new Random().nextInt(100));
		
		System.out.println("扩容 后+  " + list.capacity());
		System.out.println("expand："+list);
		System.out.println("容量" + list.capacity());
		
		System.out.println("查找(20)的下标" + list.indexOf(20));
		System.out.println("获取下标(2)的值" + list.get(2));
		
		System.out.println("=============================================");
		System.out.println("容量" + list.capacity());
		i = 32;
		while(i-- > 0) 
			list.remove(new Random().nextInt(list.getSize()));
		
		System.out.println("容量" + list.capacity());
		System.out.println("大小" + list.getSize());
	
		
		//boolean thisExceptino = LineList.LineListException.isThisExceptino(LineListException.WrongVariable,"WrongVariable");
		//boolean thisExceptino1 = LineList.LineListException.isThisExceptino(LineListException.ListOverFlow,LineListException.ListOverFlow);
		
	
	}
}

class LineList<T> implements Iterable<T>{
	
    private final static Integer INIT_SIZE = 12;
    private Integer poInteger = 0;
    //通用化LineList类，数据使用Object存储
	private T[] data;
	
	
	public LineList() {
		this(INIT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public LineList(Integer length) {
		this.data = (T[])new Object[length];
		poInteger = 0;
	}
	
	public boolean isEmpty() {
		return poInteger == 0;
	}
	
	//查找t出现的第一个位置
	public int indexOf(T t) {
		
		if(isUseable(t)) {

			for (int i = 0; i < getSize(); i++) {
				if(data[i].equals(t)) {
					return i;
				}
			}
		}
		
		else {
			for (int i = 0; i < getSize(); i++) {
				if(data[i] == null) {
					return i;
				}
			}
		}

		return -1;
	}
	
	public T get(int index) {
		return data[index];
	}
	
	private boolean isUseable(T t) {
		
		return t != null;
	}

	public boolean insert(int index,T data) {
		
		if(!isUseable(index) || !isUseable(data))
			return false;
		
		//移动元素
		moveElementBack(index);

		//插入元素
		this.data[index] = data;
		
		//移动指针（移动当前下标）
		poInteger ++;
		
		return true;
	}
	
	public boolean remove(int index) {
		
		if(!isUseable(index))
			return false;
		
		//移动元素
		moveElementForward(index);
		
		poInteger --;
		
		return true;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sbBuilder = new StringBuilder();
		for (int i = 0; i < poInteger; i++) {
			sbBuilder.append(data[i]);
			
			if(i < poInteger -1)
				sbBuilder.append(",");
		}
		//return Arrays.toString(data);
		return sbBuilder.toString();
	}
	
	public boolean add(T data) {
	
		if(!isUseable(data) || !isUseable(poInteger))
			return false;

		//添加元素
		this.data[poInteger++] = data;
		
		return true;
	}
	
	@Deprecated
	public void setLength(int length) {
		this.poInteger = length;
	}
	
	public int getSize() {
		return poInteger;
	}
	public int capacity() {
		return data.length;
	}
	
	private boolean initVer(int index) throws  RuntimeException{
		
		//判断是否溢出
		if(index > 0 && capacity() < (index + 1)) {
			throw new RuntimeException(LineListException.ListOverFlow.getName());
		}
		//判断下标是否有效
		if(index < 0 || index > getSize()) {
			throw new RuntimeException(LineListException.WrongVariable.getName());
		}
		
		//判断数组是否有1/4空间未使用
		if(getSize() > 0 && getSize() <= capacity()/4) {
			throw new RuntimeException(LineListException.TooMuchInvalidSpace.getName());
		}
		
		return true;
	}
	
	private boolean isUseable(int index) {
		
		try {
			//判断该操作是否有异常
			initVer(index);
		} catch (RuntimeException e) {
			
			if(LineListException.isThisExceptino(LineListException.ListOverFlow,e.getMessage())) {
				//数组溢出处理，自动扩容。
				int size = (capacity() << 1) - 3;
				//改变容量
				resize(size);
			}
			if(LineListException.isThisExceptino(LineListException.WrongVariable,e.getMessage())) {
				System.out.println("输入的值无效" );
				e.printStackTrace();
				System.exit(0);
			}
			
			if(LineListException.isThisExceptino(LineListException.TooMuchInvalidSpace,e.getMessage())) {
				
				System.out.println("实际使用容量过低，数组缩容！");
				
				//数组无效空间过多，自动缩容，一半空间。
				int size = (capacity() >> 1) + 3;
				//改变容量
				resize(size);
			}
				
		} 
		
		return true;
		
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		//this.data = Arrays.copyOf(this.data, newSize);
		
		T[] temp = data;
		data = (T[])new Object[newSize];
		int i = 0;
		//拷贝数据
		 do {data[i] = temp[i];} 
		 while (++i < poInteger); 
		
		//System.arraycopy(temp, 0, data, 0, poInteger); //线程不安全 ，直接操作内存，速度快，浅复制
		//temp = (T[])data.clone();data = (T[])new Object[newSize];data = temp; //浅拷贝，diss
		
		
	}
	
	//将数组向前移动
	private void moveElementForward(int index) {
		
		for (int i = index; i < poInteger; i++) {
			if(i + 1 < capacity())
				data[i] = data[i + 1];
		}
	}
	//将数组向后移动
	private void moveElementBack(int index) {
		
		for (int i = poInteger + 1; i > index; i--) {
			data[i] = data[i - 1];
		}
	}

	//Iterator支持
	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {

			private int cur;
			//初始化
			{
				this.cur = 0;
			}
			
			//是否还有下一个元素
			@Override
			public boolean hasNext() {
				return cur < poInteger;
			}
			//获取下一个元素
			@Override
			public T next() {
				return data[cur++];
			}
		};
	}
	
	//异常枚举
	public enum LineListException{
		
		WrongVariable("WrongVariable",20001L),ListOverFlow("ListOverFlow",20002L),TooMuchInvalidSpace("TooMuchInvalidSpace",20003L),UnknownException("UnknownException",30000L);
		
		private LineListException(String name,Long code) {
			this.name = name;
			this.code = code;
		}
		private String name;
		private Long code;
		
		public static boolean isThisExceptino(LineListException lineListException,String name) {
			
			try {
				LineListException valueOf = LineListException.valueOf(LineListException.class, name);
				//LineListException valueOf = LineListException.valueOf(name);

				return isThisExceptino(lineListException,valueOf);
			} catch (Exception e) {	}
			
			return false;
		}
		
		public static boolean isThisExceptino(LineListException lineListException,LineListException lineListException2) {

			return lineListException.compareTo(lineListException2) == 0;
		}
		
		public String getName() {
			return name;
		}
		public Long getCode() {
			return code;
		}
	}

}


