package homework.data_structure.h1;

import java.text.NumberFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author MISAKIGA
 */
public class U7Review {

	public static void main(String[] args) {
		
/*		String[] ss = U7Review.asArray("a","b","c");
		
		 String[] firstTwo = pickTwo("one", "two", "three");
		 System.out.println(Arrays.toString(firstTwo));*/

		//var usFormatter = DateTimeFormatter.ofPattern("E, MMMM/dd/yyyy HH:mm", Locale.US);
		//System.out.println(usFormatter.format(ZonedDateTime.now()));

		System.out.println(Instant.now());

		// 以指定时间戳创建Instant:
		Instant ins = Instant.ofEpochSecond(1568568760);
		ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
		System.out.println(zdt); // 2019-09-16T01:32:40+08:00[Asia/Shanghai]

		long ts = 1574208900000L;
		System.out.println(timestampToString(ts, Locale.CHINA, "Asia/Shanghai"));
		System.out.println(timestampToString(ts, Locale.US, "America/New_York"));
	}

	static String timestampToString(long epochMilli, Locale lo, String zoneId) {
		Instant ins = Instant.ofEpochMilli(epochMilli);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
		return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
	}
	
	public static void h2() {
		ArrayList<Character> list = new ArrayList<>();
		list.add('a');
		list.add('a');//1
		list.add('a');
		list.add('a');//3
		list.add('d');
		list.add('s');//5
		list.add('l');
		list.add('l');//7
		
		int size = list.size();
		int newSize = size/2;
		Character[] newArray = new Character[newSize];
		
		int j = 0;
		for (int i = 1; i < list.size(); i+=2) {
			newArray[j++] = list.get(i);
		}
		
		System.out.println(Arrays.toString(newArray));
		
		/***------
		 * 
		 */
		//list.toArray(Character[]::new);
		//var b = "a";
		System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(123400));
	}

	public static void h1() {
		ArrayList<Character> list = new ArrayList<>();
		int count = 0;
		list.add('a');
		list.add('a');
		list.add('a');
		list.add('a');
		list.add('d');
		list.add('d');
		list.add('a');
		list.add('o');
		list.add('l');
		
		
		char key = 'd';
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(key)){
				count++;
			}
		}
		System.out.println(key +"出现了:"+ count + "次");

		
		//HashMap 键值唯一
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			Character key1 = list.get(i);
			map.put(key1, map.containsKey(key1)? (map.get(key1))+1 : 1);
		}
		
		map.forEach((k,v) ->{
			System.out.println(k + ":" + v);
		});
	}
	
	@SafeVarargs
	public static <T> T[] asArray(T... objs) {
		return objs;
	}

	//因为擦拭法，在pickTwo()方法内部，编译器无法检测K[]的正确类型，
	//因此返回了Object[]。
	static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2);
    }
}
