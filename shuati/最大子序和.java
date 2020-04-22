package leetcode;
// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//示例:
//
//输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

import java.util.Arrays;

public class 最大子序和 {
    public static void main(String[] args) {
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxSubArray(nums));

        int times = 20;
        while (times-- > 0) {
            int len = (int) (Math.random() * 8);  // 长度限制最长不超过8
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = (int) (Math.random() * 8); // 每一位的数值设置
            }
            System.out.println(Arrays.toString(nums));
            System.out.println(maxSubArray(nums));
            System.out.println("===========================");
        }
    }

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;
        int total = 0;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            total = total + nums[i];
            max = Math.max(max,total);
            if(total <= 0){
                total = 0;
                continue;
            }
        }
        return max;
    }
}
