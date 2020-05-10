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
        String str = "babad";
        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindrome1(str));
//        System.out.println(isPalindrome("cabad",2,2));
    }

    // 动态规划  不是最优
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


    // 解法二
    public static String longestPalindrome1(String s) {
        if(s.length() == 0) return "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = isPalindrome(s, i, i);
            String s2 = isPalindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // 返回以mid为中点的回文串
    public static String isPalindrome(String s,int mid_l,int mid_r){
        while (mid_l >= 0 && mid_r <= s.length()-1 && s.charAt(mid_l) == s.charAt(mid_r)){
            mid_l--; mid_r++;
        }
        return s.substring(mid_l+1,mid_r);
    }
}
