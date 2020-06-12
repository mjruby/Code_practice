package offer;

import java.util.ArrayList;
import java.util.Arrays;

// 输入n个整数，找出其中最小的K个数。
// 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class 最小的K个数 {
    public static void main(String[] args) {
        int[] nums = {4,5,1,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(nums,4));
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> rs = new ArrayList<>();
        int len = input.length;
        if(k > len) return rs;
        Arrays.sort(input);;
        for (int i = 0; i < k; i++) {
            rs.add(input[i]);
        }
        return rs;
    }
}
