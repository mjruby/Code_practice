package leetcode;
// 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
// 并返回移除后数组的新长度。
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

//示例 1:
//给定 nums = [3,2,2,3], val = 3,
//函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

import java.util.Arrays;

public class 移除元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,3};
        int val= 2;
        System.out.println(removeElement(arr,val));
    }

    public static int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0) return 0;
        int len= nums.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }
}
