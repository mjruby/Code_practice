package leetcode;
// 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//示例 1:
//输入: 121
//输出: true
//示例 2
//输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

public class 回文数 {
    public static void main(String[] args) {
        int num = 1221;

        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int div = 1;
        int cur = x;
        while((cur/10) !=0){   // 关键的借助div,得到数字的第一个开头数字
            div = div *10;
            cur = cur/10;
        }
        cur = x;
        while(cur !=0){
            int num1 = cur/div;
            int num2 = cur % 10;
            if(num1 != num2) return false;
            cur = (cur - num1 *div)/10;
            div = div / 100;
        }
        return true;
    }
}
