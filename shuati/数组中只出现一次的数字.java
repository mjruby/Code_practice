package offer;

import java.util.ArrayList;
import java.util.Arrays;

// 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class 数组中只出现一次的数字 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 6, 4, 5, 4, 8, 8};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    // 排序 -- 重复则会为0
    public static void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        int len = array.length;
        Arrays.sort(array);
        int res = 0, i = 0;
        ArrayList<Integer> ls = new ArrayList<>();
        while (i < len) {
            if (i == len - 1) {
                ls.add(array[i]);
                break;
            }
            if ((array[i] ^ array[i + 1]) == 0) {
                i = i + 2;
            } else {
                ls.add(array[i]);
                i = i + 1;
            }
        }
        num1[0] = ls.remove(0);
        num2[0] = ls.remove(0);
        return;
    }

    // other: 通过异或得到两个只出现一次的数的异或结果，然后找到结果位是1的位置，将元素组拆分成两个数组，各自异或
    //         得到最终的结果
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int res = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            res ^= array[i];
        }
        // 找到1出现的位置
        int idx = 1;
        while ((res & idx) == 0) {
            idx = (idx << 1);
        }
        // 拆分两组，各自异或
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < len; i++) {
            if ((array[i] & idx) == 0) {
                res1 ^= array[i];
            } else {
                res2 ^= array[i];
            }
        }
        num1[0] = res1;
        num2[0] = res2;
    }


    // 补充: 除了一个数出现一次，其他数都出现两次，找到只出现一次的数
    public static int FindAppearOne(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }
}
