package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 解码字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = numDecoding(str);
        System.out.println(count);
    }

    public static int  numDecoding(String str){
        int len = str.length();
        int[] dp = new int[len+1];
        if(str.charAt(0) =='0'){
            return 0;
        }
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            if(str.charAt(i-1) != '0'){
                dp[i]+=dp[i-1];
            }
            if(str.charAt(i-2) == '1' || str.charAt(i-2) == '2'&& str.charAt(i-1)<'7'){
                dp[i]+=dp[i-2];
            }
        }
        return dp[len];
    }


    // other
//        public static void main(String[] args) throws IOException, IOException {
//            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//            String s = bf.readLine();
////            System.out.println(s);
//            System.out.println(numDecodings(s));
//        }
//
//        // other people
//        public static int numDecodings(String s) {
//            if (s.charAt(0) == '0') return 0;
//            int[] dp = new int[s.length() + 1];   // dp[i]表示数字串前i个数字所有的解码方案
//            dp[0] = dp[1] = 1;
//            for (int i = 2; i <= s.length(); i++) {
//                //如果该位不为'0'，说明该位单独成字母合法
//                if (s.charAt(i - 1) != '0') {
//                    dp[i] += dp[i - 1];
//                }
//                //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
//                if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
//                    dp[i] += dp[i - 2];
//                }
//            }
//            return dp[s.length()];
//        }
}

