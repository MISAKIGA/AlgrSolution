package homework.data_structure.tree;

public class ArrBinaryTree {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7};
		
		//创建树
		ArrBinaryTree tree = new ArrBinaryTree(arr);
		tree.preOrder();
		System.out.println("-*----");
		tree.fOrder(0);
	}

	
	private int[] arr; //存储数据节点


	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	public void preOrder() {
		preOrder(0);
	}
	
	//顺序存储二叉树前序遍历
	public void preOrder(int index) {
		//如果数据为空
		if(arr == null || arr.length == 0) {
			System.out.println("Arr is null!");
		}
		//输出当前元素
		System.out.println(arr[index]);
		
		//向左递归遍历
		if((index * 2 + 1) < arr.length) { 
			preOrder(2 * index + 1);
		}
		
		//向右递归遍历
		if((index * 2 + 2) < arr.length) { 
			preOrder(2 * index + 2);
		}
		
	}
	
	//中序
	public void fOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("arr is null");
		}
		
		if((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		
		System.out.println(arr[index]);
		
		//向右递归遍历
		if((index * 2 + 2) < arr.length) { 
			preOrder(2 * index + 2);
		}
	}
}
