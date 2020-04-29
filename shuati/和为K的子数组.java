package leetcode;
// 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
//示例 1 :
//
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

import java.util.Arrays;
import java.util.HashMap;

public class 和为K的子数组 {

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,-1,1};
//        int k = 0;
//        System.out.println(subarraySum1(nums,k)); // 1

        int times = 20;
        while(times-- > 0){
            int len = (int)(Math.random()*8);  // 长度限制最长不超过8
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = (int)(Math.random()*8); // 每一位的数值设置
            }
            System.out.println(Arrays.toString(nums));
            System.out.println(subarraySum(nums,3));
            System.out.println(subarraySum1(nums,3));
            System.out.println("===========================");
        }
    }

    // 前缀和数组   O(n^2)
    public static int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length ==0) return 0;
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                if(preSum[j] - preSum[i] == k)
                    count++;
            }
        }
        return count;
    }

    // 前缀和数组  + hash表    O(n)
    public static int subarraySum1(int[] nums, int k) {
        if(nums == null || nums.length ==0) return 0;
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);  // base case
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
            int tmp = preSum[i+1] - k;
            if(map.containsKey(tmp)){
                count+=map.get(tmp);
            }
            map.put(preSum[i+1],map.containsKey(preSum[i+1])?map.get(preSum[i+1])+1:1);
        }
        return count;
    }

}
