package leetcode;

import java.util.Arrays;
import java.util.Random;

// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//你可以假设数组中无重复元素。
//
//示例 1:
//输入: [1,3,5,6], 5
//输出: 2
//示例 2:
//输入: [1,3,5,6], 2
//输出: 1
//示例 3:
//输入: [1,3,5,6], 7
//输出: 4
public class 搜索插入位置 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,5,6};
//        int target = 0;
//        int[] nums1 = null;
//        System.out.println(searchInsert(nums,target));
        System.out.println("+++++++++++++++test++++++++++++++++++");
        int times = 20;
        while(times-- > 0){
            int len = (int)(Math.random()*8);  // 长度限制最长不超过8
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = (int)(Math.random()*8); // 每一位的数值设置
            }
            int target = (int)(Math.random()*10);
            Arrays.sort(nums);
            System.out.println("数组： "+Arrays.toString(nums));
            System.out.println("target:" + target);
            System.out.println(searchInsert(nums,target));
            System.out.println();
        }
    }

    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        int mid = left + ((right - left) >> 1);
        while (left <= right){
            if(target == nums[mid]) return mid;
            if(target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            mid = left + ((right - left) >> 1);
        }
        if(mid == -1) return 0;           // 最后这里错了好多次
        if( target > nums[mid]) return mid + 1;
        if(mid == 0) return 0;
        if( target < nums[mid]) return mid - 1;
        return mid;
    }

    public static int[] randomNums(int range,int len){
//        int len_tmp = Math.random();
        return null;
    }
}
