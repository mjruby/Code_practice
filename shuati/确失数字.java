package leetcode;
// 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
//示例 1:
//
//输入: [3,0,1]
//输出: 2
//示例 2:
//
//输入: [9,6,4,2,3,5,7,0,1]
//输出: 8

public class 确失数字 {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber1(nums));
    }

    // 方法一：异或运算（交换律，结合律）
    public static int missingNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int res = 0;
        res ^= n;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    // 方法二：和 运算（交换律，结合律）
    public static int missingNumber1(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int res = 0;
        res += n - 0;
        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        return res;
    }
}
