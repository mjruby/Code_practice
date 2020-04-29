package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//
//示例：
//输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
public class 最小覆盖子串 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "AN";
        System.out.println(minWindow(s,t));
    }

    // 知识点:滑动窗口
    public static String minWindow(String s, String t) {
        if(s== null || t == null || s.length() == 0 || t.length() ==0 || t.length() > s.length()) return "";
        int left = 0;
        int right = 0;
        // 子串t
        HashMap<Character,Integer> t_map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(t_map.containsKey(ch)){
                t_map.put(ch,t_map.get(ch)+1);
            }else {
                t_map.put(ch,1);
            }
        }

        // 滑动开始
        HashMap<Character,Integer> s_map = new HashMap<>();
        Set<String> set = new HashSet<>();
        while (right < s.length()){
            char ch = s.charAt(right++);
            if(s_map.containsKey(ch)){
                s_map.put(ch,s_map.get(ch)+1);
            }else {
                s_map.put(ch,1);
            }
            // 窗口已经包含所有需求元素
            if(isMatch(s_map, t_map)){
                while(left < right){
                    ch = s.charAt(left);
                    if(isMatch(s_map,t_map)){
                        s_map.put(ch,s_map.get(ch)-1);
                        left++;
                    }else {
                        break;
                    }
                }
                set.add(s.substring(left-1,right));
            }
        }
        if(set.size() == 0) return "";
        String res = s;
        for (String str : set) {
            res = str.length() < res.length()? str:res;
        }
        return res;
    }

    public static boolean isMatch(HashMap<Character,Integer> s,HashMap<Character,Integer> t){
        Set<Character> keys = t.keySet();
        for (Character key : keys) {
            if(!s.containsKey(key) || s.get(key) < t.get(key))
                return false;
        }
        return true;
    }
}
