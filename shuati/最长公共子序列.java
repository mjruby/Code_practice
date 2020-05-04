package leetcode;
// 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
//
//一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
// （也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」
// 是这两个字符串所共同拥有的子序列。
//若这两个字符串没有公共子序列，则返回 0。

public class 最长公共子序列 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "da";
        System.out.println(longestCommonSubsequence(text1,text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // base case  初始值自动为0

        // 状态转移
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                // 其实应该是max{dp[i-1][j],dp[i][j-1],dp[i-1][j-1]},但dp[i-1][j-1]肯定不会是最大
            }
        }
        return dp[len1][len2];
    }
}
