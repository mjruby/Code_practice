package leetcode;
// 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
// 导致集合丢失了一个整数并且有一个元素重复。
//给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，
// 将它们以数组的形式返回。
//
//示例 1:
//输入: nums = [1,2,2,4]
//输出: [2,3]

import java.util.Arrays;

public class 错误的集合 {
    public static void main(String[] args) {
        int[] nums = {4,3,1,3};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        if(nums.length < 2) return new int[]{};
        int dup = 0; int miss= 0;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            int idx = Math.abs(nums[i-1]);
            if(nums[idx-1] < 0){
                dup = idx;
            }else {
                nums[idx-1] *= -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            if(nums[i-1] > 0){
                miss = i;
            }
        }
        return new int[]{dup,miss};
    }
}
