package leetcode;

import javax.lang.model.element.NestingKind;
import java.util.HashMap;

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
//
//        String str = "bbbbb";
//        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring1(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int len = s.length();
        int left = 0, right = 1;
        int maxRes = 0;
        boolean[] visited = new boolean[128];  // ascii表
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

    // 知识点：滑动窗口
    public static int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int countLen = 0;
        while (right < s.length()){
            char tmp = s.charAt(right);
            if( !map.containsKey(tmp) || (map.containsKey(tmp) && map.get(tmp) == 0)){
                map.put(tmp,1);
                right++;
                countLen = Math.max((right-left),countLen);
            }else {
                map.put(s.charAt(right),map.get(s.charAt(right))+1);
                char ch = s.charAt(left);
                while (map.get(ch) != 2){
                    map.put(ch,map.get(ch)-1);
                    ch = s.charAt(++left);
                }
                map.put(s.charAt(left),0);
                left++;
            }
        }
        return countLen;
    }
}
