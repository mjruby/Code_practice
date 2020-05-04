package leetcode;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个无重复元素的数组 candidates 和一个目标数 target ，
// 找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的数字可以无限制重复被选取。
//说明：
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。 
//示例 1:
//输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
public class 组合总和 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> ls = combinationSum(nums,target);
        System.out.println(ls);

//        List<Integer> ls = new ArrayList<>();
//        ls.add(1);
//        ls.add(2);
//        System.out.println(ls);
//        ArrayList<Integer> lss = new ArrayList<>(ls);
//        System.out.println(lss);
    }

//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> results = new ArrayList<>();
//        if(candidates == null || candidates.length == 0) return results;
//        Arrays.sort(candidates);
//        combinationSumHelper(candidates,target,0,results,new ArrayList<>());
//        return results;
//    }
//
//    private static void combinationSumHelper(int[] candidates, int target, int index,
//                                             List<List<Integer>> results, ArrayList<Integer> curSeq) {
//        if(target == 0){
//            results.add(new ArrayList<Integer>(curSeq));
//        }else if(target > 0){
//            for(int i = index;i < candidates.length;i++){  // index 避免出现相同集合
//                if(candidates[i]>target) break;
//                curSeq.add(candidates[i]);
//                combinationSumHelper(candidates,target-candidates[i],i,results,curSeq);
//                curSeq.remove(curSeq.size()-1);
//            }
//        }
//    }




    // 第二次
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return ls;
        Arrays.sort(candidates);
        List<Integer> track = new ArrayList<>();
        helper(candidates,0,target,track,ls);
        return ls;
    }

    private static void helper(int[] candidates, int start, int target, List<Integer> track, List<List<Integer>> ls) {
        if(target == 0){
            ls.add(new ArrayList<>(track));
        }else {
            for (int i = start; i < candidates.length; i++) {
                if(candidates[i] > target) break;
                track.add(candidates[i]);
                helper(candidates,i,target - candidates[i],track,ls);
                track.remove(track.size()-1);
            }
        }
    }
}
