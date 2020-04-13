package leetcode;
// 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
// 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <3) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        int val = nums[0]+nums[1]+nums[2];
        while(i<len-2){
            int base = nums[i];
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = base+nums[left]+nums[right];
                if(sum == target){
                    return target;
                }else if(sum != target){
                    val = Math.abs(sum-target)<Math.abs(val-target)? sum:val;
                    if(sum > target) right--;
                    else left++;
                }
            }
            i++;
        }
        return val;
    }
}


