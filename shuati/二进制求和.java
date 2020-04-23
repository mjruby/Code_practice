package leetcode;
// 给你两个二进制字符串，返回它们的和（用二进制表示）。
//输入为 非空 字符串且只包含数字 1 和 0。

// 输入: a = "1010", b = "1011"
// 输出: "10101"

import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;

public class 二进制求和 {
    public static void main(String[] args) {
        String str1 = "10";
        String str2 = "1011";
        System.out.println(Integer.parseInt(addBinary(str1,str2)));
//        char[] ch = new char[]{'a','b','c'};
//        System.out.println(new String(ch)+"");

        System.out.println(Integer.parseInt(addBinary2(str1,str2)));
    }

    public static String addBinary(String a, String b) {
        if(a == null || a.length() ==0 ) return b;
        if(b== null || b.length() ==0) return a;
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1,len2);
        int[] ch = new int[len];
        int carry = 0 ;
        int i = len1-1,j=len2-1,k=len-1;
        int num1 = 0;
        int num2 = 0;
        while(i>=0 && j>=0){
            num1 = Integer.parseInt(a.charAt(i--)+"");
            num2 = Integer.parseInt(b.charAt(j--)+"");
            ch[k--] = (num1+num2+carry)%2;
            carry = (num1+num2+carry)/2;
        }
        while (i>=0){
            num1 = Integer.parseInt(a.charAt(i--)+"");
            ch[k--] = (num1+carry)%2;
            carry = (num1+carry)/2;
        }
        while (j>=0){
            num2 = Integer.parseInt(b.charAt(j--)+"");
            ch[k--] = (num2+carry)%2;
            carry = (num2+carry)/2;
        }
        StringBuilder sb = new StringBuilder("");
        if(carry != 0){
            sb.append(carry);
            for (int i1 = 0; i1 < ch.length; i1++) {
                sb.append(ch[i1]);
            }
        }else {
            for (int i1 = 0; i1 < ch.length; i1++) {
                sb.append(ch[i1]);
            }
        }
        return sb.toString();
    }

    // 别人的思路
    public static String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;
        int sum = 0;
        for(int i = a.length()-1, j = b.length() -1; i>=0 || j>=0 ;i--,j--){  // 短的字符串会补0，继续运算
            sum = ca;
            sum += i>=0? a.charAt(i)-'0':0;
            sum += j>=0? b.charAt(j)-'0':0;
            sb.append(sum%2);
            ca = sum/2;
        }
        return sb.append(ca!=0? ca:"").reverse().toString();  // 反转函数***
    }
}
