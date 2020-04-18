package leetcode;
// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//如果数组中不存在目标值，返回 [-1, -1]。
//
//示例 1:
//
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
//你的算法时间复杂度必须是 O(log n) 级别。
//如果数组中不存在目标值，返回 [-1, -1]。

import java.util.Arrays;

public class 在排序数组中找出元素第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return res;

        int left = 0;
        int right = nums.length -1;
        int mid = left + ((right - left) >> 1);
        while(left <= right){
            if(target == nums[mid]){
                res[0] = moveLeft(nums,mid);
                res[1] = moveRight(nums,mid);
                return res;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            mid = left + ((right - left) >> 1);
        }
        return res;
    }

    public static int moveLeft(int[] arr, int t){
        int target = arr[t];
        int idx = t;
        while (idx >= 0 && arr[idx] == target){
            idx = idx - 1;
        }
        return idx+1;
    }

    public static int moveRight(int[] arr, int t){
        int target = arr[t];
        int idx = t;
        while (idx <= arr.length -1 && arr[idx] == target){
            idx = idx + 1;
        }
        return idx-1;
    }
}
