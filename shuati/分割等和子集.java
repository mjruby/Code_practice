package leetcode;
// 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//注意:
//每个数组中的元素不会超过 100
//数组的大小不会超过 200
//示例 1:
//
//输入: [1, 5, 11, 5]
//输出: true
//解释: 数组可以分割成 [1, 5, 5] 和 [11].

import java.util.Arrays;

public class 分割等和子集 {
    public static void main(String[] args) {
        // 生成随机数组
        int times = 20;
        while(times-- > 0){
            int len = (int)(Math.random()*8);  // 长度限制最长不超过8
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = (int)(Math.random()*8); // 每一位的数值设置
            }
            System.out.println(Arrays.toString(nums));
            System.out.println(canPartition(nums));
            System.out.println("===========================");
        }

//        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0 ;
        for (int num : nums) {
            sum += num;
        }
        if( sum % 2 == 1) return false;
        int nrow = nums.length;
        int ncol = sum/2;
        boolean[][] dp = new boolean[nrow+1][ncol+1];
        for (int i = 0; i <= nrow; i++) {
            dp[i][0] = true;
        }
        for(int i = 1;i<=nrow;i++){
            for(int j = 1;j<=ncol;j++){
                // 检查边界
                if(j < nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 选择装入或者不装入
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nrow][ncol];
    }
}
