package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的每个数字在每个组合中只能使用一次。
//
//说明：
//所有数字（包括目标数）都是正整数。
//解集不能包含重复的组合。 
//示例 1:
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
public class 组合总和_II {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> rs = combinationSum2(candidates, target);
        System.out.println(rs);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return  ls;

        List<Integer> track = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        helper(candidates,0,track,target,ls);
        return ls;
    }

    private static void helper(int[] candidates, int start,List<Integer> track, int target, List<List<Integer>> ls) {
        if(target == 0){
            if(!ls.contains(new ArrayList<>(track)))
                ls.add(new ArrayList<>(track));
        }else {
            for (int i = start; i < candidates.length; i++) {
                if(candidates[i] > target) break;
                track.add(candidates[i]);
                helper(candidates,i+1,track,target-candidates[i],ls);
                track.remove(track.size()-1);
            }
        }
    }
}
