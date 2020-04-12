package leetcode;
// 给定一个整数数组 nums 和一个目标值 target，
// 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//  nums = [2, 7, 11, 15], target = 9

import java.util.HashMap;

public class 两数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15, 3};
        int target = 14;
        System.out.println(twoSum(nums,target)[0]);
        System.out.println(twoSum(nums,target)[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                res[0] = map.get(tmp);
                res[1] = i;
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
