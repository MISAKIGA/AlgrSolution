package homework.data_structure.tree;

/**
 * 
 * @author MISAKIGA create by 20-4-12
 *
 */
public class BinaryTree {

	public static void main(String[] args) {

		// 创建二叉树

		BinaryTree tree = new BinaryTree();
		// 创建节点
		BinaryNode root = new BinaryNode("A");
		BinaryNode node2 = new BinaryNode("B");
		BinaryNode node3 = new BinaryNode("C");
		BinaryNode node4 = new BinaryNode("D");
		BinaryNode node5 = new BinaryNode("E");

		root.setLeftSubTree(node2);
		root.setRightSubTree(node3);
		node3.setRightSubTree(node4);
		node3.setLeftSubTree(node5);
		tree.setRoot(root);

		
		System.out.println("前序遍历");
		tree.preOrder();

		System.out.println("中序遍历");
		tree.infixOrder();

		System.out.println("后序遍历");
		tree.postOrder();

		/*
		 * System.out.println("前序查找"); BinaryNode resNode = tree.preOrderSearch("E"); if
		 * (resNode != null) { System.out.println("Find it！ ： " + resNode.getData()); }
		 * else { System.out.println("Not Find"); }
		 * 
		 * System.out.println("中序查找"); resNode = tree.infixOrderSearch("E"); if (resNode
		 * != null) { System.out.println("Find it！ ： " + resNode.getData()); } else {
		 * System.out.println("Not Find"); }
		 * 
		 * System.out.println("后序查找"); resNode = tree.postOrderSearch("E"); if (resNode
		 * != null) { System.out.println("Find it！ ： " + resNode.getData()); } else {
		 * System.out.println("Not Find"); }
		 * 
		 * System.out.println("删除前"); tree.preOrder(); tree.delNode("C");
		 * System.out.println("删除后"); tree.preOrder();
		 */
	}

	private BinaryNode root;

	public void setRoot(BinaryNode root) {
		this.root = root;
	}

	/**
	 * 查询
	 */
	public BinaryNode preOrderSearch(Object obj) {
		if (this.root != null) {
			return root.preOrderSearch(obj);
		}
		return null;
	}

	public BinaryNode infixOrderSearch(Object obj) {
		if (this.root != null) {
			return root.infixOrderSearch(obj);
		}
		return null;
	}

	public BinaryNode postOrderSearch(Object obj) {
		if (this.root != null) {
			return root.postOrderSearch(obj);
		}
		return null;
	}

	/**
	 * 遍历
	 */
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
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
		if (root != null) {
			if (root.data.equals(obj)) {
				root = null;
			} else {
				root.delNode(obj);
			}
		} else {
			System.out.println("Null tree");
		}
	}
}

class BinaryNode {

	BinaryNode leftSubTree;
	BinaryNode rightSubTree;
	Object data;

	public BinaryNode(Object data) {
		super();
		this.data = data;
	}

	public BinaryNode(BinaryNode leftSubTree, BinaryNode rightSubTree, Object data) {
		super();
		this.leftSubTree = leftSubTree;
		this.rightSubTree = rightSubTree;
		this.data = data;
	}

	@Override
	public String toString() {
		return "BinaryTree [data=" + data + "]";
	}

	/**
	 * 遍历
	 */
	public void preOrder() {
		System.out.println(this);

		// 递归向左子树遍历
		if (this.leftSubTree != null) {
			// preOrder(this.leftSubTree);
			this.leftSubTree.preOrder();
		}
		// 递归向右子树遍历
		if (this.rightSubTree != null) {
			this.rightSubTree.preOrder();
		}
	}

	public void infixOrder() {
		// 递归向左子树中序遍历
		if (this.leftSubTree != null) {
			this.leftSubTree.infixOrder();
		}
		// 输出当前父节点
		System.out.println(this);

		// 递归向右子树中序遍历
		if (this.rightSubTree != null) {
			this.rightSubTree.infixOrder();
		}
	}

	public void postOrder() {
		if (this.leftSubTree != null) {
			this.leftSubTree.postOrder();
		}
		if (this.rightSubTree != null) {
			this.rightSubTree.postOrder();
		}
		System.out.println(this);
	}

	public BinaryNode getLeftSubTree() {
		return leftSubTree;
	}

	public void setLeftSubTree(BinaryNode leftSubTree) {
		this.leftSubTree = leftSubTree;
	}

	public BinaryNode getRightSubTree() {
		return rightSubTree;
	}

	public void setRightSubTree(BinaryNode rightSubTree) {
		this.rightSubTree = rightSubTree;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	/**
	 * 删除
	 */
	public void delNode(Object obj) {
		// 向下（左右子树）查找，找到即删除
		if (this.leftSubTree != null && this.leftSubTree.data.equals(obj)) {
			if (this.leftSubTree.leftSubTree != null) {
				if (this.leftSubTree.rightSubTree != null) {
					this.leftSubTree.leftSubTree.leftSubTree = this.leftSubTree.rightSubTree;
				}
				this.leftSubTree = this.leftSubTree.leftSubTree;
				return;
			}
			this.leftSubTree = null;
			return;
		}

		if (this.rightSubTree != null && this.rightSubTree.data.equals(obj)) {
			if (this.rightSubTree.leftSubTree != null) {
				if (this.rightSubTree.rightSubTree != null) {
					this.rightSubTree.leftSubTree.leftSubTree = this.leftSubTree.rightSubTree;
				}
				this.rightSubTree = this.rightSubTree.leftSubTree;
				return;
			}
			this.rightSubTree = null;
			return;
		}

		// 递归删除
		if (this.leftSubTree != null) {
			this.leftSubTree.delNode(obj);
		}
		if (this.rightSubTree != null) {
			this.rightSubTree.delNode(obj);
		}
	}

	/**
	 * 查找
	 */
	public BinaryNode preOrderSearch(Object obj) {
		System.out.println("进入前序查找");
		if (this.data.equals(obj)) {
			return this;
		}
		// 向左子树查找
		BinaryNode resNode = null;
		if (this.leftSubTree != null) {
			resNode = this.leftSubTree.preOrderSearch(obj);
		}
		// 如果找到了则返回
		if (resNode != null) {
			return resNode;
		}

		if (this.rightSubTree != null) {
			resNode = this.rightSubTree.preOrderSearch(obj);
		}

		return resNode;
	}

	public BinaryNode infixOrderSearch(Object obj) {
		BinaryNode resNode = null;
		if (this.leftSubTree != null) {
			resNode = this.leftSubTree.infixOrderSearch(obj);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入中序查找");
		if (this.data.equals(obj)) {
			return this;
		}

		if (this.rightSubTree != null) {
			resNode = this.rightSubTree.infixOrderSearch(obj);
		}

		return resNode;
	}

	public BinaryNode postOrderSearch(Object obj) {
		BinaryNode resNode = null;
		if (this.leftSubTree != null) {
			resNode = this.leftSubTree.postOrderSearch(obj);
		}
		if (resNode != null) {
			return resNode;
		}

		if (this.rightSubTree != null) {
			resNode = this.rightSubTree.postOrderSearch(obj);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入后序查找");
		if (this.data.equals(obj)) {
			return this;
		}
		return resNode;
	}


}
