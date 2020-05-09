package ease;





public class exchange {

	public static void main(String[] args) {

		/*
		 * int x = 9,y = 5; x = x ^ y; y = x ^ y; x = x ^ y;
		 */
	
		numTower(5);
		//System.out.println(arm(153))
	}

	public static void exchange(int[] arr,int i,int j) {
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
	
	public static void hanoi(int left,int mid,int right) {
		
		
	}
	
	public static void arm(int key) {
	
		int a,b,c;
		for (int i = 100; i < 1000; i++) {
			a = i %100 / 10;
			b = i / 100 % 10;
			c = i %10;
			//System.out.println(a + ":" + b + ":" + c  + ":"  + i);
			if(i == a * a * a + b * b *b + c * c * c) {
				System.out.println(i);
			}
		}
	}
	public static void numTower(int lineNum) {
		for (int i = 1; i < lineNum; i++) {
			
			for (int j = lineNum; j >= i; j--) {
				System.out.printf("A");
			}
			
			for (int j = 1; j <= i; j++) {
				
				System.out.printf(j + " ");
			}
			for (int j = i -1; j >= 1; j--) {
				System.out.printf(j + " ");
			}
			System.out.println();
		}
	}
	public static int gcd(int left,int right) {
		if(right == 0)
			return left;
		return gcd(right, left %right);
	}

}
