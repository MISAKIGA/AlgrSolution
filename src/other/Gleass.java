package other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Gleass {

	/**
	 * 
设计猜两个乘数的程序。 等式x*y=result，x、y的取值范围是10~100的整数，
result是100~10000的整数，键盘输入result的值，找出全部符合等式的乘数，并输出所有符合要求的等式。
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int result = input.nextInt();
		if(!(result >= 100) && (result <= 10000)){
			System.out.println("请输入100-10000的数");
			return;
		}
		
		//for (int i = 10; i <= 100; i++) 
			//for (int j = i; (j <= 100); j++) 
				//if(i * j == result) 
					//System.out.printf("Oops! I'm find it! %d * %d = %d \n",i,j,result);
		
		rele(10, 10, result);
		
		if(map.entrySet() != null)
			for(Map.Entry<Integer, Integer> kEntry : map.entrySet()) {
				System.out.println(kEntry.getKey() + " * " + kEntry.getValue());
			}
	}
	
	//static List<Map<Integer, Integer>[]> results;
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void rele(int x,int y,int result) {
		if(x > 100 || y > 100)
			return;
		
		rele(x + 1, ++y + 1, result);
		
		if(x * y == result) {
			map.put(x, y);
			return;
		}else if(x + 1 * y + 1 == result) {
			map.put(x + 1, y + 1);
			return;
		}
		
		rele(++x, y, result);
	}
	
	public static void rele1(int x,int y,int result) {
		rele(x, y, result);
	}

}
