package offer;

import java.util.Scanner;

//在你面前有一个n阶的楼梯(n>=100且n<500)，你一步只能上1阶或3阶。
//请问计算出你可以采用多少种不同的方式爬完这个楼梯（到最后一层为爬完）。
public class 爬楼梯2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(helper(n));
    }

    public static String helper(int n) {
        if (n==1 || n==2 ) return "1";
        if (n==3 ) return "2";

        String tmp1 = "1";
        String tmp2 = "1";
        String tmp3 = "2";

        int idx = 4; String rs = "";
        while( idx <= n){
            rs = addString(tmp1,tmp3);
            tmp1 = tmp2;
            tmp2 = tmp3;
            tmp3 = rs;
            idx += 1;
        }
        return rs;
    }

    public static String addString(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[] res = new int[Math.max(len1,len2)+1];
        int len = res.length; int tmp = 0;
        for(int i = len1-1,j=len2-1,k=len-1;i>=0||j>=0;i--,j--,k--){
            int num1 = i>=0?(s1.charAt(i)-'0'):0;
            int num2 = j>=0?(s2.charAt(j)-'0'):0;
            int sum = num1 + num2 + tmp;
            res[k] = sum%10;
            tmp = sum /10;
        }
        res[0] = tmp;
        StringBuilder sb = new StringBuilder();
        if(res[0] != 0) sb.append(res[0]);
        for (int i = 1; i < len; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
