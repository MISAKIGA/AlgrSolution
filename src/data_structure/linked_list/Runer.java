package data_structure.linked_list;

public class Runer {

	public static void main(String[] args) throws Exception {
		
		System.out.println(Math.min(5, 20));

                
		
		 SequenceList<String> squence = new SequenceList<>(10); 
		 squence.insert("hello");
		 squence.insert(1, "world"); 
		 squence.insert(1, "world"); 
		 squence.insert(1, "world"); 
		 squence.insert(0, "world"); 
		 squence.showEles();
		 squence.insert(5,"aa"); squence.insert(5,"aa"); squence.insert(5,"aa");
		 squence.insert(5,"aa"); squence.insert(5,"aa");
		 System.out.println(squence.capacity()); squence.remove(1); squence.remove(1);
		 squence.remove(1); squence.remove(1); squence.remove(1); squence.remove(1);
		  squence.remove(1); squence.remove(1);
		 
		
	}
}
