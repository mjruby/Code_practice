package offer;

import java.util.HashMap;

// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
// 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> count = new HashMap<>();
        int len = array.length;
        if(len == 1) return array[0];   // 【注意特例】要考虑长度为1的数组
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i];
            if(count.containsKey(tmp)){
                count.put(tmp,count.get(tmp)+1);
                if(count.get(tmp) > len/2) return tmp;
            }else {
                count.put(tmp,1);
            }
        }
        return 0;
    }


    // other 思路：对数组进行排序，查找中间数，然后统计中间数出现的次数是否大于一半
    // other 思路：阵营思想，最后还是要检查结果数是否出现次数大于一半
}
