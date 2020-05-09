package homework.data_structure.tree.threadedtree;

import static org.hamcrest.CoreMatchers.nullValue;

import org.ietf.jgss.Oid;

public class ThreadedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = new BinaryNode(1);
		BinaryNode node1 = new BinaryNode(3);
		BinaryNode node2 = new BinaryNode(6);
		BinaryNode node3 = new BinaryNode(8);
		BinaryNode node4 = new BinaryNode(10);
		BinaryNode node5 = new BinaryNode(14);
		
		root.setLeftSubTree(node1);
		root.setRightSubTree(node2);
		node2.setLeftSubTree(node3);
		node2.setRightSubTree(node4);
		node3.setLeftSubTree(node5);
		
		//线索化
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		tree.setRoot(root);
	
		tree.PostThreadNodes();
	
		
		BinaryNode leftNode = node5.getLeftSubTree();
		BinaryNode rightNode = node5.getRightSubTree();
		System.out.println("10:" + leftNode.getData());
		System.out.println("10:" + rightNode.getData());
		
		System.out.println("使用线索化遍历");
		tree.threadList();
	}

private BinaryNode root;
//存储前一个节点
private BinaryNode pre = null;	
	public void setRoot(BinaryNode root) {
		this.root = root;
	}
	//遍历线索化方法
	public void threadList() {
		BinaryNode node = root;
		while(node != null) {
			//循环查找leftType =1的节点
			while(node.getLeftType() == 0) {
				node = node.getLeftSubTree();
			}
			
			System.out.println(node.getData());
			
			//如果是后继节点，则输出值
			while(node.getRightType() == 1) {
				//获取当前节点的后继节点
				node = node.getRightSubTree();
				System.out.println(node.getData());
			}
			node = node.getRightSubTree();
		}
	}
	/**
	 * 遍历中序线索化
	 */
	public void threadedNodes() {
		if(root != null)
			threadedNodes(root);
	}
	
	/**
	 * 遍历后序线索化
	 */
	public void PostThreadNodes() {
		if(root != null)
			threadedNodes(root);
	}
	/**
	 * 遍历前序线索化
	 */
	public void PreThreadedNodes() {
		if(root != null)
			threadedNodes(root);
	}
	
	//后继线索化
	public void PostThreadNodes(BinaryNode node) {
		if(node == null) {
			return;
		}
		
		PostThreadNodes(node.left);
		PostThreadNodes(node.right);
		
		//处理前驱节点
		if(node.left == null) {
			node.left = pre;
			node.leftType = 1;
		}
		//处理后继节点
		if(pre != null && pre.right == null) {
			pre.right = node;
			pre.leftType = 1;
		}
		
		pre = node;
	}
	//前驱线索化
	public void PreThreadedNodes(BinaryNode node) {
		if(node == null) {
			return;
		}
		
		//处理前驱节点
		if(node.left == null) {
			node.left = pre;
			node.leftType = 1;
		}
		//处理后驱节点
		if(pre != null && pre.right == null) {
			pre.right = node;
			pre.leftType = 1;
		}
		pre = node;
		
		//处理左右子树
		PreThreadedNodes(node.left);
		PreThreadedNodes(node.right);
	}
	
	/**
	 *   二叉树中序线索化
	 * @param node 当前需要线索化的节点
	 */
	public void threadedNodes(BinaryNode node) {
		if(node == null) {
			return;
		}
		
		//线索化左子树
		threadedNodes(node.left);
		
		//线索化当前节点
		//处理当前节点的前驱节点
		if(node.left == null) {
			//让当前节点的左指针指向前驱节点
			node.left = pre;
			//修改当前节点额左指针类型,指向前驱节点
			node.leftType = 1;
		}
		//处理后继节点
		if(pre != null && pre.right == null) {
			//让前驱节点的右指针 指向当前节点
			pre.right = node;
			//修改前驱节点的右指针类型
			pre.rightType = 1;
		}
		
		// 每处理一个节点，让当前节点是下一个节点的前驱节点
		pre = node;
		
		//线索化右子树
		threadedNodes(node.right);
	}
	
	
	/**
	 * 查询
	 */
	public BinaryNode preOrderSearch(Object obj) {
		if(this.root != null) {
			return root.preOrderSearch(obj);
		}
		return null;
	}
	public BinaryNode infixOrderSearch(Object obj) {
		if(this.root != null) {
			return root.infixOrderSearch(obj);
		}
		return null;
	}
	public BinaryNode postOrderSearch(Object obj) {
		if(this.root != null) {
			return root.postOrderSearch(obj);
		}
		return null;
	}
	
	/**
	 * 遍历
	 */
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空");
		}
	}

	public BinaryNode getRoot() {
		return root;
	}
	/**
	 * 删除
	 */
	public void delNode(Object obj) {
		if(root != null) {
			if(root.data.equals(obj)) {
				root = null;
			}else {
				root.delNode(obj);
			}
		}else {
			System.out.println("Null tree");
		}
	}
}

class BinaryNode{
	
	BinaryNode left;
	BinaryNode right;
	Object data;
	
	//等于0表示指向 左\右子树，如果是1则表示指向 前驱节点\后继节点
	int leftType;
	int rightType;
	
	public BinaryNode(Object data) {
		super();
		this.data = data;
	}
	
	public BinaryNode(BinaryNode leftSubTree, BinaryNode rightSubTree, Object data) {
		super();
		this.left = leftSubTree;
		this.right = rightSubTree;
		this.data = data;
	}

	@Override
	public String toString() {
		return "BinaryTree [data=" + data + "]";
	}
	

	/**
	 * 删除
	 */
	public void delNode(Object obj) {
		//向下（左右子树）查找，找到即删除
		if(this.left != null && this.left.data.equals(obj)) {
			if(this.left.left != null) {
				if(this.left.right != null) {
					this.left.left.left = this.left.right;
				}
				this.left = this.left.left;
				return;
			}
			this.left = null;
			return;
		}
		
		if(this.right != null && this.right.data.equals(obj)) {
			if(this.right.left != null) {
				if(this.right.right != null) {
					this.right.left.left = this.left.right;
				}
				this.right = this.right.left;
				return;
			}
			this.right = null;
			return;
		}
		
		//递归删除
		if(this.left != null) {
			this.left.delNode(obj);
		}
		if(this.right != null) {
			this.right.delNode(obj);
		}
	}
	/**
	 * 查找
	 */
	public BinaryNode preOrderSearch(Object obj) {
		System.out.println("进入前序查找");
		if(this.data.equals(obj)) {
			return this;
		}
		//向左子树查找
		BinaryNode resNode = null;
		if(this.left != null) {
			resNode = this.left.preOrderSearch(obj);
		}
		//如果找到了则返回
		if(resNode != null) {
			return resNode;
		}
		
		if(this.right != null) {
			resNode = this.right.preOrderSearch(obj);
		}
		
		return resNode;
	}
	
	public BinaryNode infixOrderSearch(Object obj) {
		BinaryNode resNode = null;
		if(this.left != null) {
			resNode = this.left.infixOrderSearch(obj);
		}
		if(resNode != null) {
			return resNode;
		}
		System.out.println("进入中序查找");
		if(this.data.equals(obj)) {
			return this;
		}
		
		if(this.right != null) {
			resNode = this.right.infixOrderSearch(obj);
		}
		
		return resNode;
	}
	public BinaryNode postOrderSearch(Object obj) {
		BinaryNode resNode = null;
		if(this.left != null) {
			resNode = this.left.postOrderSearch(obj);
		}
		if(resNode != null) {
			return resNode;
		}
		
		if(this.right != null) {
			resNode = this.right.postOrderSearch(obj);
		}
		if(resNode != null) {
			return resNode;
		}
		System.out.println("进入后序查找");
		if(this.data.equals(obj)) {
			return this;
		}
		return resNode;
	}
	
	/**
	 * 遍历
	 */
	public void preOrder() {
		System.out.println(this);
		
		//递归向左子树遍历
		if(this.left != null) {
			//preOrder(this.leftSubTree);
			this.left.preOrder();
		}
		//递归向右子树遍历
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	public void infixOrder() {
		//递归向左子树中序遍历
		if(this.left != null) {
			this.left.infixOrder();
		}
		//输出当前父节点
		System.out.println(this);
		
		//递归向右子树中序遍历
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	
	public void postOrder() {
		if(this.left != null) {
			this.left.postOrder();
		}
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	public BinaryNode getLeftSubTree() {
		return left;
	}

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public void setLeftSubTree(BinaryNode leftSubTree) {
		this.left = leftSubTree;
	}

	public BinaryNode getRightSubTree() {
		return right;
	}

	public void setRightSubTree(BinaryNode rightSubTree) {
		this.right = rightSubTree;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}

