package leetcode;

// 实现 strStr() 函数。
//
//给定一个 haystack 字符串和一个 needle 字符串，
// 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
// 如果不存在，则返回  -1。

public class 实现strStr {
    public static void main(String args[]){
        String str = "hello";
        String ne = "hh";
        System.out.println(strStr(str,ne));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

    }
}
