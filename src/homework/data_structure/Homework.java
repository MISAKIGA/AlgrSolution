package homework.data_structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * 
 * @author MISAKIGA
 * @Date create 20-3-16 20
 *
 */
public class Homework {

	public static void main(String[] args) {hw2();}
	
	private static void hw2() {
		
		final int N = 1000000;
		Object object = new Object();
		
		Collection<Object> lists = new ArrayList<>();
		
		Long runTime = TestTime.testTime(() ->{
			for (int i = 0; i <= N; i++) {
				lists.add(object);
			}
		});
		
		System.out.println("没有调用ensureCapacity(偏差-7~8)：" + runTime);
		
		
		ArrayList<Object> lists1 = new ArrayList<>();
		lists1.ensureCapacity(N);
		Long runTime1 = TestTime.testTime(() ->{
			for (int i = 0; i <= N; i++) {
				lists1.add(object);
			}
		});
		System.out.println("调用ensureCapacity(偏差-7~8)：" + runTime1);
	}
	
	
	private static void hw4() {
		
		while(true) {
			switch (userUI()) {
			case 1:
				addComputer();
				break;
			case 2:
				queryComputer();
				break;
			case 3:
				queryAllComputers();
				break;
			default:
				System.exit(0);
			}
		}
	}
	
	private static void queryAllComputers() {
		
		if(isUseable()) {
			//System.out.println(computers.size()  + "sssssdfsdff");
			Collection<Computer> lists = new ArrayList<>(computers);
			//遍历所有电脑
			lists.forEach(System.out::println);
		}
		
		else {
			System.out.println("data not find!!!");
		}
		
	}

	private static boolean isUseable() {
		return !computers.isEmpty() && computers.size() > 0;
	}
	
	private static void queryComputer() {
		
		System.out.println("input computer id:");
		int nextInt = SC.nextInt();
		if(!isUseable() || nextInt < 0 || nextInt >= computers.size() || (computers.toArray()[nextInt]) == null) {
			System.out.println("not find !!!! query once again??? 1(yes)");
			if(SC.nextInt() == 1)
				queryComputer();
		}
		
		Computer computer = null;
		if(nextInt < computers.size())
			computer = (Computer) ((computers.toArray())[nextInt]);
		
		if(computer != null) {
			System.out.println("----- find it ! -----");
			System.out.println(computer);
		}
		
	}

	private static void addComputer() {
		
		System.out.println("--------------- add computer... ---------------");
		System.out.println("input computer info:");
		System.out.println("format: [cpu model,mother board model,view card model,hd size,mem size,price] 6");
		Computer computer = new Computer();
		
		System.out.println("input computer cpu model:");
		computer.setCpuModel(SC.next());
		System.out.println("input mother board modell:");
		computer.setMotherBoardModel(SC.next());
		System.out.println("input view card model:");
		computer.setViewCardModel(SC.next());
		System.out.println("input hd size:");
		computer.setHdSize(SC.nextInt());
		System.out.println("input mem size:");
		computer.setMemSize(SC.nextInt());
		System.out.println("input price:");
		computer.setPrice(SC.nextDouble());
		//set id 设置编号
		computer.setId(Long.valueOf(computers != null ? computers.size() : 0)); 
		
		System.out.println("------- computer info --------");
		System.out.println(computer);
		computers.add(computer);
		
		System.out.println("------- continue add ? 1(yes) --------");
		//递归进行添加电脑
		if(SC.nextInt() == 1) 
			addComputer();
		
	}

	//控制台输入
	private final static Scanner SC = new Scanner(System.in);
	//链表存储
	private static Collection<Computer> computers = new LinkedList<>();
	//线性表读取，读写分离
	//private static Collection<Computer> readlists = new ArrayList<>(computers);
	
	private static int userUI(){
		
		System.out.println("--------------- menu ---------------");
		System.out.println("1.add computer");
		System.out.println("2.query computer");
		System.out.println("3.query all computer");
		System.out.println("*.exit!");
		return SC.nextInt();
	}
	
	private static void hw3(){
		Collection<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		lists.add(4);
		
		Object[] objects1 = new Object[lists.size()];
		objects1 = lists.toArray();
		
		for(Object object : objects1) {
			System.out.println((Integer)object);
		}
		
		System.out.println("-----------------------");
		lists.add(5);
		
		Object[] objects2 = new Object[lists.size()];
		lists.toArray(objects2);
		
		for(Object object : objects2) {
			System.out.println((Integer)object);
		}
	}
	
	private static void hw1(){
		Collection<Cat> cats = new ArrayList<>();
		cats.add(new Cat("mimi"));
		cats.add(new Cat("qiqi"));
		cats.add(new Cat("ding"));
		cats.add(new Cat("hui"));
		
		//foreach cats
		cats.forEach(cat ->{
			cat.show();
		});
	}

}

interface TestTimeInterface {void run();}

class TestTime {

	public static <T extends TestTimeInterface> long testTime(T t) {
		
		long startTime = System.nanoTime();
		t.run();
		long endTime = System.nanoTime();
		
		return (endTime - startTime) / 1000;
	}
}

class Computer{
	
	private Long id;
	private String cpuModel;
	private String motherBoardModel;
	private Integer hdSize;
	private Integer memSize;
	private String viewCardModel;
	private double price;
	
	
	//计算机详细信息
	@Override
	public String toString() {
		return "Computer [id=" + id + ", cpuModel=" + cpuModel + ", motherBoardModel=" + motherBoardModel + ", hdSize="
				+ hdSize + ", memSize=" + memSize + ", viewCardModel=" + viewCardModel + ", price=" + price + "]";
	}
	
	//-----getter setter-----
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpuModel() {
		return cpuModel;
	}
	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}
	public String getMotherBoardModel() {
		return motherBoardModel;
	}
	public void setMotherBoardModel(String motherBoardModel) {
		this.motherBoardModel = motherBoardModel;
	}
	public Integer getHdSize() {
		return hdSize;
	}
	public void setHdSize(Integer hdSize) {
		this.hdSize = hdSize;
	}
	public Integer getMemSize() {
		return memSize;
	}
	public void setMemSize(Integer memSize) {
		this.memSize = memSize;
	}
	public String getViewCardModel() {
		return viewCardModel;
	}
	public void setViewCardModel(String viewCardModel) {
		this.viewCardModel = viewCardModel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

class Cat{
	
	private String name;

	public Cat(String name) 
	{
		this.name = name;
	}
	
	public void show() 
	{
		System.out.println(name);
	}
}
