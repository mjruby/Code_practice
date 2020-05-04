package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//示例:
//输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class 全排列_II {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> rs = permuteUnique(nums);
        System.out.println(rs);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return ls;

        List<Integer> track = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums,visited,track,ls);
        return ls;
    }


    private static void helper(int[] nums,boolean[] visited, List<Integer> track, List<List<Integer>> ls) {
        if(track.size() == nums.length){
            if(!ls.contains(track))
                ls.add(new ArrayList<>(track));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(visited[i] == true) continue;
                track.add(nums[i]);
                visited[i] = true;
                helper(nums,visited,track,ls);
                visited[i] = false;
                track.remove(track.size()-1);
            }
        }
    }


    //   错误
//    private static void helper(int[] nums,List<Integer> choices, List<Integer> track, List<List<Integer>> ls) {
//        if(track.size() == nums.length){
//            ls.add(new ArrayList<>(track));
//        }else {
//            for (Integer choice : choices) {
//                Integer tmp = choice;
//                track.add(choice);
//                choices.remove(choice);
//                helper(nums,choices,track,ls);
//                track.remove(track.size() - 1);
//                choices.add(tmp);
//            }
//        }
//    }
}
