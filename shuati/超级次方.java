package leetcode;

import java.util.Arrays;

// 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
//
//示例 1:
//
//输入: a = 2, b = [3]
//输出: 8
//示例 2:
//
//输入: a = 2, b = [1,0]
//输出: 1024
public class 超级次方 {
    static int base = 1337;
    public static void main(String[] args) {
        int a = 8;
        int[] b = {1,0};
        System.out.println(superPow(a,b));
    }

    // 递归
    public static int superPow(int a, int[] b) {
        if(b.length == 0) return 1;

        int last = b[b.length - 1];
        int[] new_b = Arrays.copyOf(b, b.length - 1);

        int part1 = myPow1(a, last);
        int part2 = myPow1(superPow(a, new_b), 10);
        return part1*part2%base;
    }

    // 普通写法
    private static int myPow(int x, int n) {
        int res = 1;
        x = x % base;
        for (int i = 0; i < n; i++) {
            res *= x;
            res %= base;
        }
        return res;
    }

    // 递归写法  -- 公式推导而来
    private static int myPow1(int x, int n) {
        if(n == 0) return 1;
        x = x % base;
        if(n % 2 == 1)  // n 为奇数
            return  x * myPow1(x,n-1) % base;
        // n 为偶数
        int tmp = myPow1(x, n / 2) % base;
        return tmp * tmp % base;
    }


    // 快速幂算法,幂指数是整数，这里数组可能已经超过数值范围
}
