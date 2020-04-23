package leetcode;
// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//你可以假设除了整数 0 之外，这个整数不会以零开头。

import java.util.Arrays;

public class 加一 {
    public static void main(String[] args) {
        int times = 20;
        while(times-- > 0){
            int len = (int)(Math.random()*8);  // 长度限制最长不超过8
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = (int)(Math.random()*10); // 每一位的数值设置
            }
            System.out.println(Arrays.toString(nums));
            System.out.println(Arrays.toString(plusOne(nums)));
            System.out.println("===========================");
        }

//        int[] arr = new int[]{3, 1, 9, 2, 8}; // 9
//        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1 ;
        int len = digits.length;
        int tmp = 0;
        for (int i = len-1; i>=0; i--) {
            tmp = digits[i];
            digits[i] = (tmp + carry) % 10;
            carry = (tmp + carry) / 10;
        }
        if(carry == 0) return digits;
        else{
            int[] arr = new int[len+1];
            arr[0] = carry;
            for (int i = 1; i <= len; i++) {
                arr[i] = digits[i-1];
            }
            return arr;
        }
    }

}
