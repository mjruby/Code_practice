package leetcode;
// 编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"
//示例 2:
//
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        String[] tmp = {"aa","a"};
        String[] tmp1 = null;
        System.out.println(longestCommonPrefix(tmp1));
        System.out.println("abc".substring(0,2)); // ab
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length ==0) return "";
        int len = strs.length;
        String str = strs[0];
        String res ="";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 1; j < len; j++) {
                if(i >= strs[j].length()) return res;
                if(ch != strs[j].charAt(i)){
                    return res;
                }
            }
            res = res+ch;
        }
        return res;
    }
}
