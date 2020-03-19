package homework.data_structure;


public class LinkedList<T> {
	public static void main(String[] args) {

		LinkedList<Character> linkedList = new LinkedList<>();
		linkedList.addLast('A');
		linkedList.addLast('B');
		linkedList.addLast('C');
		linkedList.addLast('D');
		
		linkedList.insert(1, 'A');
		linkedList.foreach();
		
		System.out.println("-----删除头节点---------");
		linkedList.removeFirst();
		
		linkedList.foreach();
		
		try {
			linkedList.reverse(linkedList.size);
		} catch (Exception non) {}

	}
	
	private int size;
	private Node<T> first;
	private Node<T> last;
	
	public LinkedList() {
		init();
	}
	
	public void reverse(int index) throws RuntimeException{
		
		if(index <=  0)
			return;

		Node<T> nodeTemp = this.first;

		System.out.println("-------- add --------");
		this.addLast(nodeTemp.item);
		this.foreach();

		System.out.println("-------- remove --------");
		this.removeFirst();
		this.foreach();

		reverse(index >> 1);
	}
	
	private void init() {
		first = new Node<>();	
		size = 0;
	}
	
	public void removeFirst() {
		unLinkNode(first);
	}

	public void foreach() {
		
		Node<T> temp = first;
		while(temp != null) {
			
			System.out.printf(temp.item.toString());
			
			temp = temp.next;
		}
		System.out.println();
	}
	
	public T insert(int i,T t) {
		
		if(i > size || i < 0 || t == null)
			return null;
		
		linkNode(getNode(i), t);
		return t;
	}
	
	private Node<T> getNode(int i) {
		
		Node<T> temp = first;
		
		if(temp != null) {

			for (int j = 0; j < i; j++) {
				temp = temp.next;
			}
			return temp;
		}
		return null;
	}

	public void unLinkNode(Node<T> node) {
		Node<T> next = node.next;

		Node<T> prev = node.prev;

		if(prev == null) {
			first = next;
		}
		else {
			prev.next = next;
			node.prev = null; 
		}
		if(next == null) {
			last = prev;
		}else {
			next.prev = prev;
			node.next = null;
		}
		
		node.item = null;
		node = null; 
		
		size--;
	}
	
	public void linkNode(Node<T> node,T t) {
		
		Node<T> n = node;
		Node<T> nNext = node.next;

		Node<T> newNode = new Node<>(t, nNext, n);
		
		if(nNext != null)
			nNext.prev = newNode;

		n.next = newNode;
		
		size++;
	}
	
	@Override
	public String toString() {
		return "LinkedList [size=" + size + ", first=" + first + ", last=" + last + "]";
	}

	public T addLast (T t) {
		linkLast(t);
		return t;
	}

	public void linkLast(T t) {

		Node<T> l = last;
		
		Node<T> newNode = new Node<>(t, null, l);
		last = newNode;
		if(l == null) {
			first = newNode;
		}else {
			l.next = newNode;
		}
		
		size++;
	}
	
}

class Node<T>{
	
	T item;
	Node<T> next;
	Node<T> prev;
	
	public Node() {}

	Node(T item, Node<T> next, Node<T> prev) {
		super();
		this.item = item;
		this.next = next;
		this.prev = prev;
	}
}


