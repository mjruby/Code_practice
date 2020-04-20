package leetcode;
// 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//示例 1：
//
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//示例 2：
//
//输入: "cbbd"
//输出: "bb"

public class 最长回文子串 {
    public static void main(String[] args) {
        String str = "bcdab";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        int len = s.length();
        int start = 0 ;
        int end = 0;
        boolean[][] isPali = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isPali[i][i] = true;
        }
        for(int i = 0 ; i < len -1 ;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                isPali[i][i+1] = true;
                start = i;
                end = i+1;
            }
        }
        for(int l = 3; l<=len;l++){
            for(int idx = 0;idx <= len - l;idx++){
                if((s.charAt(idx) == s.charAt(idx+l-1)) && isPali[idx+1][idx+l-2]){
                    isPali[idx][idx+l-1] = true;
                    start = idx;
                    end = idx+l -1;
                }
            }
        }
        return s.substring(start,end+1);
    }
}
