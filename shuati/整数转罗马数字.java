package leetcode;
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
//
//示例 1:
//
//输入: 3
//输出: "III"
//示例 2:
//
//输入: 4
//输出: "IV"
//示例 3:
//
//输入: 9
//输出: "IX"

// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000

// 示例 5:
//输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4.

public class 整数转罗马数字 {
    public static void main(String[] args) {
        int num = 1994;
//        int num = 101;
        System.out.println(intToRoman(num));

    }


    public static String intToRoman(int num) {
        int div = 1;
        int tmp = num;
        String res = "";
        while ((tmp = tmp / 10) != 0) {
            div = div * 10;
        }
        while (num != 0) {
            tmp = num / div;
            res = res + append(tmp * div);
            num = num - tmp * div;
            div = 1;
            int newTmp = num;
            while ((newTmp = newTmp / 10) != 0) {
                div = div * 10;
            }
        }
        return res;
    }

    public static String append(int num) {
        if (num == 4) return "IV";
        if (num == 9) return "IX";
        if (num == 40) return "XL";
        if (num == 90) return "XC";
        if (num == 400) return "CD";
        if (num == 900) return "CM";

        if (num == 1) return "I";
        if (num == 2) return "II";
        if (num == 3) return "III";
        if (num == 5) return "V";
        if (num == 6) return "VI";
        if (num == 7) return "VII";
        if (num == 8) return "VIII";

        if (num == 10) return "X";
        if (num == 20) return "XX";
        if (num == 30) return "XXX";
        if (num == 50) return "L";
        if (num == 60) return "LX";
        if (num == 70) return "LXX";
        if (num == 80) return "LXXX";

        if (num == 100) return "C";
        if (num == 200) return "CC";
        if (num == 300) return "CCC";
        if (num == 500) return "D";
        if (num == 600) return "DC";
        if (num == 700) return "DCC";
        if (num == 800) return "DCCC";


        if (num == 1000) return "M";
        if (num == 2000) return "MM";
        if (num == 3000) return "MMM";
        return null;
    }
}
