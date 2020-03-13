package leetcodes;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseInteger {

	//input 32 bit integer String , reverse that and print
	//input 123
	//output 321
	//intput -123
	//output -321
	//input 210
	//outout 12
	public int reverseInteger(String src) {
		
		if(src.isEmpty()) {
			System.out.println("input data is null, please input 32 bit integer");
			//throw new RuntimeErrorException(new Error("input is null,please"));
		}
		
		String symbol = "-";
		Boolean hasSymbol = false;
		
		if(src.matches(symbol)) {
			hasSymbol = true;
			String[] strings = src.split(symbol);
			src = strings.length > 1 ? strings[1] : null;
		}
		
		try {
			Integer.valueOf(src);
		} catch (NumberFormatException e) {
			System.out.println("please input 32 bit integer!");
		}

		int parseSrc = 0;
		try {
			parseSrc = Integer.parseInt(src);
		} catch (NumberFormatException e) {
			System.out.println("oops ! parse int error");
		}
		
		return beginVerifyAndReverse(parseSrc,hasSymbol);
	}

	private int beginVerifyAndReverse(int src,Boolean hasSymbol) {
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		do {
			//src
			deque.add(0);
			
		} while (true);
	}
}
