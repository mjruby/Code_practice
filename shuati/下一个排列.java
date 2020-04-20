package leetcode;
// 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//必须原地修改，只允许使用额外常数空间。
//
//以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1

import java.util.Arrays;

public class 下一个排列 {
    public static void main(String[] args) {
        int times = 20;
        while(times-- > 0){
            int len = (int)(Math.random()*8);  // 长度限制最长不超过8
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = (int)(Math.random()*8); // 每一位的数值设置
            }
            System.out.println(Arrays.toString(nums));
            nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
            System.out.println("=================================");
        }

//        int[] arr = new int[]{3,2,1};
//        nextPermutation(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        int idx = len-2;
        while(idx >= 0){
            if(nums[idx] >= nums[idx+1]){
                idx--;
            }else {
                break;
            }
        }
        if(idx == -1){
            Arrays.sort(nums);
            return;
        }
        Arrays.sort(nums,idx+1,len);
        int cur = idx +1;
        while(nums[cur] <= nums[idx]){
            cur++;
        }
        int tmp = nums[idx];
        nums[idx] = nums[cur];
        nums[cur] = tmp;
        return;
    }
}
