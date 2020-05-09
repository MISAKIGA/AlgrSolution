package homework.data_structure.string;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Homework {
    public static void main(String[] args) {

        String studentId = "2009090312";
        String str1 = studentId.substring(0, 4);
        String str2 = studentId.substring(4, 6);
        String str3 = studentId.substring(6, 8);
        String str4 = studentId.substring(8, 10);

        System.out.println(str1 + ":" + str2
                + ":" + str3 + ":" + str4);
    }











    public void h1(){
        //构造函数创建str1
        String        str1 = new String("jiaammssttuuddeenntt");
        //构造函数创建str2字符串
        StringBuilder str2 = new StringBuilder(new String(""));
        int len = str1.length();

        for (int i = 1; i <= len; i += 2) {
            //str2 += str1.charAt(i);
            str2.append(str1.charAt(i));
        }
        System.out.println("str2=" + str2);

        char[] arr = new char[len/2];

        // O(n/2) 双指针，将下标为双号的字符放在arr中。j = 0；j++
        for (int i = 0,j = 0; i < len && j <= len/2; i += 2,j++) {
            // 0：0 j:i
            //1：2  j:i
            arr[j] = str1.charAt(i);
        }

        String str3 = new String(arr);
        System.out.println("str3=" + str3);
        //比较两者是否相等
        System.out.println(str2.toString().compareTo(str3) == 0);
    }
    public void h3(){
        String str1 = "level";
        String str2 = "abcddcba";
        String str3 = "abcddededa";

        System.out.println(str1 + "是否为回文字:" + handle(str1));
        System.out.println(str2 + "是否为回文字:" + handle(str2));
        System.out.println(str3 + "是否为回文字:" + handle(str3));
    }
    public static boolean handle(String str){
        String before = str.substring(0, str.length() / 2);
        //如果是奇数，少取一位。level，去掉 v，从e开始获取。偶数则直接返回后半段字符。
        String after = str.substring(
                str.length() % 2 != 0 ?
                        (str.length() / 2) + 1
                        : str.length() / 2);
        //反转字符串
        //1 List<char[]> chars = List.of(after.toCharArray());
        //Collections.reverse(chars);
        //2 after = new StringBuffer(after).reverse().toString();
        char[] chars = after.toCharArray();
        final int length = chars.length;
        // O(n/2)
        for (int i = 0; i < length / 2; i++) {
            /*char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = temp;*/
            //同一值异或两次等于值本身
            chars[i] ^= chars[length - i - 1];
            chars[length - i - 1] ^= chars[i];
            chars[i] ^= chars[length - i - 1];
        }
        
        after = new String(chars);
        System.out.println(after);
        return before.compareTo(after) == 0;
    }

    public void h2(){


    }

}
