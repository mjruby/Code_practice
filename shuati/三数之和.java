package leetcode;
// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
// 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]

// 如果改变先前定义的一个变量，一定要从头到尾看看在哪里有过，全部更改

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums={}; // []
        int[] nums = {1,1,1};
//        int[] nums = {-1,0,1,2,-1,-4};
//        System.out.println(nums.length);
//        System.out.println(Arrays.toString(nums));
        System.out.println(threeSum(nums));


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <3) return res;
        int len = nums.length;
        Arrays.sort(nums);
        int i = 0;
        while ( i < len -2){
            int left = i + 1;
            int right = len -1;
            int base = nums[i];
            while(left < right){
                int sum = base + nums[left]+ nums[right];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(base);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    right = moveLeft(right-1,nums);
                    left = moveRight(left+1,nums);
                }else if(sum < 0){
                    left = moveRight(left+1,nums);
                }else{
                    right = moveLeft(right-1,nums);
                }
            }
            i = moveRight(i+1,nums);
        }
        return res;
    }

    public static int moveRight(int l,int[] arr){
        while((l<arr.length-1) && arr[l] == arr[l-1]){
            l++;
        }
        return l;
    }

    public static int moveLeft(int r,int[] arr){
        while((r>0) && arr[r] == arr[r+1]){
            r--;
        }
        return r;
    }
}
