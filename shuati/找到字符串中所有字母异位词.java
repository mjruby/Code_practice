package leetcode;
// 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

//字母异位词指字母相同，但排列不同的字符串。
//不考虑答案输出的顺序。
//示例 1:
//输入:
//s: "cbaebabacd" p: "abc"
//输出:
//[0, 6]

import java.util.*;

public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "cd";
        System.out.println(findAnagrams(s,t));
    }

    public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> ls = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() < t.length()) return ls;
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
            s_map.put(ch,s_map.getOrDefault(ch,0)+1);
//            if(s_map.containsKey(ch)){
//                s_map.put(ch,s_map.get(ch)+1);
//            }else {
//                s_map.put(ch,1);
//            }
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
                if(s.substring(left-1,right).length() == t.length())
                    ls.add(left-1);
            }
        }
        return ls;
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
