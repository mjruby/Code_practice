package offer;

// 52 + 4(大小王各有两张)

import java.util.Comparator;
import java.util.TreeSet;

// 【关键理解题目】 只需要判断抽到的5张牌是否可以组成顺子
public class 扑克牌顺子 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,0};
        System.out.println(isContinuous(arr));
    }

    // 默认找到的牌是符合要求的
    public static boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        if(len !=5) return false;
        TreeSet<Integer>  set = new TreeSet<>(); // 有序集合，对于Integer型，它自动排序
        int count=0; // 记录大小王的牌数
        for (int i = 0; i < len; i++) {
            if(numbers[i] == 0){
                count++;
            }else {
                set.add(numbers[i]);
            }
        }
        if((count+set.size())!=5 || (set.last() -set.first())>4){
            return false;
        }
        return true;
    }

}
