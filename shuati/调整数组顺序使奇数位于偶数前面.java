package offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,6,8,7};
        System.out.println(Arrays.toString(nums));
        reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void reOrderArray(int [] array) {
        int len = array.length;
        int[] tmp = new int[len];
        Queue<Integer> idx_j= new LinkedList<>();
        Queue<Integer> idx_o = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if(array[i] % 2 == 1) idx_j.add(i);
            else idx_o.add(i);
        }
        for (int i = 0; i < len; i++) {
            if (!idx_j.isEmpty()) tmp[i] = array[idx_j.remove()];
            else tmp[i] = array[idx_o.remove()];
        }
        for (int i = 0; i < len; i++) {
            array[i] = tmp[i];
        }
    }
}
