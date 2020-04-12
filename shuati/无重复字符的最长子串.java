package leetcode;

import javax.lang.model.element.NestingKind;

// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//示例 1:
//
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//

// 关键：设置128个boolean类型数组对应这ASCII码表
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
//        String str = "abcabcbb";
//        String str = "abcdaefb";
        String str = "abcabcbb";

//        String str = "bbbbb";
//        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int len = s.length();
        int left = 0, right = 1;
        int maxRes = 0;
        boolean[] visited = new boolean[128];
        visited[s.charAt(0)] = true;
        while (right < len) {
            if (!visited[s.charAt(right)]) {
                visited[s.charAt(right)] = true;
                right++;
            } else {
                maxRes = Math.max((right - left), maxRes);
                while(left < right && s.charAt(left)!=s.charAt(right)){
                    visited[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        maxRes = Math.max((right - left), maxRes);
        return maxRes;
    }
}
