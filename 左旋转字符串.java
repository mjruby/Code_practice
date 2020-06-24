package offer;

import java.util.ArrayList;

public class 左旋转字符串 {
    public static void main(String[] args) {
        String str = "";
        int n = 10;
        System.out.println(LeftRotateString(str,n));
    }

    // 用了太多循环，思路不太好
    public static String LeftRotateString1(String str,int n) {
        if(str.length() == 0) return str;
        char[] chs = str.toCharArray();
        ArrayList<Character> ls = new ArrayList<>();
        for (int i = 0; i < chs.length; i++) {
            ls.add(chs[i]);
        }
        for (int i = 0; i < n; i++) {
            ls.add(ls.remove(0));
        }
        String rs = "";
        for (int i = 0; i < ls.size(); i++) {
            rs+=ls.get(i);
        }
        return rs;
    }

    // other:
    public static String LeftRotateString(String str,int n) {
        if(str.length() <= n || str.length() ==0)
            return str;
        return str.substring(n)+str.substring(0,n);
    }

}
