package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
public class 子集_II {
    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4}; // [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
        // [[],[4],[4,4],[4,4,4],[1],[4,1],[4,4,1],[4,4,4,1],[4,4,4,4],[1,4],[4,1,4],[4,4,1,4],[4,4,4,1,4]]
        List<List<Integer>> rs = subsetsWithDup(nums);
        System.out.println(rs);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(new ArrayList<>());

        Arrays.sort(nums);
        int left = 0,right = 0,len = 0;
        for (int i = 0; i < nums.length; i++) {
            if( i > 0 && nums[i] == nums[i-1])   // 优化
                left = ls.size() - len;
            else left = 0;
            right = ls.size();
            len = right - left;
            for (int j = left; j < right; j++) {
                List<Integer> tmp = new ArrayList<>(ls.get(j));
                tmp.add(nums[i]);
                ls.add(tmp);
            }
        }


        //        for (int i = 0; i < nums.length; i++) {
//            int size = ls.size();
//            for (int j = 0; j < size; j++) {
//                List<Integer> tmp = new ArrayList<>(ls.get(j));
//                tmp.add(nums[i]);
//                if(!ls.contains(tmp))
//                    ls.add(tmp);
//            }
//        }
        return ls;
    }
}
