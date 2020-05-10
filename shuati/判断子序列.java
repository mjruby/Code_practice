package leetcode;
// 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
// 示例 1:
//s = "abc", t = "ahbgdc"
//
//返回 true.
//
//示例 2:
//s = "axc", t = "ahbgdc"
//
//返回 false.

import java.util.ArrayList;
import java.util.Arrays;

// "axc"
//"ahbgdc"
public class 判断子序列 {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));

        // 扩展
        String[] str = new String[]{"axc","abc"};
        System.out.println(Arrays.toString(isSubsequence(str,t)));
    }

    public static boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) return false;
        int len = t.length();
        int j = 0,i = 0;
        for ( ; i < s.length(); ) {
            if(s.charAt(i) == t.charAt(j)) i++;
            j++;
            if(j >= len) break;
        }
        return i == s.length();
    }

    // 判断多个字符串和t字符串的匹配问题
    public static boolean[] isSubsequence(String[] s, String t) {
        boolean[] res = new boolean[s.length];
        // 对t预处理，构造数据字典 256
        ArrayList<Integer>[] dicts = new ArrayList[256];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(dicts[ch] == null){
                dicts[ch] = new ArrayList<Integer>();
            }
            dicts[ch].add(i);
        }

        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            int j = 0, k = 0;
            for ( ; k < str.length();k++ ) {
                char ch = str.charAt(k);
                if(dicts[ch] == null){
                    break;
                }
                int idx = left_bound(dicts[ch], j);
                if(idx == dicts[ch].size()){
                    break;
                }
                j = dicts[ch].get(idx) + 1;
            }
            if(k == str.length()) res[i] = true;
            else res[i] = false;
        }
        return res;
    }

    public static int left_bound(ArrayList<Integer> dict, int t){
        int left = 0 ;
        int right = dict.size();
        while (left < right){
            int mid = left + (right - left)/2;
            if(dict.get(mid) == t){
                right = mid;
            }else if(dict.get(mid) < t){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

}
