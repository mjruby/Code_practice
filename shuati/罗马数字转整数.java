package leetcode;
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
//C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
public class 罗马数字转整数 {
    public static void main(String[] args) {
        String str = "LVIII";
//        str = "III";
//        str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }

    public static int romanToInt(String s) {
        int res = 0;

        int len = s.length();
        for (int i = 0; i < len; i++) {
            res = res + match(s.charAt(i));
        }

        if(s.indexOf("IV") != -1){res = res - 2;}
        if(s.indexOf("IX") != -1){res = res - 2;}
        if(s.indexOf("XL") != -1){res = res - 20;}
        if(s.indexOf("XC") != -1){res = res - 20;}
        if(s.indexOf("CD") != -1){res = res - 200;}
        if(s.indexOf("CM") != -1){res = res - 200;}

        return res;

    }

    // 字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    public static int match(char ch){
        int tmp = 0;
        switch (ch){
            case 'I': tmp = 1;break;
            case 'V': tmp = 5;break;
            case 'X': tmp = 10;break;
            case 'L': tmp = 50;break;
            case 'C': tmp = 100;break;
            case 'D': tmp = 500;break;
            case 'M': tmp = 1000;break;
            default: break;
        }
        return tmp;
    }
}
