package homework.data_structure.tree.hw;

public class BinaryTree <Key extends Comparable<Key>,Value>{

	public static void main(String[] args) {
		BinaryTree<Integer, String > bTree = new BinaryTree<>();
		bTree.put(4, "总经理");
		bTree.put(3, "部门一经理");
		bTree.put(1, "部门1老员工");
		bTree.put(6, "部门二经理");
		bTree.put(5, "部门二新员工");
		bTree.put(7, "部门二老员工");
		bTree.put(0, "部门二老员工1");
		System.out.printf("bt.root.value:%s \n",bTree.root.value);
		System.out.printf("root.left.value:%s \n",bTree.root.left.value);
		System.out.printf("root.right.value:%s \n",bTree.root.right.value);
		//bTree.delete(6);
		System.out.println(bTree.size());
		System.out.println(bTree.root.right.value);
		String value = bTree.get(7);
		System.out.println("Search 7 :" + value);
		bTree.delete(4);
		value = bTree.get(4);
		System.out.println("delete 7 :" + value);
		System.out.printf("bt.root.value:%s \n",bTree.root.value);
	}

	
	Node root;
	private int N;
	
	public int size() {
		return N; 
	}
	
	public void delete(Key key) {
		root = delete(root,key);
	}
	
	@SuppressWarnings("unchecked")
	private Node<Integer,Value> delete(Node x, Key key) {
		if(x == null) {
			return null;
		}
		
		int cmp = key.compareTo((Key)x.key);
		
		if(cmp > 0) {
			//向右查找并且删除，删除后的值赋予当前x的右子树
			x.right = delete(x.right, key);
		} else if(cmp < 0) {
			//向左查找并且删除，删除后的值赋予当前x的左子树
			x.left = delete(x.left, key);
		} else {
			//1.处理\删除节点
			
			//1.1.1如果没有右子树，返回当前节点的左子树
			if(x.right == null) {
				//假设上一次递归代码 是 x.right = delete（）
				//所以这里返回后直接覆盖了上一次递归的节点（当前父节点）
				//相当于删除了节点，所以节点-1 
				N--;
				return x.left;
			}
			//1.1.2如果没有左子树，返回当前节点的右子树
			if (x.left == null) {
				N--;
				return x.right;
			}
			
			//1.2当前左右节点都存在

			Node minNode = x.right;
			while(minNode.left != null) {
				
				//2)获取最小右节点
				minNode = minNode.left;
			}
			
			Node n = x.right;
			while(minNode.left != null) {
				//1)删除树中的最小右节点
				if(n.left.left == null) {
					n.left = null;
				} else {
					n = n.left;
				}
			}
			
			//1.2.3 将被删除的节点（minNode），覆盖当前节点
			//	那么当前节点的左右节点怎么处理？
			//	把他交给minNode节点（因为它要覆盖当前节点嘛）
			// 1) 先把把当前节点的左右节点复制（指针指向）到minNode.
			minNode.left = x.left;
			minNode.right = x.right;
			// 2）用minNode覆盖当前节点
			x = minNode;
			
			// 3）既然删除了节点，就要N--;
			N--;
			System.out.println("Node -1");
		}
		//更新root节点，把修改后的root节点返回给调用者
		return x;
	}

	public Value get(Key key) {
		return get(root,key);
	}
	
	@SuppressWarnings("unchecked")
	private Value get(@SuppressWarnings("rawtypes") Node x, Key key) {
		//递归方法结束条件
		if(x == null) {
			return null;
		}
		//跟当前父节点节点(x)比较大小
		int cmp = key.compareTo((Key)x.key);
		
		if(cmp > 0) {
			//如果比父节点大，由于排序树的特性，
			//大于父节点的节点存储在右子树，小于则存储在左子树，
			//例如：key值比父节点大，所以要往右子树查找，不断重复直到找到或遍历完成为止
			return get(x.right, key);
		} else if(cmp < 0) {
			return get(x.left,key);
		} else {
			//Java泛型真正存储的类型（Class）是Object
			//返回操作需要转换为Value类型，上面的x.key道理同样
			return (Value)x.value;
		}
	}

	public void put(Key key,Value value) {
		root = put(root, key ,value);
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private Node<Key, Value> put(@SuppressWarnings("rawtypes") Node x, Key key, Value value) {
		if(x == null) {
			N++;
			//新增root节点。
			//分析：
			//第一次进入put，将第一个输入的值作为root节点（总经理）
			//如果存在root节点，比较大小，大于父节点的放在右子树，小于则放在左子树
			//根据上面条件递归查找，直到找到合适的存储位置。
			//假设下一次为右子树，递归进入方法时，
			//将父节点（叶子节点）的右子树、要插入的key和value放入方法中，
			//下一次递归进入方法时，由于右子树未被创建，x=null
			//就会在此处创建一个新节点连接上父节点的右子树。
			Node<Key,Value> nNode = null;
			if((nNode = new Node<>(key, value, null, null)) == null) {
				System.out.println("failed to apply for memory");
			}
			return nNode;
		}
		//当前key与x.key比较
		int cmp = key.compareTo((Key)x.key);
		
		if(cmp > 0) {
			//大于当前节点的父节点（x）的放在右子树
			x.right = put(x.right, key, value);
		} else if(cmp < 0) {
			//小于当前节点的父节点（x）的放在左子树
			x.left = put(x.left, key, value);
		} else {
			//等于当前父节点（x）的直接覆盖节点
			x.value = value;
		}
		
		//更新root节点，把修改后的root节点返回给调用者
		return x;
	}
}

@SuppressWarnings("hiding")
class Node<Key,Value> {
	public Key key;
	Value value;
	public Node left;
	public Node right;
	public Node(Key key, Value value, Node left, Node right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
}
