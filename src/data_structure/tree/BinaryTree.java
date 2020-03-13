package data_structure.tree;

import java.util.Scanner;

public class BinaryTree {
	
	@SuppressWarnings("resource")
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		
		ChainTreeType root = null;
		int menusel;
		
		ChainTreeType tool = new ChainTreeType();
		//初始化
		root = ChainTreeType.initTree();
		
		do {
			System.out.println("please choose menu add the binary tree node");
			System.out.printf("0.exit\t");
			System.out.printf("1.add binary tree node\n");
			menusel = input.nextInt();
			                                                   
			switch (menusel) {
			case 1:
				tool.AddTreeNode(root);
				break;
			case 0:
				break;
			default:;
			}
			
		} while (menusel != 0);
		
		do {
			System.out.println("please choose menu foreach the tree node,input 0 exit this progam.");
			System.out.println("1.First-order(DLR) result");	//先序遍历
			System.out.println("2.Medium-order(LDR) result");	//中序遍历
			System.out.println("3.Post-order(LRD) result");		//后序遍历
			System.out.println("4.Traversing by layer result)");//按层遍历
			
			menusel = input.nextInt();
			
			switch (menusel) {
			case 1:
				System.out.println("1.First-order(DLR) result");
				tool.DLRTree(root);
				System.out.println();
				break;
			case 2:
				System.out.println("2.Medium-order(LDR) result");
				tool.LDRTree(root);
				System.out.println();
				break;
			case 3:
				System.out.println("3.Post-order(LRD) result");
				tool.LRDTree(root);
				System.out.println();
				break;
			case 4:
				System.out.println("4.Traversing by layer result)");
				tool.levelTree(root);
				System.out.println();
			default:;
			}
			
		} while (menusel != 0);
		
		System.out.println("Binary tree depth:" + tool.treeDepth(root));
		
		tool.clearTree(root);
	}
}

class ChainTreeType{
	
	private static final int MAXLEN = 20; //队列最大长度
	//private static final Object LOCK = new Object();//单例锁
	//private static ChainTreeType TREE = null;		  //单例对象
	
	String nodeData;			  //节点元素数据
	ChainTreeType leftSonNode; 	  //左子节点引用
	ChainTreeType rightSonNode;	  //右子节点引用
	
	@SuppressWarnings("resource")
	static Scanner input = new Scanner(System.in);
	
	//ChainTreeType root = null;	//定义二叉树（根节点）引用
	
	/**
	 * 后序递归
	 * @param treeNode
	 */
	void LRDTree(ChainTreeType treeNode) {
		
		if(treeNode != null) {
			LRDTree(treeNode.leftSonNode);
			LRDTree(treeNode.rightSonNode);
			outputTreeNodeData(treeNode);
		}
	}

	/**
	 * 中序递归
	 * @param treeNode
	 */
	void LDRTree(ChainTreeType treeNode) {
		
		if(treeNode != null) {
			LDRTree(treeNode.leftSonNode);
			outputTreeNodeData(treeNode);
			LDRTree(treeNode.rightSonNode);
		}
	}
	
	/**
	 * 先序递归
	 * @param treeType
	 */
	void DLRTree(ChainTreeType treeNode) {
		
		if(treeNode != null) {
			outputTreeNodeData(treeNode);
			DLRTree(treeNode.leftSonNode);
			DLRTree(treeNode.rightSonNode);
		}
	}
	
	/**
	 * 按层遍历，使用队列
	 * @param treeNode
	 */
	void levelTree(ChainTreeType treeNode) {					//按层遍历
		
		ChainTreeType node;										
		ChainTreeType[] nodes = new ChainTreeType[MAXLEN];		//定义一个顺序栈 队列
		int tail = 0,head = 0;
		
		//获取树根节点，并将其压入栈内
		if(treeNode != null) {
			
			tail = (tail + 1) % MAXLEN;
			nodes[tail] = treeNode;
		}
		
		//按层进行循环压入与弹出节点
		while(tail != head) {
			
			head = (head + 1) % MAXLEN;	 
			node = nodes[head];			 //按顺序排出队列头里的节点
			
			outputTreeNodeData(node); 	 //处理节点
			
			//将下一层节点压入到队列中,（处理左右树分支节点，将其压入队列中）
			if(node.leftSonNode != null) {
				tail = (tail + 1) % MAXLEN;
				nodes[tail] = node.leftSonNode;
			}
			
			if(node.rightSonNode != null) {
				tail = (tail + 1) % MAXLEN;
				nodes[tail] = node.rightSonNode;
			}
			
			
		}
		
	}
	
	/**
	 * 显示节点数据
	 * @param treeNode
	 */
	void outputTreeNodeData(ChainTreeType treeNode) {
		if(treeNode != null)
			System.out.printf("%s ", treeNode.nodeData);
	}
	
	/**
	 * 清空树
	 * @param treeNode
	 */
	void clearTree(ChainTreeType treeNode) {
		if(treeNode != null) 
		{
			clearTree(treeNode.leftSonNode);	//先进入子节点清空占用，左节点
			clearTree(treeNode.rightSonNode);	//右节点
			
			treeNode = null;					//指向清空内存占用
		}
	}
	
	/**
	 * 计算树的深度
	 * @param treeNode
	 * @return
	 */
	int treeDepth(ChainTreeType treeNode) {
		int depLeft,depRight;
		
		if(treeNode == null) { 
			return 0;
		}else {
			
			depLeft = treeDepth(treeNode.leftSonNode);	//递归左边节点深度
			depRight = treeDepth(treeNode.rightSonNode);//递归右边节点深度
			
			
			if(depLeft > depRight) {					//获取深度最深的一边
				return depLeft + 1;						
			}else {
				return depRight + 1;
			}
		}
	}
	
	/**
	 * 判断是否是空树
	 * @param treeNode
	 * @return	1表示为空
	 */
	int treeIsEmpty(ChainTreeType treeNode) {
		
		if(treeNode != null)
			return 0;
		
		return 1;
	}
	
	/**
	 * 获取右节点
	 * @param treeNode
	 * @return
	 */
	ChainTreeType treeRightNode(ChainTreeType treeNode) {
		
		if(treeNode != null && treeNode.rightSonNode != null) 
			return treeNode.rightSonNode;
		
		return null;
	}
	
	/**
	 * 获取左节点
	 * @param treeNode
	 * @return
	 */
	ChainTreeType treeLeftNode(ChainTreeType treeNode) {
		
		if(treeNode != null && treeNode.leftSonNode != null) 
			return treeNode.leftSonNode;
		
		return null;
	}
	
	/**
	 * 添加节点
	 * @param treeNode
	 */
	void AddTreeNode(ChainTreeType treeNode) {
		
		ChainTreeType pNode,parent;
		String data;
		int menusel;
		
		if((pNode = new ChainTreeType()) != null) {
			
			System.out.println("input this tree node data:");
			
			pNode.nodeData = input.next();
			pNode.leftSonNode = null;
			pNode.rightSonNode = null;
			
			System.out.println("input this tree node the father data");
			data = input.next();
			
			parent = treeFindNode(treeNode, data);	//查找指定数据的节点
			if(parent == null)
			{
				System.out.println("not find the parent node!");
				pNode = null;
				
				return;
			}
			//选择要添加的节点，右节点或左节点 
			System.out.printf("1.add this node to left node.\n 2. add this node to right node");
			do {
				menusel = input.nextInt();
				
				if(menusel == 1 || menusel == 2) 
				{
					if(parent == null)
						System.out.println("not find parent node,please set the parent node first!");
					else
					{
						switch (menusel) {
						case 1:
							
							if(parent.leftSonNode != null)
								System.out.println("left node not null!");
							else 
								parent.leftSonNode = pNode;
							
							break;
						case 2:
							
							if(parent.rightSonNode != null)
								System.out.println("right node not null!");
							else 
								parent.leftSonNode = pNode;
							
							break;
						default:
							System.out.println("Oops , input error!");
							break;
						}
					}
				}
				
			} while (menusel != 1 && menusel != 2);
		}
	}
	
	/**
	 * 查找节点
	 * @param treeNode
	 * @param data
	 * @return
	 */
	ChainTreeType treeFindNode(ChainTreeType treeNode,String data) {
		ChainTreeType pTreeType;
		if(treeNode == null)
			return null;
		else 
		{
			if(treeNode.nodeData.equals(data)) 
			{
				return treeNode;
			}
			else 
			{
				//递归查找左节点
				if((pTreeType = treeFindNode(treeNode.leftSonNode, data)) != null)
					return pTreeType;
				//递归查找右节点
				else if((pTreeType = treeFindNode(treeNode.rightSonNode, data)) != null)
					return pTreeType;
				else 
					return null;
				
			}
		}
	}
	
	/**
	 * 初始化树
	 * @return
	 */
	public static ChainTreeType initTree() {
		
		/*
		 * if(TREE != null) return TREE;
		 * 
		 * synchronized (LOCK) { if(TREE == null) { TREE = new ChainTreeType();
		 * System.out.println("生成ROOT DATA"); TREE.nodeData = "ROOT DATA";
		 * TREE.leftSonNode = null; TREE.rightSonNode = null;
		 * 
		 * } return TREE; }
		 */
		ChainTreeType tree = null;
		{
			tree = new ChainTreeType();
			System.out.println("生成ROOTDATA");
			tree.nodeData = "ROOTDATA";
			tree.leftSonNode = null;
			tree.rightSonNode = null;
			return tree;
		}
		
	}

	public ChainTreeType() {
	}
}