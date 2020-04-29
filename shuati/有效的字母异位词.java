package leetcode;

import java.util.HashMap;
import java.util.Set;

// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//示例 1:
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//
//输入: s = "rat", t = "car"
//输出: false
public class 有效的字母异位词 {
    public static void main(String[] args) {
        String s = "zanagramzanagramzanagramzanagramzanagramzanagramzanagramzanagramzanagramzanagram";
        String t = "wanagarmzanagramzanagramzanagramzanagramzanagramzanagramzanagramzanagramzanagram";
        System.out.println(isAnagram(s,t));
        System.out.println(isAnagram1(s,t));
    }

    // 字母表 通过
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] words_s = new int[26];
        int[] words_t = new int[26];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            idx = s.charAt(i) - 'a';
            words_s[idx]++;
        }
        for (int i = 0; i < t.length(); i++) {
            idx = t.charAt(i) - 'a';
            words_t[idx]++;
        }
        for(int i = 0 ; i< 26;i++){
            if(words_s[i]!= words_t[i]){
                return false;
            }
        }
        return true;
    }

    // 没通过， 和滑动窗口一样，大样本报错
    public static boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> s_map = new HashMap<>();
        HashMap<Character,Integer> t_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(s_map.containsKey(ch)){
                s_map.put(ch,s_map.get(ch)+1);
            }else {
                s_map.put(ch,1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(t_map.containsKey(ch)){
                t_map.put(ch,t_map.get(ch)+1);
            }else {
                t_map.put(ch,1);
            }
        }
        Set<Character> keys = s_map.keySet();
        for (Character key : keys) {
            if(!t_map.containsKey(key) || s_map.get(key)!=t_map.get(key)){
                return false;
            }
        }
        return true;
    }
}
