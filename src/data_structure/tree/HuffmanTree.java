package data_structure.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		int arr[] = {13,7,8,3,29,6,1};
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}

	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("null tree");
		}
	}
	/**
	 * 
	 * @param arr 需要创建赫夫曼树的数组
	 * @return 创建好的赫夫曼树
	 */
	public static Node createHuffmanTree(int[] arr) {
		//1.遍历arr数组
		//2. 将arr的每个元素构成成一个Node
		//3. 将Node 放入到ArrayList中
		List<Node> nodes = new ArrayList<Node>();
		for(int value : arr) {
			nodes.add(new Node(value));
		}
		
		while (nodes.size() > 1) {
		
			// 排序 从小到大
			Collections.sort(nodes);

			System.out.println("nodes=" + nodes);

			// 取出根节点权值最小的两颗二叉树
			// 1. 取出权值最小的节点（二叉树）
			Node leftNode = nodes.get(0);
			// 2. 取出第二小的节点（二叉树）
			Node rightNode = nodes.get(1);

			// 3. 构建新的二叉树
			Node parent = new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;

			// 4. 从ArrayList 删除处理过的二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			// 5. 将parent加入到nodes
			nodes.add(parent);
		}
		
		return nodes.get(0);
	}
}


//
class Node implements Comparable<Node>{
	int value; //权值
	Node left; //左子节点
	Node right; //右
	char c;     //字符
	
	
	public Node(int value) {
		
		this.value = value;
	}
	

	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		//从大到小
		//-(this.value - o.value)
		//从小到大
		return this.value - o.value;
	}
	
	
}