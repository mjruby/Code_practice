package leetcode;

import java.util.ArrayList;
import java.util.List;

// 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//示例:
//
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class 全排列 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ls = permute(nums);
        System.out.println(ls);
    }

    // 回溯算法，，，决策路径，选择列表，结果（符合条件的决策路径）
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return ls;

        List<Integer> track = new ArrayList<>();
        helper(nums,track,ls);
        return ls;
    }

    private static void helper(int[] nums, List<Integer> track, List<List<Integer>> ls) {
        if(track.size() == nums.length) {
            ls.add(new ArrayList<>(track));
//            ls.add(track);
        }else {
            for (int num : nums) {
                // choose
                if(track.contains(num))
                    continue;
                track.add(num);
                helper(nums,track,ls);
                // unchoose
                track.remove(track.size()-1);
            }
        }
    }
}
