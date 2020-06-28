package offer;

import java.lang.module.FindException;

// 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
// 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
public class 第一个只出现一次的字符位置 {
    public static void main(String[] args) {
        String str = "";
        System.out.println(FirstNotRepeatingChar(str));
    }
    public static int FirstNotRepeatingChar(String str) {
        if(str.length() == 0) return -1;
        char[] chs = str.toCharArray();
        int[] idx = new int[256];
        for (char ch : chs) {
            idx[ch] = idx[ch] + 1;
        }
        for (int i = 0; i < chs.length; i++) {
            if(idx[chs[i]]==1){
                return i;
            }
        }
        return -1;
    }
}
