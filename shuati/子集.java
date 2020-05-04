package leetcode;
// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。

//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class 子集 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> rs = subsets(nums);
        System.out.println(rs);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = ls.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(ls.get(j));  // 重要**************************
//                List<Integer> tmp = ls.get(j);   // 错误
                tmp.add(nums[i]);
                ls.add(tmp);
//                ls.add(new ArrayList<>(tmp));
            }
        }
        return ls;
    }

}
