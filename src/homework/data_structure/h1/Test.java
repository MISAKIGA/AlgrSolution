package homework.data_structure.h1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkTable linkTable = new LinkTable();
		linkTable.insert(10);
		linkTable.insert(20);
		linkTable.insert(30);
		linkTable.insert(40);
		linkTable.insert(50);
		linkTable.insert(60);
		
		linkTable.insert(3,88);
		linkTable.print();				
	}

}
