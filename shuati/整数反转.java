package leetcode;
// 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//示例 1:
//
//输入: 123
//输出: 321
// 示例 2:
//
//输入: -123
//输出: -321

public class 整数反转 {
    public static void main(String[] args) {
        int num = -123;
        System.out.println(reverse(num));
    }

    public static int reverse(int x) {
        int res = 0;
        while(x!=0){
            int newRes = res*10 + x%10;
            if((newRes-x%10)/10 != res){   // 判断是否溢出
                return 0;
            }
            res = newRes;
            x = x/10;
        }
        return res;
    }
}
