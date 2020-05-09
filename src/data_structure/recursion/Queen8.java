package data_structure.recursion;

public class Queen8 {

	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	
	public static void main(String[] args) {
		
		Queen8 queen8 = new Queen8();
		queen8.check(0);
		System.out.println("解法" + count);
	}

	/**
	 * 放置第n个皇后
	 * @param n
	 */
	private void check(int n) {
		if(n == max) {
			print();
			return;	
		}
		
		//依次放入皇后
		for (int i = 0; i < max; i++) {
			//先把当前的这个皇后n，放到该行的第1列
			array[n] = i; 
			//判断放置第n个皇后到i列时，是否冲突
			if(judge(n)) {
				//不冲突，接着放n+1个皇后
				check(n + 1);
			} 
			
			//如果冲突，继续执行for循环，相当于往后移动一列
		}
	}
	
	/**
	 * 判断是否冲突
	 * @param n 表示第n个皇后
	 * @return
	 */
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			// 判断第n个皇后是否跟n-1个皇后在同一列
			// 是否在统一斜线
			// 是否在同一行
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
