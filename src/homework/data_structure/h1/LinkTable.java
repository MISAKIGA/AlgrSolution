package homework.data_structure.h1;

public class LinkTable {
private LinkNode head = null;
private int counts=0;
void insert(int d) {
	if(head == null) {
		head =new LinkNode();
	}
	LinkNode n = new LinkNode();
	n.setData(d);
	if(head.getNext()==null) {
		head.setNext(n);
		return;
	}else {
		n.setNext(head.getNext());
		head.setNext(n);
	}
	counts++;
}
void insert(int i, int d) {
	
	if(head == null) {
		head = new LinkNode();
	}
	
	LinkNode data = new LinkNode();
	data.setData(d);
	
	if(head.getNext() != null) {
		LinkNode tempHead = head;
		int j = i;
		while(tempHead.getNext() != null && j > 0) {
			tempHead = tempHead.getNext();
			j--;
		}
		
		if(j == 0) {
			if(tempHead.getNext() != null) {
			
				LinkNode next = tempHead.getNext();
				data.setNext(next);
				tempHead.setNext(data);
			}
		}else {
			tempHead.setNext(data);
		}
	}
	
	
}
public void print() {
	LinkNode n = head.getNext();
	while(n!=null) {
		System.out.println(n.getData()+"");
		n=n.getNext();
	}
}
public int size() {
	return this.counts;
}
}
