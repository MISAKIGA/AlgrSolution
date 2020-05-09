package data_structure.array;

public class SparseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//稀疏数组转换
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[3][4] = 3;
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.print(data + "  ");
			}
			System.out.println();
		}
			
		
		re(ch(chessArr1));
	}
	
	public static void re(int[][] arr) {
		int chessArr[][] = new int[arr[0][0]][arr[0][1]];
		
		
		for (int i = 1; i < arr.length; i++) {
			chessArr[arr[i][0]][arr[i][1]] = arr[i][2];
		}
		
		System.out.println("恢复后");
		for(int[] row : chessArr) {
			for(int data : row) {
				System.out.print(data + "  ");
			}
			System.out.println();
		}
	}
	
	public static int[][] ch(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] != 0) {
					sum++;
				}
			}
		}
		
		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] != 0) {
					count++;
					sparseArr[count][0] = i; 
					sparseArr[count][1] = j;
					sparseArr[count][2] = arr[i][j];
				}
			}
		}
		
		System.out.println("稀疏数组");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		System.out.println();
		return sparseArr;
	}

}
